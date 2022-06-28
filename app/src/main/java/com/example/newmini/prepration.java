package com.example.newmini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class prepration extends AppCompatActivity {
    Button os,cn,dbms,dsa,apti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepration);
        os = findViewById(R.id.osbut);
        cn = findViewById(R.id.ppbut);
        dbms = findViewById(R.id.dbmsbut);
        dsa = findViewById(R.id.dsabut);
        apti = findViewById(R.id.button);
        dsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(prepration.this,Dsa_Activity.class));
            }
        });
        dbms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(prepration.this,DbmsActivity.class));
            }
        });
        cn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(prepration.this,CnActivity.class));
            }
        });
        os.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(prepration.this,Os_Activity.class));
            }
        });
        apti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(prepration.this,aptitude.class));
            }
        });
    }
}