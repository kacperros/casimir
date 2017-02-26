package pl.casimir.casimir.login;

/**
 * Created by hp on 2017-02-26.
 */

public class LoginPresenter {

    private LoginView view;
    private LoginInteractor interactor;

    public LoginPresenter(LoginView view){
        this.view = view;

    }

    public void verifyLogin (String login, String password){
        boolean isValid = interactor.verify(login, password);
        if(isValid)
            view.toNextActivity();
        else
            view.badLogin();
    }

}
