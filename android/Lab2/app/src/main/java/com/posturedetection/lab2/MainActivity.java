package com.posturedetection.lab2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvList;
    private TypedArray images;
    ArrayList<Zodiac> zodiacs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Globals globals = (Globals) getApplication();
        zodiacs = globals.getZodiacs();
        images = globals.getImages();

        rvList = findViewById(R.id.rvList);
        rvList.setAdapter(new MyAdapter());
        rvList.setLayoutManager(new LinearLayoutManager(this));

    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_list,parent,false);
            //  View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.boxitem,parent,false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
            holder.ivImg.setImageDrawable(images.getDrawable(position));
            holder.tvName.setText(zodiacs.get(position).getName());
            holder.tvDate.setText(zodiacs.get(position).getDate());
        }

        @Override
        public int getItemCount() {
            return zodiacs.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            ImageView ivImg;
            TextView tvName,tvDate;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                ivImg = itemView.findViewById(R.id.ivImg);
                tvName = itemView.findViewById(R.id.tvName);
                tvDate = itemView.findViewById(R.id.tvDate);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("position", getAdapterPosition());
                intent.putExtra("image",images.getResourceId(getAdapterPosition(),-1));
                startActivity(intent);
            }
        }
    }
}