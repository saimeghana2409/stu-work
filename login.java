package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText username, password;
    dbhelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        Button button = findViewById(R.id.loginButton);
        db = new dbhelper(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(login.this, "please enter all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkuserpass = db.checkusernamepassword(user, pass);
                    if (checkuserpass == true) {
                        Toast.makeText(login.this, "sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(login.this, "invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}