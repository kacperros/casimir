package pl.casimir.casimir.register.register.mvp;

import javax.inject.Inject;

import io.reactivex.Observable;
import pl.casimir.casimir.dagger.ActivityScope;
import pl.casimir.casimir.persistance.shared_prefs.SharedPreferencesFacade;

/**
 * Created by hp on 2017-03-11.
 */
@ActivityScope
public class RegisterModelImpl implements RegisterMVP.Model {

    private SharedPreferencesFacade facade;



    private static final String LOGIN = "LOGIN";
    private static final String PASSWORD = "PASSWORD";


    @Inject
    public RegisterModelImpl(SharedPreferencesFacade facade){
        this.facade = facade;
    }

    @Override
    public Observable<Boolean> isCorrect(String login, String password1, String password2) {
        return Observable.just(password1.equals(password2));
    }

    @Override
    public void saveData(String login, String password) {
        this.facade.putString(LOGIN, login);
        this.facade.putString(PASSWORD, password);
    }
}
