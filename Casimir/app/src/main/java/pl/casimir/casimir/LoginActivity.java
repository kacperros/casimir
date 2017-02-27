package pl.casimir.casimir;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.casimir.casimir.login.LoginPresenter;
import pl.casimir.casimir.login.LoginView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView{


    @BindView(R.id.login_text) EditText login_editText;
    @BindView(R.id.password_text) EditText password_editText;
    @BindView(R.id.login_button) Button logIn;

    LoginPresenter presenter;
    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new LoginPresenter(this);
        initOnClickListener();
        //sharedPref = getPreferences(Context.MODE_PRIVATE);

    }

    private void initOnClickListener() {
        logIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int click_id = v.getId();
        String login = login_editText.getText().toString();
        String password = password_editText.getText().toString();

        if(click_id == R.id.login_button){
            presenter.verifyLogin(login, password);
        }
    }

    @Override
    public void toNextActivity() {
        Toast.makeText(this, "Yo, what's up??!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void badLogin() {
        Toast.makeText(this, "Coś nie pykło", Toast.LENGTH_SHORT).show();
    }
}
