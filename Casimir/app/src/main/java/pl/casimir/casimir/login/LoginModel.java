package pl.casimir.casimir.login;


import android.content.SharedPreferences;

/**
 * Created by hp on 2017-02-26.
 */

public class LoginModel {

    private SharedPreferences sharedPrefs;

    private String login, password;

    public LoginModel(){
        this.login = sharedPrefs.getString("login", "lol");
        this.password = sharedPrefs.getString("password", "lol");
    }
    boolean verify(String login, String password){

        if(login.equals(this.login) && password.equals(this.password))
            return true;
        return false;
    }
}
