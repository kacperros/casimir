package pl.casimir.casimir.dagger;


import android.app.Activity;

import pl.casimir.casimir.CasimirApplication;
import pl.casimir.casimir.login.dagger.DaggerLoginComponent;
import pl.casimir.casimir.login.dagger.LoginModule;
import pl.casimir.casimir.login.ui.LoginActivity;
import pl.casimir.casimir.register.register.ui.RegisterActivity;

public class DependencyInjector {

    public void inject(LoginActivity loginActivity) {
        DaggerLoginComponent.builder()
                .casimirComponent(getCasimirComponent(loginActivity))
                .loginModule(new LoginModule(loginActivity))
                .build()
                .inject(loginActivity);
    }



    private CasimirComponent getCasimirComponent(Activity activity) {
        return ((CasimirApplication)activity.getApplication()).getComponent();
    }
}
