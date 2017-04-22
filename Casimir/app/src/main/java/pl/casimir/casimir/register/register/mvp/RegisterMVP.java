package pl.casimir.casimir.register.register.mvp;


import io.reactivex.Observable;
import pl.casimir.casimir.ClearDisposables;
import pl.casimir.casimir.HandleErrorInView;

public interface RegisterMVP {

    interface Model {
        Observable<Boolean> isCorrect(String login, String password1, String password2);

        void saveData(String login, String password);
    }


    interface Presenter extends ClearDisposables{

        void register(String username, String password1, String password2);


    }

    interface View extends HandleErrorInView {
        void signUp();

        void error();

    }

}
