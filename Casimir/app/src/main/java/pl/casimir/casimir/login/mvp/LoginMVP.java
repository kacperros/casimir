package pl.casimir.casimir.login.mvp;


import io.reactivex.Observable;
import pl.casimir.casimir.ClearDisposables;
import pl.casimir.casimir.HandleErrorInView;

public interface LoginMVP {

    interface Model {
        Observable<Boolean> login(String login, String password);
    }

    interface Presenter extends ClearDisposables {
        void login(String login, String password);
    }

    interface View extends HandleErrorInView {
        void loginSuccessful();

        void loginFailed();
    }

}
