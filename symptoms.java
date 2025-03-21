package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMain3Binding;
import com.example.myapplication.databinding.ActivitySymptomsBinding;

public class symptoms extends MainActivity4 {
    ActivitySymptomsBinding activitySymptomsBinding;

    private EditText editTextSymptoms;
    private Button buttonCheckIllness;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySymptomsBinding= ActivitySymptomsBinding.inflate(getLayoutInflater());
        setContentView(activitySymptomsBinding.getRoot());

        editTextSymptoms = findViewById(R.id.editTextSymptoms);
        buttonCheckIllness = findViewById(R.id.buttonCheckIllness);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCheckIllness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkIllness();
            }
        });
    }

    private void checkIllness() {
        String symptomsInput = editTextSymptoms.getText().toString().trim();

        if (!symptomsInput.isEmpty()) {
            // Process the symptoms and determine the illness
            String illnessResult = determineIllness(symptomsInput);

            // Display the result
            textViewResult.setText("Possible illness or disease: " + illnessResult);
        } else {
            textViewResult.setText("Please enter symptoms before checking.");
        }
    }

    private String determineIllness(String symptoms) {
        // Convert symptoms to lowercase for case-insensitive matching
        symptoms = symptoms.toLowerCase();

        if (symptoms.contains("fever") && symptoms.contains("cough")) {
            return "Common Cold";
        } else if (symptoms.contains("fever") && symptoms.contains("breathing difficulties")) {
            return "Influenza";
        } else if (symptoms.contains("headache") && symptoms.contains("stiff neck") && symptoms.contains("fever")) {
            return "Meningitis";
        } else if (symptoms.contains("abdominal pain") && symptoms.contains("nausea") && symptoms.contains("vomiting")) {
            return "Gastroenteritis";
        } else if (symptoms.contains("chest pain") && symptoms.contains("shortness of breath")) {
            return "Heart Attack";
        } else {
            return "No specific illness detected. Consult a healthcare professional for accurate diagnosis.";
        }
    }
}
