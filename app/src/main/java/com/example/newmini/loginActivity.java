package com.example.newmini;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.newmini.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginActivity extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser currentUser;
    Button login;
    EditText em,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        auth = FirebaseAuth.getInstance();
        currentUser = auth.getCurrentUser();


        login = findViewById(R.id.button2);
        em = findViewById(R.id.emailEdit);
        pass = findViewById(R.id.passEdit);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (em.getText().toString().isEmpty()) {
                    Toast.makeText(loginActivity.this, "Email Can't be empty", Toast.LENGTH_SHORT).show();
                }
                else if (pass.getText().toString().isEmpty()) {
                    Toast.makeText(loginActivity.this, "Password Can't be empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    auth.signInWithEmailAndPassword(em.getText().toString(), pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(loginActivity.this, addPost.class);
                                startActivity(intent);
                            }
                        }
                    });
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(currentUser!=null)
        {
            startActivity(new Intent(loginActivity.this,addPost.class));
        }

    }
}