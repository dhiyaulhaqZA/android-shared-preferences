package id.duza.sharedpreference;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import id.duza.sharedpreference.utils.PreferencesUtil;

/**
 * Created by duza on 20/09/16.
 */

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        TextView tvUsername = (TextView) findViewById(R.id.tv_username);
        //read userdata from sharedpreference
        String name = PreferencesUtil.readUserData(this, PreferencesUtil.KEY_USER, "Anonymous");
        tvUsername.setText("Hello, " + name + " !");
    }
}
