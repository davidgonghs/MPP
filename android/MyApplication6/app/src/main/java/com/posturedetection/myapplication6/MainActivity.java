package com.posturedetection.myapplication6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvList;
    ArrayList<Contact> contacts;

    Dialog dialog;

    Button btnAdd;

    EditText p_etName, p_etContact, p_etEmail;
    Button p_btnSave;
    CheckBox p_cbIsMale;

    MyAdapter adapter;
    int pos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Globals globals = (Globals) getApplicationContext();
        contacts = globals.getContacts();



        contacts.add(new Contact("David Gong Hongshen", "017-3599496", "davidgonghongshen@gmail.com", true,837190861L));
        contacts.add(new Contact("Koong Kok Leong", "012-3456789", "kl.koong@firstcity.edu.my", true,963421261L));
        contacts.add(new Contact("Winnie Gong", "012-3456789", "winniw@gmail.com", false,391885261L));

        /**class 8 dialog*/
//        btnAdd = findViewById(R.id.btnAdd);
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent = new Intent(MainActivity.this, AddActivity.class);
////                startActivity(intent);
//                dialog = new Dialog(MainActivity.this);
//                dialog.setContentView(R.layout.profile);
//                p_btnSave = dialog.findViewById(R.id.p_btnSave);
//                p_etName = dialog.findViewById(R.id.p_etName);
//                p_etContact = dialog.findViewById(R.id.p_etContact);
//                p_etEmail = dialog.findViewById(R.id.p_etEmail);
//                p_cbIsMale = dialog.findViewById(R.id.p_cbIsMale);
//
//                p_btnSave.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        String name = p_etName.getText().toString();
//                        String contact = p_etContact.getText().toString();
//                        String email = p_etEmail.getText().toString();
//                        boolean isMale = p_cbIsMale.isChecked();
//
//                        Contact newContact = new Contact(name, contact, email, isMale);
//                        contacts.add(newContact);
//                        adapter.notifyDataSetChanged();
//                        dialog.dismiss();
//                    }
//                });
//                dialog.show();
//            }
//        });

        rvList = findViewById(R.id.rvList);
        adapter = new MyAdapter();

        registerForContextMenu(rvList);

        rvList.setAdapter(adapter);
        rvList.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int menuItem = item.getItemId();
        if (menuItem==11){
//            if(pos!=-1){
//                Intent intent = new Intent(MainActivity.this, AddActivity.class);
//                intent.putExtra("pos", pos);
//                startActivity(intent);
//            }

            dialog = new Dialog(MainActivity.this);
            //get context menu position

            Contact c = contacts.get(pos);

            dialog.setContentView(R.layout.profile);
            dialog.setTitle("Edit Contact");
            p_btnSave = dialog.findViewById(R.id.p_btnSave);
            p_etName = dialog.findViewById(R.id.p_etName);
            p_etContact = dialog.findViewById(R.id.p_etContact);
            p_etEmail = dialog.findViewById(R.id.p_etEmail);
            p_cbIsMale = dialog.findViewById(R.id.p_cbIsMale);

            p_etName.setText(c.getName());
            p_etContact.setText(c.getContact());
            p_etEmail.setText(c.getEmail());
            p_cbIsMale.setChecked(c.isMale());


            p_btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = p_etName.getText().toString();
                    String contact = p_etContact.getText().toString();
                    String email = p_etEmail.getText().toString();
                    boolean isMale = p_cbIsMale.isChecked();



                    Contact newContact = new Contact(name, contact, email, isMale);
                    contacts.set(pos, newContact);
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
        if (menuItem==12){
            contacts.remove(pos);
            adapter.notifyDataSetChanged();
        }

        if(menuItem==13){
            Intent intent = new Intent(MainActivity.this, AddActivity.class);
            startActivity(intent);
        }


        return super.onContextItemSelected(item);
    }


    /**
     * class 9 main option menu
     */
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    //override onOptionsItemSelected
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int menuItem = item.getItemId();
//        if (menuItem==R.id.mm_add){
//            //                Intent intent = new Intent(MainActivity.this, AddActivity.class);
////                startActivity(intent);
//            dialog = new Dialog(MainActivity.this);
//            dialog.setContentView(R.layout.profile);
//            p_btnSave = dialog.findViewById(R.id.p_btnSave);
//            p_etName = dialog.findViewById(R.id.p_etName);
//            p_etContact = dialog.findViewById(R.id.p_etContact);
//            p_etEmail = dialog.findViewById(R.id.p_etEmail);
//            p_cbIsMale = dialog.findViewById(R.id.p_cbIsMale);
//
//            p_btnSave.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String name = p_etName.getText().toString();
//                    String contact = p_etContact.getText().toString();
//                    String email = p_etEmail.getText().toString();
//                    boolean isMale = p_cbIsMale.isChecked();
//
//                    Contact newContact = new Contact(name, contact, email, isMale);
//                    contacts.add(newContact);
//                    adapter.notifyDataSetChanged();
//                    dialog.dismiss();
//                }
//            });
//            dialog.show();
//        }
//        if(menuItem==R.id.mm_about_develop){
////                Intent intent = new Intent(MainActivity.this, AddActivity.class);
////                startActivity(intent);
//
//        }
//        if (menuItem==R.id.mm_about_company){
//            Toast.makeText(this, "David's Company", Toast.LENGTH_SHORT).show();
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    //     MyAdapter class


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        @NonNull
        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.item_list, parent, false);

            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
            holder.tvName.setText(contacts.get(position).getName());
            holder.tvContact.setText(contacts.get(position).getContact());
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    //show context menu
                    return false;
                }
            });
        }



//        class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//            TextView tvName, tvContact, tvEmail;
//
//            public MyViewHolder(@NonNull View itemView) {
//                super(itemView);
//                tvName = itemView.findViewById(R.id.tvName);
//                tvContact = itemView.findViewById(R.id.tvContact);
//                //add on click listener
//                itemView.setOnClickListener(this);
//            }
//
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
////                intent.putExtra("name", contacts.get(getAdapterPosition()).getName());
////                intent.putExtra("contact", contacts.get(getAdapterPosition()).getContact());
////                intent.putExtra("email", contacts.get(getAdapterPosition()).getEmail());
//                intent.putExtra("position", getAdapterPosition());
//                startActivity(intent);
//
//            }
//        }

            class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
                TextView tvName, tvContact, tvEmail;

                public MyViewHolder(@NonNull View itemView) {
                    super(itemView);
                    tvName = itemView.findViewById(R.id.tvName);
                    tvContact = itemView.findViewById(R.id.tvContact);
                    itemView.setOnCreateContextMenuListener(this);
                }

                @Override
                public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                    pos = getAdapterPosition();
                    contextMenu.add(1, 11, 0, "Edit");
                    contextMenu.add(1, 12, 1, "Delete");
                    contextMenu.add(1, 13, 2, "View");

                }
            }

        @Override
        public int getItemCount() {
            return contacts.size();
        }

    }
}