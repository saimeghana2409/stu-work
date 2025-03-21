package com.example.myapplication;

import android.os.Bundle;
import android.content.Context;
import androidx.fragment.app.Fragment;
import android.widget.Button;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class lab extends Fragment {

    public void onButtonClick() {
    }

    public interface OnButtonClickListener {
        void onButtonClick();
    }
    private OnButtonClickListener buttonClickListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            buttonClickListener = (OnButtonClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnButtonClickListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_lab, container, false);
        Button btnNotifyActivity = view.findViewById(R.id.button10);

        btnNotifyActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonClickListener != null) {
                    buttonClickListener.onButtonClick();
                }
            }
        });

        return view;
    }
}







