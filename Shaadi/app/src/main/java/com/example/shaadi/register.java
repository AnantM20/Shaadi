package com.example.shaadi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class register extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public  void selfclicker(View v)
    {
        Intent i = new Intent(this , RegisterPg2.class);
        startActivity(i);

    }

    public  void sonclicker(View v)
    {
        Intent i = new Intent(this , malefemale.class);
        startActivity(i);

    }
    public  void daughterclicker(View v)
    {
        Intent i = new Intent(this , malefemale.class);
        startActivity(i);

    }
    public  void brotherclicker(View v)
    {
        Intent i = new Intent(this , malefemale.class);
        startActivity(i);

    }
    public  void relativeclicker(View v)
    {
        Intent i = new Intent(this , RegisterPg2.class);
        startActivity(i);

    }
    public  void sisterclicker(View v)
    {
        Intent i = new Intent(this , malefemale.class);
        startActivity(i);

    }

}