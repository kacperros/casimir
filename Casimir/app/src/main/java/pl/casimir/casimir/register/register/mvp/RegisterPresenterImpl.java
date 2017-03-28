package pl.casimir.casimir.register.register.mvp;

/**
 * Created by hp on 2017-03-11.
 */

public class RegisterPresenterImpl implements RegisterMVP.Presenter {

    private RegisterMVP.View view;
    private RegisterMVP.Model model;

    public RegisterPresenterImpl(RegisterMVP.View view, RegisterMVP.Model model)
    {
        this.view = view;
        this.model = model;
    }


    @Override
    public void register(String username, String password1, String password2) {
        if(model.isCorrect(username, password1, password2)) {
            model.saveData(username, password1);
            view.signUp();
        }
        else
            view.error();
    }
}
