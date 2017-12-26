package com.psli.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        ListView ls_area = (ListView) findViewById(R.id.areas);
        Intent intent = getIntent();
        int city = intent.getIntExtra("CITY_EXTRA", 0);
        String[] area = null;
        switch (city) {
            case 0:
                String[] data = {"板橋區", "永和區", "新莊區"};
                area = data;
                break;
            case 1:
                String[] data2 = {"信義區", "大安區", "士林區"};
                area = data2;
                break;
            case 2:
                String[] data3 = {"中正區", "暖暖區", "八堵區"};
                area = data3;
                break;
        }
        ls_area.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, area));
    }
}
