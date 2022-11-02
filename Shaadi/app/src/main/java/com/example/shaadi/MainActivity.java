package com.example.shaadi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onlog(View v){
        Intent i = new Intent(this , Login.class);
        startActivity(i);

    }
    public void onreg(View v){
        Intent i = new Intent(this , register.class);
        startActivity(i);

    }
}