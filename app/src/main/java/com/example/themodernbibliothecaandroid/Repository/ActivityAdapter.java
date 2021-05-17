package com.example.themodernbibliothecaandroid.Repository;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themodernbibliothecaandroid.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.MyViewHolder> {

    List<Activity> activityList;
    Context context;

    public ActivityAdapter(Context ct, List<Activity> activityList){
        context = ct;
        this.activityList = activityList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.dateText.setText(activityList.get(position).getDate().toString());
        holder.emailText.setText(activityList.get(position).getEmail());
        holder.descText.setText(activityList.get(position).getDescription());
        holder.typeText.setText(activityList.get(position).getAccountType());
    }

    @Override
    public int getItemCount() {
        return activityList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView dateText, emailText, descText, typeText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            dateText = itemView.findViewById(R.id.date_text);
            emailText = itemView.findViewById(R.id.email_text);
            descText = itemView.findViewById(R.id.desc_text);
            typeText = itemView.findViewById(R.id.type_text);
        }
    }

    public void setDataChange(List<Activity> activityList){
        this.activityList = new ArrayList<>(activityList);
        notifyDataSetChanged();
    }
}
