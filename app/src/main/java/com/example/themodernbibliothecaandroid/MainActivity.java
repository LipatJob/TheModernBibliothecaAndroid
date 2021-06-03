package com.example.themodernbibliothecaandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.themodernbibliothecaandroid.Repository.Activity;
import com.example.themodernbibliothecaandroid.Repository.ActivityAdapter;
import com.example.themodernbibliothecaandroid.Repository.ActivityRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ActivityRepository repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        loadItems();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void refreshItems(View view) {
        loadItems();
    }

    private void loadItems(){
        List<Activity> activityList = new ArrayList<>();
        ActivityAdapter adapter = new ActivityAdapter(this, activityList);
        recyclerView.setAdapter(adapter);

        repository = new ActivityRepository();
        repository.BindActivities(this, adapter);
    }
}