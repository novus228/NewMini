package com.example.newmini.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newmini.Model.dashboardModel;
import com.example.newmini.Model.postModel;
import com.example.newmini.R;
import com.example.newmini.adapter.postAdap;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class postScroll extends Fragment {

    RecyclerView dashrv;
    ArrayList<postModel> postList;
    FirebaseDatabase database;
    FirebaseAuth auth;

    public postScroll() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseDatabase.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post_scroll, container, false);
        dashrv = view.findViewById(R.id.rvr);
        postList = new ArrayList<>();

        postAdap postadap = new postAdap(postList,getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        dashrv.setLayoutManager(layoutManager);
        dashrv.setNestedScrollingEnabled(true);
        dashrv.setAdapter(postadap);
        String compa = getActivity().getIntent().getStringExtra("message_key");
        database.getReference().child("Company").child(compa).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    postModel post = dataSnapshot.getValue(postModel.class);
                    postList.add(post);
                }
                postadap.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }
}