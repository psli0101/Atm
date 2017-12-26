package com.psli.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        edName.setText(getSharedPreferences("atm", MODE_PRIVATE)
                .getString("NAME", ""));
        edPhone.setText(getSharedPreferences("atm", MODE_PRIVATE)
                .getString("PHONE", ""));
        Button b_addr = (Button) findViewById(R.id.address);
        b_addr.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(UserInfoActivity.this, CityActivity.class);
                        startActivity(intent);
                    }
                }
        );
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
