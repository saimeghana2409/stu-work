package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.databinding.ActivityMain3Binding;
import com.example.myapplication.databinding.ActivityRecordsBinding;


public class records extends MainActivity4 implements record.OnNotifyActivityListener, lab.OnButtonClickListener {
    ActivityRecordsBinding activityRecordsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRecordsBinding=ActivityRecordsBinding.inflate(getLayoutInflater());
        setContentView(activityRecordsBinding.getRoot());

        Button b1 = findViewById(R.id.button5);
        Button b2 = findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, record.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name") // Name can be null
                        .commit();
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, lab.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name") // Name can be null
                        .commit();
            }
        });
    }
    public void onNotifyActivity() {
        // Handle the notification in the activity
        // For example, display a toast message
        Toast.makeText(this,"Saved Details", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onButtonClick() {
            lab labFragment = (lab) getSupportFragmentManager().findFragmentByTag("lab_fragment");
            if (labFragment != null) {
                labFragment.onButtonClick();
            }
        Toast.makeText(this, "Button Clicked in Activity", Toast.LENGTH_SHORT).show();
    }
}
