package com.posturedetection.myapplication5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnGo;

    RecyclerView rvList;
    private String[] names;
    private TypedArray images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Globals globals = (Globals) getApplication();
        names = globals.getNames();
        images = globals.getImages();
        rvList = findViewById(R.id.rvList);
        rvList.setAdapter(new MyAdapter());
        rvList.setLayoutManager(new LinearLayoutManager(this));

//        btnGo = findViewById(R.id.btnGo);
//        btnGo.setOnClickListener(v -> {
//             Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//             startActivity(intent);
////             finish();
//        });
//        Log.d("xxxxxxxxxxxxxxxxxxxxxxxxxxx","onCreate");
    }

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
//                Toast.makeText(MainActivity.this, names[getAdapterPosition()], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("name",names[getAdapterPosition()]);
                intent.putExtra("image",images.getResourceId(getAdapterPosition(),-1));
                startActivity(intent);

            }
        }
    }
    //create MyAdapter2 class for boxitem.xml


//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d("xxxxxxxxxxxxxxxxxxxxxxxxxxx","onStart");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.d("xxxxxxxxxxxxxxxxxxxxxxxxxxx","onResume");
//    }
//
//    //onPause
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.d("xxxxxxxxxxxxxxxxxxxxxxxxxxx","onPause");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//
//        Log.d("xxxxxxxxxxxxxxxxxxxxxxxxxxx","onStop");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d("xxxxxxxxxxxxxxxxxxxxxxxxxxx","onDestroy");
//    }
//
//    //onRestart
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.d("xxxxxxxxxxxxxxxxxxxxxxxxxxx","onRestart");
//    }
}