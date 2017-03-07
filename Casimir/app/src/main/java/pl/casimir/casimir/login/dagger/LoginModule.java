package pl.casimir.casimir.login.dagger;

import dagger.Module;
import dagger.Provides;
import pl.casimir.casimir.dagger.ActivityScope;
import pl.casimir.casimir.login.mvp.LoginModel;
import pl.casimir.casimir.login.mvp.LoginPresenter;
import pl.casimir.casimir.login.mvp.LoginView;

@Module
public class LoginModule {

    private LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    public LoginPresenter provideLoginPresenter(LoginModel loginModel) {
        return new LoginPresenter(view, loginModel);
    }
}
