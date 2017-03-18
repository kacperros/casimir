package pl.casimir.casimir.login.mvp;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.casimir.casimir.dagger.ActivityScope;
import pl.casimir.casimir.login.ui.LoginActivity;
import pl.casimir.casimir.persistance.shared_prefs.SharedPreferencesFacade;

/**
 * Created by hp on 2017-02-26.
 */
@ActivityScope
public class LoginModel {


    private SharedPreferencesFacade sharedPreferencesFacade;
    public String login;
    public String password;

    private static final String LOGIN = "LOGIN";
    private static final String PASSWORD = "PASSWORD";

    @Inject
    public LoginModel(SharedPreferencesFacade facade) {
        this.sharedPreferencesFacade = facade;
        update();
    }

    boolean login(String login, String password) {
        return login.equals(this.login) && password.equals(this.password);
    }

    public void update() {
        this.login = sharedPreferencesFacade.getString(LOGIN);
        this.password = sharedPreferencesFacade.getString(PASSWORD);
    }
}
