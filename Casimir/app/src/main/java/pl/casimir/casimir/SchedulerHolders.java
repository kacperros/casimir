package pl.casimir.casimir;


import io.reactivex.Scheduler;

public class SchedulerHolders {
    private Scheduler observScheduler,subscribeScheduler;

    public SchedulerHolders(Scheduler observScheduler, Scheduler subscribeScheduler) {
        this.observScheduler = observScheduler;
        this.subscribeScheduler = subscribeScheduler;
    }

    public Scheduler observ() {
        return observScheduler;
    }

    public Scheduler subscribe() {
        return subscribeScheduler;
    }
}
