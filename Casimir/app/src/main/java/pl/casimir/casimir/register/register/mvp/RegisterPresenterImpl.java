package pl.casimir.casimir.register.register.mvp;

/**
 * Created by hp on 2017-03-11.
 */

public class RegisterPresenterImpl implements RegisterPresenter {

    private RegisterView view;
    private RegisterModel model;

    public RegisterPresenterImpl(RegisterView view, RegisterModel model)
    {
        this.view = view;
        this.model = model;
    }


    @Override
    public void register(String username, String password1, String password2) {
        if(model.isCorrect()) {
            view.signUp();
        }
        else
            view.error();
    }
}
