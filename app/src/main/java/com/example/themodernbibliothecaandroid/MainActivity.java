package com.example.themodernbibliothecaandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.themodernbibliothecaandroid.Repository.ActivityRepository;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ActivityRepository repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.hello_world_tv);

        repository = new ActivityRepository();

        Bind();
    }

    public void Bind(){
        repository.BindActivities(this);
    }






}