package com.example.railway;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class searchtrain extends AppCompatActivity {
SearchView searchView;
RecyclerView recyclerView;

ArrayList<ModelClass> arrayList=new ArrayList<>();
ArrayList<ModelClass> searchList;
    String[] trainNo=new String[]{" 11030 "," 11010 "," 11008 "," 22105 "," 22224 "," 12116 "," 12779 "," 12610 "," 11040 "," 01565 "};

String[] trainList=new String[]{"Koyna Express","Sinhagad Express","Deccan Express","Indrayani Express","CSMT Express","Siddheshwar Express","Goa Express","Chennai Express","Maharashtra Express","Lonavala-Pune Local"};

String[] stationList=new String[]{"Shivajinagar ➔ CSMT","Pune Jn ➔ CSMT","Pune Jn ➔ CSMT","CSMT ➔ Pune Jn","Nasik Road ➔ CSMT",
        "Solapur ➔ Kalyan","Satara ➔ Kopargaon","Mysuru ➔ Chennai","Nagapur ➔ Pune","Lonavala ➔ Pune"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_searchtrain);
        recyclerView=findViewById(R.id.recyclerView);
        searchView=findViewById(R.id.searchView);

        for (int i=0; i<trainNo.length; i++){
            ModelClass modelClass=new ModelClass();
            modelClass.setTrainNo(trainNo[i]);
            modelClass.setTrainName(trainList[i]);
            modelClass.setStation(stationList[i]);
            arrayList.add(modelClass);
        }

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(searchtrain.this);
        recyclerView.setLayoutManager(layoutManager);

        TrainAdapter trainAdapter=new TrainAdapter(searchtrain.this,arrayList);
        recyclerView.setAdapter(trainAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchList=new ArrayList<>();
                if (query.length()>0){
                    for (int i=0;i<arrayList.size();i++){
                        if (arrayList.get(i).getTrainNo().toUpperCase().contains(query.toUpperCase()) || arrayList.get(i).getTrainName().toUpperCase().contains(query.toUpperCase())){
                            ModelClass modelClass=new ModelClass();
                            modelClass.setTrainNo(arrayList.get(i).getTrainNo());
                            modelClass.setTrainName(arrayList.get(i).getTrainName());
                            modelClass.setStation(arrayList.get(i).getStation());
                            searchList.add(modelClass);
                        }
                    }
                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(searchtrain.this);
                    recyclerView.setLayoutManager(layoutManager);

                    TrainAdapter trainAdapter=new TrainAdapter(searchtrain.this,searchList);
                    recyclerView.setAdapter(trainAdapter);
                }
                else {
                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(searchtrain.this);
                    recyclerView.setLayoutManager(layoutManager);

                    TrainAdapter trainAdapter=new TrainAdapter(searchtrain.this,arrayList);
                    recyclerView.setAdapter(trainAdapter);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList=new ArrayList<>();
                if (newText.length()>0){
                    for (int i=0;i<arrayList.size();i++){
                        if (arrayList.get(i).getTrainNo().toUpperCase().contains(newText.toUpperCase()) || arrayList.get(i).getTrainName().toUpperCase().contains(newText.toUpperCase())){
                            ModelClass modelClass=new ModelClass();
                            modelClass.setTrainNo(arrayList.get(i).getTrainNo());
                            modelClass.setTrainName(arrayList.get(i).getTrainName());
                            modelClass.setStation(arrayList.get(i).getStation());
                            searchList.add(modelClass);
                        }
                    }
                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(searchtrain.this);
                    recyclerView.setLayoutManager(layoutManager);

                    TrainAdapter trainAdapter=new TrainAdapter(searchtrain.this,searchList);
                    recyclerView.setAdapter(trainAdapter);
                }
                else {
                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(searchtrain.this);
                    recyclerView.setLayoutManager(layoutManager);

                    TrainAdapter trainAdapter=new TrainAdapter(searchtrain.this,arrayList);
                    recyclerView.setAdapter(trainAdapter);
                }
                return false;
            }
        });
    }
}