package com.psli.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Ch8Activity extends AppCompatActivity {
    private String TAG = Ch8Activity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch8);
        Spinner notify = (Spinner) findViewById(R.id.notify_spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.notify_array, android.R.layout.simple_expandable_list_item_1);
        notify.setAdapter(adapter);

    }
}
