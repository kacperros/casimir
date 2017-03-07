package pl.casimir.casimir.login.dagger;

import dagger.Component;
import pl.casimir.casimir.dagger.ActivityScope;
import pl.casimir.casimir.dagger.CasimirComponent;
import pl.casimir.casimir.login.ui.LoginActivity;

@ActivityScope
@Component(modules = {LoginModule.class}, dependencies = {CasimirComponent.class})
public interface LoginComponent {

    void inject(LoginActivity loginActivity);

}
