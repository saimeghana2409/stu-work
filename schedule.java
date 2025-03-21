package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.databinding.ActivityMain3Binding;
import com.example.myapplication.databinding.ActivityScheduleBinding;

public class schedule extends MainActivity4 {
    ActivityScheduleBinding activityscheduleBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityscheduleBinding=ActivityScheduleBinding.inflate(getLayoutInflater());
        setContentView(activityscheduleBinding.getRoot());

    }
}