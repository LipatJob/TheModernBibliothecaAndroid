package com.example.themodernbibliothecaandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.themodernbibliothecaandroid.Repository.Activity;
import com.example.themodernbibliothecaandroid.Repository.ActivityAdapter;
import com.example.themodernbibliothecaandroid.Repository.ActivityRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        List<Activity> activityList = new ArrayList<>();

        ActivityAdapter adapter = new ActivityAdapter(this, activityList);
        recyclerView.setAdapter(adapter);

        ActivityRepository repo = new ActivityRepository();
        repo.BindActivities(this, adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}