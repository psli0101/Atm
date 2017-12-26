package com.psli.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        startActivityForResult(intent, 200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String area = data.getStringExtra("AREA_EXTRA");
            Toast.makeText(this, area, Toast.LENGTH_SHORT).show();
        }
    }
}
