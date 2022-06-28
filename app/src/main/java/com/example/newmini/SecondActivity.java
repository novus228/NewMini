package com.example.newmini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    Button ama,ju;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = new Intent(SecondActivity.this,postActivity.class);
        ama = findViewById(R.id.amazon);
        ama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "Amazon";
                intent.putExtra("message_key",message);
                startActivity(intent);
            }
        });
        ju = findViewById(R.id.jun);
        ju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "Juniper";
                intent.putExtra("message_key",message);
                startActivity(intent);
            }
        });

    }
    public void onBackPressed() {
        startActivity(new Intent(SecondActivity.this,MainActivity.class));
//        super.onBackPressed();
    }
}