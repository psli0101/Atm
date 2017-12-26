package com.psli.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AddrActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner sp_city;
    private Spinner sp_area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addr);
        sp_city = (Spinner) findViewById(R.id.cities);
        sp_area = (Spinner) findViewById(R.id.area);
        String[] city = {"新北市", "台北市", "基隆市"};
        sp_city.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, city));
        sp_city.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String[] area = null;
        switch (i) {
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
        sp_area.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, area));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
