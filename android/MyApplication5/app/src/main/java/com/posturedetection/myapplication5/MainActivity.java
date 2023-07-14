package com.posturedetection.myapplication5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvList;

    String[] names;

    TypedArray images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = getResources().getStringArray(R.array.names);
        images = getResources().obtainTypedArray(R.array.images);

        rvList = findViewById(R.id.rvList);
        rvList.setAdapter(new MyAdapter());
       rvList.setLayoutManager(new LinearLayoutManager(this));
      //  rvList.setLayoutManager(new GridLayoutManager(this,3));
    }

    //create MyAdapter class
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        @NonNull
        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.itemlist,parent,false);
          //  View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.boxitem,parent,false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
            holder.ivImg.setImageDrawable(images.getDrawable(position));
            holder.tvName.setText(names[position]);

//            holder.ivImg.setImageResource(images.getResourceId(position,-1));
//            holder.tvName.setText(names[position]);
        }

        @Override
        public int getItemCount() {
            return names.length;
        }

        class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            ImageView ivImg;
            TextView tvName;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                ivImg = itemView.findViewById(R.id.ivImg);
                tvName = itemView.findViewById(R.id.tvName);
//                ivImg = itemView.findViewById(R.id.ivImg2);
//                tvName = itemView.findViewById(R.id.tvName2);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, names[getAdapterPosition()], Toast.LENGTH_SHORT).show();

            }
        }
    }
    //create MyAdapter2 class for boxitem.xml

}