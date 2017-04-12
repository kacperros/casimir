package pl.casimir.casimir.login.dagger;

import dagger.Module;
import dagger.Provides;
import pl.casimir.casimir.dagger.ActivityScope;
import pl.casimir.casimir.login.mvp.LoginMVP;
import pl.casimir.casimir.login.mvp.LoginModel;
import pl.casimir.casimir.login.mvp.LoginPresenter;

@Module
public class LoginModule {

    private LoginMVP.View view;

    public LoginModule(LoginMVP.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    public LoginPresenter provideLoginPresenter(LoginModel loginModel) {
        return new LoginPresenter(view, loginModel);
    }
}
