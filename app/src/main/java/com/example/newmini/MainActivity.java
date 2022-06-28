package com.example.newmini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    Button b,pp,on;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.comp);
        Intent intent = new Intent(MainActivity.this,postActivity.class);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
        pp = findViewById(R.id.ppbut);
        pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,prepration.class));
            }
        });
        on = findViewById(R.id.ongo);
        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "Admin";
                intent.putExtra("message_key",message);
                startActivity(intent);
            }
        });
    }
}