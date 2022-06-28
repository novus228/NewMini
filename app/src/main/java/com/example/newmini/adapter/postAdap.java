package com.example.newmini.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newmini.Model.dashboardModel;
import com.example.newmini.Model.postModel;
import com.example.newmini.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class postAdap extends RecyclerView.Adapter<postAdap.viewHolder>{

    ArrayList<postModel> list;
    Context context;

    public postAdap(ArrayList<postModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dashboard_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        postModel model = list.get(position);
        Picasso.get()
                .load(model.getPostImg())
                .placeholder(R.drawable.placehold)
                .into(holder.post);
        holder.des.setText(model.getPostDescr());
        holder.nam.setText(model.getPostedBy());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView post;
        TextView nam,des;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            post = itemView.findViewById(R.id.postImg);
            nam = itemView.findViewById(R.id.textView2);
            des = itemView.findViewById(R.id.descrip);
        }
    }
}
