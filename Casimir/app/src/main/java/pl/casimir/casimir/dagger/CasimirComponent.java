package pl.casimir.casimir.dagger;

import javax.inject.Singleton;

import dagger.Component;
import pl.casimir.casimir.CasimirApplication;
import pl.casimir.casimir.SchedulerHolders;
import pl.casimir.casimir.persistance.shared_prefs.SharedPreferencesFacade;

@Singleton
@Component(modules = {AppModule.class, PersistenceModule.class})
public interface CasimirComponent {

    void inject(CasimirApplication casimirApplication);

    SharedPreferencesFacade provideSharePrefsFacade();

    SchedulerHolders provideSchedulerHolders();
}
