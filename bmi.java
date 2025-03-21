package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityBmiBinding;
import com.example.myapplication.databinding.ActivityMain3Binding;
import com.example.myapplication.databinding.ActivityMainBinding;

public class bmi extends MainActivity4{
    ActivityBmiBinding activitybmiBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitybmiBinding= ActivityBmiBinding.inflate(getLayoutInflater());
        setContentView(activitybmiBinding.getRoot());

        final EditText editTextHeight = findViewById(R.id.editTextHeight);
        final EditText editTextWeight = findViewById(R.id.editTextWeight);
        final TextView bmiResultTextView = findViewById(R.id.textView32);
        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI(editTextHeight.getText().toString(), editTextWeight.getText().toString(), bmiResultTextView);
            }
        });
    }

    private void calculateBMI(String heightStr, String weightStr, TextView resultTextView) {
        if (heightStr.isEmpty() || weightStr.isEmpty()) {
            resultTextView.setText("Please enter both height and weight.");
            return;
        }

        float height = Float.parseFloat(heightStr);
        float weight = Float.parseFloat(weightStr);

        float bmi = weight / (height * height);

        resultTextView.setText(String.format("Your BMI is: %.2f", bmi));
    }
}
