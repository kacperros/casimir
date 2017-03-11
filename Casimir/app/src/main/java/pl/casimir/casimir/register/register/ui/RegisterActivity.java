package pl.casimir.casimir.register.register.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.casimir.casimir.R;
import pl.casimir.casimir.register.register.mvp.RegisterPresenterImpl;
import pl.casimir.casimir.register.register.mvp.RegisterView;

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    @Inject
    RegisterPresenterImpl presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

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
