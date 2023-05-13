package com.example.railway;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrainAdapter extends RecyclerView.Adapter<TrainAdapter.Myholder>{

    Context context;
    ArrayList<ModelClass> arrayList;
    ArrayList<ModelClass> backup;
    LayoutInflater layoutInflater;

    public TrainAdapter(Context context, ArrayList<ModelClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.train_file, parent, false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        final ModelClass temp = arrayList.get(position);

        holder.trainNo.setText(arrayList.get(position).getTrainNo());
        holder.trainName.setText(arrayList.get(position).getTrainName());
        holder.station.setText(arrayList.get(position).getStation());

        holder.trainNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("trainNo", temp.getTrainNo());
                intent.putExtra("trainName", temp.getTrainName());
                intent.putExtra("station", temp.getStation());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class Myholder extends RecyclerView.ViewHolder {
        TextView trainName,trainNo;
        TextView station;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            trainNo=itemView.findViewById(R.id.textView1);
            trainName=itemView.findViewById(R.id.textView2);
            station=itemView.findViewById(R.id.textView3);
        }
    }
}
