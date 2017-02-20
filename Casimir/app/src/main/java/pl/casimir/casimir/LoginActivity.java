package pl.casimir.casimir;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initOnClickListener();
    }

    @BindView(R.id.login_text) EditText login_editText;
    @BindView(R.id.password_text) EditText password_editText;
    private void initOnClickListener() {
        findViewById(R.id.login_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int click_id = v.getId();
        String login = login_editText.getText().toString();
        String password = password_editText.getText().toString();
        if(click_id == R.id.login_button){
            if(login.equals("hehe") && password.equals("misiek123"))
                Toast.makeText(this, "Yo, what's up??!", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Coś nie pykło", Toast.LENGTH_SHORT).show();
        }
    }
}
