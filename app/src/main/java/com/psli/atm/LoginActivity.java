package com.psli.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText edUserId = (EditText) findViewById( R.id.userid );
    private EditText edPassWD = (EditText) findViewById( R.id.passwd );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {

    }

    public void cancel(View view) {

    }
}
