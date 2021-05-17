package com.example.themodernbibliothecaandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.themodernbibliothecaandroid.Repository.ActivityAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String dateList[], emailList[], descList[], typeList[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        dateList = getResources().getStringArray(R.array.date);
        emailList = getResources().getStringArray(R.array.user_email);
        descList = getResources().getStringArray(R.array.description);
        typeList = getResources().getStringArray(R.array.user_type);

        ActivityAdapter adapter = new ActivityAdapter(this, dateList, emailList, descList, typeList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}