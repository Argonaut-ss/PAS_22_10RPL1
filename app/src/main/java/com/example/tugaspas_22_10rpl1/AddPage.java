package com.example.tugaspas_22_10rpl1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddPage extends AppCompatActivity {
    EditText textusername;
    EditText textNumber;
    Button buttonadd;
    private ArrayList<Data> dataArrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_page);
        getSupportActionBar().hide();

        textusername = (EditText)findViewById(R.id.username);
        textNumber = (EditText)findViewById(R.id.number);
        buttonadd = (Button)findViewById(R.id.button);
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataAdapter.getData().addData(textusername.getText().toString(),textNumber.getText().toString());
                Intent simpan = new Intent(getApplicationContext(), MainActivity.class);
                simpan.putExtra("data", dataArrayList);
                startActivity(simpan);

            }
        });



    }



}