package pl.casimir.casimir.dagger;

import android.app.Application;

import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import pl.casimir.casimir.CasimirApplication;
import pl.casimir.casimir.SchedulerHolders;

@Module
public class AppModule {

    private CasimirApplication application;

    public AppModule(CasimirApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public CasimirApplication providesCasimirApplication() {
        return application;
    }

    @Provides
    @Singleton
    public Application providesApplication() {
        return application;
    }

    @Provides
    @Singleton
    public DependencyInjector providesDependencyInjector() {
        return new DependencyInjector();
    }

    @Provides
    @Singleton
    public SchedulerHolders providesSchedulersHolder() {
        return new SchedulerHolders(AndroidSchedulers.mainThread(), Schedulers.from(Executors.newFixedThreadPool(4)));
    }

}
