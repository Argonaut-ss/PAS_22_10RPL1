package com.example.tugaspas_22_10rpl1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class DetailPage extends AppCompatActivity {
    Bundle bundle;
    String namaContact;
    String noHpContact;
    TextView text_nama, text_noHp;
    ImageButton buttonM, buttonC, buttonV;
    CardView cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        text_nama = (TextView)findViewById(R.id.textnama);
        text_noHp = (TextView)findViewById(R.id.textnoHp);
        bundle = getIntent().getExtras();
        if (bundle != null){
            namaContact = bundle.getString("nama");
            noHpContact = bundle.getString("noHp");
        }
        text_nama.setText(namaContact);
        text_noHp.setText(noHpContact);

        getSupportActionBar().setTitle("Contact info");


        cv = (CardView)findViewById(R.id.cardviewDetail);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailPage.this, "Cek klik", Toast.LENGTH_SHORT).show();
            }
        });


        //Button message
        buttonM = (ImageButton)findViewById(R.id.messagebutton);
        buttonM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailPage.this, "message button Cek klik", Toast.LENGTH_SHORT).show();
            }
        });

        //Button Call
        buttonC = (ImageButton)findViewById(R.id.callbutton);
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailPage.this, "Call button cek klik", Toast.LENGTH_SHORT).show();
            }
        });

        //Button Video
        buttonV = (ImageButton)findViewById(R.id.videobutton);
        buttonV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailPage.this, "Video button cek klik", Toast.LENGTH_SHORT).show();
            }
        });
    }
}