package pl.casimir.casimir.register.register.mvp;

import javax.inject.Inject;

import pl.casimir.casimir.dagger.ActivityScope;
import pl.casimir.casimir.persistance.shared_prefs.SharedPreferencesFacade;

/**
 * Created by hp on 2017-03-11.
 */
@ActivityScope
public class RegisterModelImpl implements RegisterModel {

    private SharedPreferencesFacade facade;

    private String login;
    private String password;

    private static final String LOGIN = "LOGIN";
    private static final String PASSWORD = "PASSWORD";

    @Inject
    public RegisterModelImpl(SharedPreferencesFacade facade){
        this.facade = facade;
    }

    @Override
    public boolean isCorrect(String login, String password1, String password2) {

        return password1.equals(password2);
    }

    @Override
    public void saveData(String login, String password) {
        this.facade.putString(LOGIN, this.login);
        this.facade.putString(PASSWORD, this.password);
    }
}
