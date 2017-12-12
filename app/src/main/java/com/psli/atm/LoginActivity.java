package com.psli.atm;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText edUserId, edPassWD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.edUserId = (EditText) findViewById( R.id.userid );
        this.edPassWD = (EditText) findViewById( R.id.passwd );
        String id = getSharedPreferences("atm", MODE_PRIVATE)
                .getString("USERID", "");
        edUserId.setText(id);
    }

    public void login(View view) {
        String id = edUserId.getText().toString();
        String pw = edPassWD.getText().toString();
        if ( "PS".equals(id) && "1234".equals(pw) ) {
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
            getIntent().putExtra("LOGIN_ID", id);
            getIntent().putExtra("LOGIN_PASSWD", pw);
            setResult(RESULT_OK, getIntent());
            finish();
        } else {
            new AlertDialog.Builder(this)
                    .setMessage("You enter wrong ID or Password.")
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    set();
                                }
                            })
                    .show();
        }
    }

    public void cancel(View view) {
        
    }

    private void set() {
        this.edUserId.setText("");
        this.edPassWD.setText("");
    }
}
