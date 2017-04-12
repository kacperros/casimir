package pl.casimir.casimir.login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.casimir.casimir.CasimirApplication;
import pl.casimir.casimir.R;
import pl.casimir.casimir.login.mvp.LoginMVP;
import pl.casimir.casimir.login.mvp.LoginPresenter;
import pl.casimir.casimir.register.register.ui.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements LoginMVP.View {


    @BindView(R.id.login_text)
    EditText loginEditText;
    @BindView(R.id.password_text)
    EditText passwordEditText;
    @BindView(R.id.login_button)
    Button logInButton;
    @BindView(R.id.register_button)
    Button registerButton;

    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ((CasimirApplication)getApplication()).getInjector().inject(this);
        logInButton.setOnClickListener(v -> presenter.login(loginEditText.getText().toString(), passwordEditText.getText().toString()));
        registerButton.setOnClickListener(v -> startRegisterActivity());
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.updateData();
    }

    private void startRegisterActivity() {
        Intent intent = new Intent (this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void handleError(Throwable throwable) {
        Toast.makeText(this, "Server unavailable", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccessful() {
        Toast.makeText(this, "Yo, what's up??!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed() {
        Toast.makeText(this, "Coś nie pykło", Toast.LENGTH_SHORT).show();
    }
}
