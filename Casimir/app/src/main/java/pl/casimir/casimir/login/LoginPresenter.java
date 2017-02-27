package pl.casimir.casimir.login;

/**
 * Created by hp on 2017-02-26.
 */

public class LoginPresenter {

    private LoginView view;
    private LoginModel model;

    public LoginPresenter(LoginView view){
        this.view = view;
        this.model = new LoginModel();
    }

    public void verifyLogin (String login, String password){
        boolean isValid = model.verify(login, password);
        if(isValid)
            view.toNextActivity();
        else
            view.badLogin();
    }

}
