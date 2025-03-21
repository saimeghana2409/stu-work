package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.databinding.ActivityGuidesBinding;
import com.example.myapplication.databinding.ActivityMain3Binding;

public class guides extends MainActivity4 {
    ActivityGuidesBinding activityGuidesBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityGuidesBinding= ActivityGuidesBinding.inflate(getLayoutInflater());
        setContentView(activityGuidesBinding.getRoot());
    }
}
