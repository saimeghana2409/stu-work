package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMain3Binding;


import com.example.myapplication.databinding.ActivityMain5Binding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity3 extends MainActivity4 {
    ActivityMain3Binding activityMain3Binding;
    ImageButton ib, ib1, ib2, ib3, ib5, ib4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMain3Binding=ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(activityMain3Binding.getRoot());



        ib=(ImageButton) findViewById(R.id.imageButton2);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this, guides.class);
                startActivity(intent);
            }
        });


        ib1=(ImageButton) findViewById(R.id.imageButton4);
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this, schedule.class);
                startActivity(intent);
            }
        });

        ib2=(ImageButton) findViewById(R.id.imageButton5);
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this, bmi.class);
                startActivity(intent);
            }
        });
        ib3=(ImageButton) findViewById(R.id.imageButton6);
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this, symptoms.class);
                startActivity(intent);
            }
        });
        ib4=(ImageButton) findViewById(R.id.imageButton);
        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this, google.class);
                startActivity(intent);
            }
        });
        ib5=(ImageButton) findViewById(R.id.imageButton3);
        ib5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity3.this, records.class);
                startActivity(intent);
            }
        });
    }
    protected void onStart() {
        super.onStart();
        Log.i("LogName", "onStart()");
        Toast.makeText(this,"On Start", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LogName", "onResume()");
        Toast.makeText(this,"On Resume", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LogName", "onPause()");
        Toast.makeText(this,"On Pause", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LogName", "onStop()");
        Toast.makeText(this,"On Stop", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LogName", "onDestroy()");
        Toast.makeText(this,"On Destroy", Toast.LENGTH_LONG).show();
    }
}