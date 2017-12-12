package com.psli.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UserInfoActivity extends AppCompatActivity {
    private EditText edName, edPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        this.edName = (EditText) findViewById(R.id.name);
        this.edPhone = (EditText) findViewById(R.id.phone);
    }

    public void done(View view) {
        String name = edName.getText().toString();
        String phone = edPhone.getText().toString();
        Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
        getSharedPreferences("atm", MODE_PRIVATE)
                .edit()
                .putString("NAME", name)
                .putString("PHONE", phone)
                .apply();
        getIntent().putExtra("USER_NAME", name);
        getIntent().putExtra("USER_PHONE", phone);
        setResult(RESULT_OK, getIntent());
        finish();
    }
}
