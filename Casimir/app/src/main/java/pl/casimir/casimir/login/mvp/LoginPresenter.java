package pl.casimir.casimir.login.mvp;

/**
 * Created by hp on 2017-02-26.
 */

public class LoginPresenter {

    private LoginView view;
    private LoginModel model;

    public LoginPresenter(LoginView view, LoginModel loginModel){
        this.view = view;
        this.model = loginModel;
    }

    public void login (String login, String password){
        if(model.login(login, password))
            view.toNextActivity();
        else
            view.badLogin();
    }

    public void updateData() {
        model.update();
    }
}
