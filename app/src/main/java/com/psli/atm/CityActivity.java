package com.psli.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CityActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView ls_city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        ls_city = (ListView) findViewById(R.id.cities);
        String[] city = {"新北市", "台北市", "基隆市"};
        ls_city.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, city));
        ls_city.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, AreaActivity.class);
        intent.putExtra("CITY_EXTRA", i);
        startActivity(intent);
    }
}
