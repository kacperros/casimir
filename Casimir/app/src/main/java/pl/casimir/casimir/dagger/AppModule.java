package pl.casimir.casimir.dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.casimir.casimir.CasimirApplication;

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

}
