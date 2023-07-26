package com.example.worldcupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private static CustomAdapter adapter;
    ArrayList<CountryModelClass> dataModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1-AdapterView:listview
        listView = findViewById(R.id.listview);
        //data source
        dataModels = new ArrayList<>();


        dataModels.add(new CountryModelClass("Germany","4",R.drawable.germany));
        dataModels.add(new CountryModelClass("France","2",R.drawable.france));
        dataModels.add(new CountryModelClass("United Kingdom","4",R.drawable.uk));
        dataModels.add(new CountryModelClass("USA","3", R.drawable.brazil));
        dataModels.add(new CountryModelClass("China","5",R.drawable.china));
        dataModels.add(new CountryModelClass("Brazil","4", R.drawable.brazil));




        //3 adapter
        adapter= new CustomAdapter(dataModels,getApplicationContext());
        listView.setAdapter(adapter);

    }
}