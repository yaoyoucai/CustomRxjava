package shbd.app4.activity;


import java.util.concurrent.TimeUnit;

import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.NewThreadWorker;
import rx.internal.util.RxThreadFactory;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

public final class ContextAwareScheduler
        extends Scheduler {

    public static final ContextAwareScheduler INSTANCE =
            new ContextAwareScheduler();                       // (1)

    final NewThreadWorker worker;

    private ContextAwareScheduler() {
        this.worker = new NewThreadWorker(
                new RxThreadFactory("ContextAwareScheduler")); // (2)
    }

    @Override
    public Worker createWorker() {
        return new ContextAwareWorker(worker);                 // (3)
    }

    static final class ContextAwareWorker extends Worker {

        final CompositeSubscription tracking;                  // (4)
        final NewThreadWorker worker;

        public ContextAwareWorker(NewThreadWorker worker) {
            this.worker = worker;
            this.tracking = new CompositeSubscription();
        }

        @Override
        public Subscription schedule(Action0 action) {
            return schedule(action, 0, null);
        }

        @Override
        public Subscription schedule(final Action0 action,
                                     long delayTime, TimeUnit unit) {
            if (isUnsubscribed()) {                         // (2)
                return Subscriptions.unsubscribed();
            }

            final Object context = ContextManager.get();          // (3)
            Action0 a = new Action0() {
                @Override
                public void call() {
                    ContextManager.set(context);                // (4)
                    action.call();
                }
            };

            return worker.scheduleActual(a,
                    delayTime, unit, tracking);                 // (5)
        }

        @Override
        public boolean isUnsubscribed() {
            return tracking.isUnsubscribed();                  // (5)
        }

        @Override
        public void unsubscribe() {
            tracking.unsubscribe();
        }
    }
}