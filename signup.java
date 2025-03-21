package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    EditText username, password;
    dbhelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        Button signup=findViewById(R.id.signupButton);
        db=new dbhelper(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (user.equals("") || pass.equals(""))
                    Toast.makeText(signup.this, "please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuser=db.checkusername(user);
                    if(checkuser==false){
                        Boolean insert=db.insertData(user, pass);
                        if(insert==true) {
                            Toast.makeText(signup.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(signup.this, "Registration unsuccessfull", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(signup.this, "user already exits, sign in", Toast.LENGTH_SHORT).show();
                    }
                }
                }
            });
        }
    }
