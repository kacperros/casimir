package pl.casimir.casimir;


import android.app.Application;

import javax.inject.Inject;

import pl.casimir.casimir.dagger.AppModule;
import pl.casimir.casimir.dagger.CasimirComponent;
import pl.casimir.casimir.dagger.DaggerCasimirComponent;
import pl.casimir.casimir.dagger.DependencyInjector;
import pl.casimir.casimir.dagger.PersistenceModule;

public class CasimirApplication extends Application {

    @Inject
    DependencyInjector injector;

    private CasimirComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerCasimirComponent.builder()
                .appModule(new AppModule(this))
                .persistenceModule(new PersistenceModule())
                .build();
        component.inject(this);
    }

    public CasimirComponent getComponent(){
        return component;
    }

    public DependencyInjector getInjector() {
        return injector;
    }
}
