package com.example.assignment2;

import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.gridView);

        List<Country> countries = new ArrayList<>();
        countries.add(new Country("India", R.drawable.india));
        countries.add(new Country("China", R.drawable.china));
        countries.add(new Country("Australia", R.drawable.australia));
        countries.add(new Country("Portugal", R.drawable.portugal));
        countries.add(new Country("USA", R.drawable.usa));
        countries.add(new Country("New Zealand", R.drawable.newzealand));

        CountryAdapter adapter = new CountryAdapter(this, countries);
        gridView.setAdapter(adapter);
    }
}