package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.databinding.ActivityMain5Binding;

public class MainActivity5 extends MainActivity4 {
    ActivityMain5Binding activityMain5Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMain5Binding=ActivityMain5Binding.inflate(getLayoutInflater());
        setContentView(activityMain5Binding.getRoot());
    }
}