package pl.casimir.casimir.register.register.mvp;

/**
 * Created by hp on 2017-03-11.
 */

public interface RegisterModel {
    public boolean isCorrect(String login, String password1, String password2);
    public void saveData(String login, String password);
}
