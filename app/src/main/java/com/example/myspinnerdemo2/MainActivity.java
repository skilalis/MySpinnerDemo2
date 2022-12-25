package com.example.myspinnerdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private String[] countryNames;
    private String[] population;
    private int[] flags= {R.drawable.afghanistan,R.drawable.armenia,R.drawable.azerbaijan,R.drawable.bahrain,R.drawable.bangladesh,R.drawable.china,R.drawable.bhutan,
            R.drawable.india,R.drawable.japan,R.drawable.nepal,R.drawable.pakistan,R.drawable.srilanka};
    private boolean isFirstSelection = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryNames = getResources().getStringArray(R.array.country_names);
        population = getResources().getStringArray(R.array.population);

        spinner = findViewById(R.id.spinnerId);
        CustomAdapter customAdapter = new CustomAdapter(this,flags,countryNames,population);
        spinner.setAdapter(customAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                if (isFirstSelection == true) {
                    isFirstSelection = false;
                }else{
                Toast.makeText(getApplicationContext(),countryNames[i]+ " is selected",
                        Toast.LENGTH_SHORT).show();

            }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}