package com.example.themodernbibliothecaandroid.Repository;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themodernbibliothecaandroid.R;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.MyViewHolder> {

    String date[], email[], desc[], type[];
    Context context;

    public ActivityAdapter(Context ct, String dateList[], String emailList[], String descList[], String typeList[]){
        context = ct;
        date = dateList;
        email = emailList;
        desc = descList;
        type = typeList;
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
        holder.dateText.setText(date[position]);
        holder.emailText.setText(email[position]);
        holder.descText.setText(desc[position]);
        holder.typeText.setText(type[position]);
    }

    @Override
    public int getItemCount() {
        return date.length;
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
}
