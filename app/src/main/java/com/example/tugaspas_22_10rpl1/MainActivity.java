package com.example.tugaspas_22_10rpl1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    private static MainActivity Main;

    public static MainActivity getMain() {
        return Main;
    }

    private RecyclerView recyclerView;
    private DataAdapter adapter;
    private ArrayList<Data> dataArrayList;
    ImageButton addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Main = this;
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewData);
        getSupportActionBar().setTitle("Contact");


        adapter = DataAdapter.getData();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        addButton = (ImageButton)findViewById(R.id.addbutton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "cek klik", Toast.LENGTH_SHORT).show();
                Intent add = new Intent(getApplicationContext(),AddPage.class);
                startActivity(add);
            }
        });
    }


}