package pl.casimir.casimir.login;

/**
 * Created by hp on 2017-02-26.
 */

public class LoginModel {

    boolean verify(String login, String password){
        if(login.equals("misiek123") && password.equals("password"))
            return true;
        return false;
    }
}
