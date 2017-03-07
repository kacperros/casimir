package pl.casimir.casimir.dagger;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.casimir.casimir.persistance.shared_prefs.SharedPreferencesFacade;
import pl.casimir.casimir.persistance.shared_prefs.SharedPreferencesFacadeImpl;

@Module
public class PersistenceModule {

    private static final String PREFERENCES_NAME = "CASIMIR_PREFS";

    @Provides
    @Singleton
    public SharedPreferencesFacade provideSharedPreferencesFacade(Application application) {
        return new SharedPreferencesFacadeImpl(application.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE));
    }

}
