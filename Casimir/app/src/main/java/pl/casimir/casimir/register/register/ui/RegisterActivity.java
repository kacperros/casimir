package pl.casimir.casimir.register.register.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.casimir.casimir.CasimirApplication;
import pl.casimir.casimir.R;
import pl.casimir.casimir.register.register.mvp.RegisterPresenter;
import pl.casimir.casimir.register.register.mvp.RegisterPresenterImpl;
import pl.casimir.casimir.register.register.mvp.RegisterView;

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    @BindView(R.id.signIn_button)
    Button registerButton;
    @BindView(R.id.username_editText)
    EditText username;
    @BindView(R.id.setPassword_editText)
    EditText setPassword;
    @BindView(R.id.confirmPassword_editText)
    EditText confirmPassword;


    @Inject
    RegisterPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        ((CasimirApplication)getApplication()).getInjector().inject(this);

        registerButton.setOnClickListener(v -> presenter.register(username.getText().toString(),
           setPassword.getText().toString(),
           confirmPassword.getText().toString()));
    }


    @Override
    public void signUp() {
        this.finish();
    }

    @Override
    public void error() {
        Toast.makeText(this, "Nieprawidłowy login lub hasło", Toast.LENGTH_LONG).show();
    }
}
