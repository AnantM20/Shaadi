package com.example.shaadi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e1, e3;
    Button button;
    database g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        g = new database(this);
        e1 = findViewById(R.id.e1);
        e3 = findViewById(R.id.e3);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = e1.getText().toString();
                String pass = e3.getText().toString();


                if (email.equals("") || pass.equals("")) {
                    Toast.makeText(Login.this, " Please fill details", Toast.LENGTH_SHORT).show();
                } else {
//
                    Boolean i = g.checklogin(email, pass);
                    if (i == true) {

                        Intent r = new Intent(Login.this , drawerbox.class);
                        startActivity(r);

                        Toast.makeText(Login.this, "Welcome to Shaadi.com", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Login.this, "Login Unsucessful", Toast.LENGTH_SHORT).show();
                    }


                }


                // getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(black)));
            }


        });
    }
    public  void registerlogin(View v)
    {
        Intent i = new Intent(this , RegisterPg2.class);
        startActivity(i);

    }
}






