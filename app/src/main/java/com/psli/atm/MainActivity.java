package com.psli.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean logon = false;
    public static final int PAGE_LOGIN = 102, PAGE_SET = 103, PAGE_SPINNER = 104;
    private int flag = 1;
    private String[] func = {"A", "B", "C", "D", "Exit"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!logon) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, PAGE_LOGIN);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserInfoActivity.class);
                startActivityForResult(intent, PAGE_SET);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch ( requestCode ) {
            case PAGE_LOGIN:
                if (resultCode == RESULT_OK) {
                    String id = data.getStringExtra("LOGIN_ID");
                    String pw = data.getStringExtra("LOGIN_PASSWD");
                    Log.d("RESULT", id + "/" + pw);
                    Toast.makeText(this, "Welcome, " + id, Toast.LENGTH_LONG).show();
                    getSharedPreferences("atm", MODE_PRIVATE)
                            .edit()
                            .putString("USERID", id)
                            .apply();
                } else {
                    finish();
                }
                break;
            case PAGE_SET:
                if (resultCode == RESULT_OK) {
                    String name = data.getStringExtra("USER_NAME");
                    String phone = data.getStringExtra("USER_PHONE");
                    Log.d("RESULT", name + "/" + phone);
                    Toast.makeText(this, name + ", welcome back.", Toast.LENGTH_LONG).show();
                }
                break;
            case PAGE_SPINNER:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void change(View view) {
        ImageView i_test = (ImageView) findViewById(R.id.hi);
        i_test.setImageResource(R.drawable.ic_location_city_black_36dp);
        //  借放個轉到Ch8的方法，壞消息是看來暫時不能用
        //Intent intent = new Intent(MainActivity.this, Ch8Activity.class);
        //startActivityForResult(intent, PAGE_SPINNER);
    }
}
