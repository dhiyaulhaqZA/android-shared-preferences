package id.duza.sharedpreference;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.duza.sharedpreference.utils.PreferencesUtil;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //if user isLogin is true, start hello activity
        boolean isLogin = PreferencesUtil.readBooleanData(this, PreferencesUtil.KEY_LOGIN, false);
        if (isLogin)    {
            startHelloActivity();
        }

        setupView();
        setupViewListener();
    }

    private void setupViewListener() {
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loginValidation())  {
                    startHelloActivity();
                } else {
                    Toast.makeText(MainActivity.this, "Wrong data!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void startHelloActivity() {
        startActivity(new Intent(MainActivity.this, HelloActivity.class));
        finish();
    }

    /**
     * User login validation
     * @return true if data is valid, else false
     */
    private boolean loginValidation() {
        String user = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        boolean isValid = user.equals("duza") && password.equals("1234");
        if (isValid) {
            PreferencesUtil.writeUserData(MainActivity.this,
                    PreferencesUtil.KEY_USER, user);
            PreferencesUtil.writeBooleanData(MainActivity.this,
                    PreferencesUtil.KEY_LOGIN, true);
        } return isValid;
    }

    private void setupView() {
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnSignin = (Button) findViewById(R.id.btn_signin);
    }
}
