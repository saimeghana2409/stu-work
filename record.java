package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class record extends Fragment {
    public interface OnNotifyActivityListener {
        void onNotifyActivity();
    }

    // Reference to the listener
    private OnNotifyActivityListener notifyActivityListener;

    public record() {
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            notifyActivityListener = (OnNotifyActivityListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnNotifyActivityListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_record, container, false);
        Button btnNotifyActivity = view.findViewById(R.id.button9);
        btnNotifyActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (notifyActivityListener != null) {
                    notifyActivityListener.onNotifyActivity();
                }
            }
        });
        return view;
    }
}






