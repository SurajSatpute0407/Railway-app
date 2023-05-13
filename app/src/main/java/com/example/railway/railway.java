package com.example.railway;

import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class railway extends AppCompatActivity {
    LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4;
    Button searchstd;
Spinner From_Station,To_station;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_railway);
        searchstd=findViewById(R.id.Search);
        searchstd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(railway.this,Trainstatus.class);
                startActivity(i);
            }
        });

        From_Station = findViewById(R.id.From_Station);


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(railway.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.from));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        From_Station.setAdapter(adapter2);

        From_Station.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(railway.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        From_Station = findViewById(R.id.From_Station);


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(railway.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.from));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        From_Station.setAdapter(adapter1);

        From_Station.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(railway.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        To_station = findViewById(R.id.To_station);


        adapter2 = new ArrayAdapter<String>(railway.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.to));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        To_station.setAdapter(adapter2);

        To_station.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String value = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(railway.this, value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        linearLayout1 = findViewById(R.id.linearLayout1);
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(railway.this,searchtrain.class);
                startActivity(i);
            }
        });

        linearLayout2 = findViewById(R.id.linearLayout2);
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(railway.this,MainActivity.class);
                startActivity(i);
            }
        });

        linearLayout3 = findViewById(R.id.linearLayout3);
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(railway.this,Trainstatus.class);
                startActivity(i);
            }
        });

        linearLayout4 = findViewById(R.id.linearLayout4);
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(railway.this,searchtrain.class);
                startActivity(i);
            }
        });
    }


}