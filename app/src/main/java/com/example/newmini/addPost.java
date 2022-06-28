package com.example.newmini;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.newmini.Model.postModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Date;

public class addPost extends AppCompatActivity {
    ImageView picgal,postt;
    EditText descrip,compName,user;
    Button pst,logout;
    FirebaseAuth auth;
    FirebaseStorage storage;
    FirebaseDatabase database;
    ProgressDialog dialog;
    Uri uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);
        picgal = findViewById(R.id.addpic);
        descrip = findViewById(R.id.postDescription);
        logout = findViewById(R.id.lgout);
        compName = findViewById(R.id.comm);
        pst = findViewById(R.id.postButton1);
        user = findViewById(R.id.userName);
        auth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        dialog = new ProgressDialog(getBaseContext());
        database = FirebaseDatabase.getInstance();


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                startActivity(new Intent(addPost.this,postActivity.class));
            }
        });

        descrip.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String Description = descrip.getText().toString();
                if(!Description.isEmpty())
                {
                    pst.setBackgroundDrawable(ContextCompat.getDrawable(getBaseContext(),R.drawable.post_button));
                    pst.setTextColor(getBaseContext().getResources().getColor(R.color.white));
                    pst.setEnabled(true);
                }
                else
                {
                    pst.setBackgroundDrawable(ContextCompat.getDrawable(getBaseContext(),R.drawable.post_button_white));
                    pst.setTextColor(getBaseContext().getResources().getColor(R.color.light_grey));
                    pst.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        picgal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 11);
            }
        });


        pst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final StorageReference reference = storage.getReference().child("compan")
                        .child(compName.getText().toString())
                        .child(new Date().getTime()+"");
                reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        //Toast.makeText(addPost.this, "Post added", Toast.LENGTH_SHORT).show();
                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                postModel po = new postModel();
                                po.setPostImg(uri.toString());
                                po.setPostedBy(user.getText().toString());
                                po.setPostDescr(descrip.getText().toString());
                                po.setPostId(new Date().getTime()+"");
                                database.getReference().child("Company").child(compName.getText().toString())
                                        .push()
                                        .setValue(po).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        //dialog.dismiss();
                                        Toast.makeText(addPost.this, "Post added", Toast.LENGTH_SHORT).show();
                                        //startActivity(new Intent(addPost.this,SecondActivity.class));
                                    }
                                });

                            }
                        });
                    }
                });
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(addPost.this,SecondActivity.class));
//        super.onBackPressed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data.getData()!=null)
        {
            postt = findViewById(R.id.postpic);
            uri = data.getData();
            postt.setImageURI(uri);
            postt.setVisibility(View.VISIBLE);
        }
    }
}