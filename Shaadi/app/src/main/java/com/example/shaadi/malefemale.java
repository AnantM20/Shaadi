package com.example.shaadi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class malefemale extends AppCompatActivity {
    EditText date ;
    RadioButton radioButton4, radioButton5;
    Spinner static_spinner , static_spinner1;
    EditText e1 ,e2, e3 ,e5,mob;
    Button b1 ;
    database g ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malefemale);

        g= new database(this);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        e5=findViewById(R.id.email1);
        static_spinner = findViewById(R.id.static_spinner);
        static_spinner1= findViewById(R.id.static_spinner1);
        radioButton4 = findViewById(R.id.radioButton4);
        radioButton5 = findViewById(R.id.radioButton5);
        mob=findViewById(R.id.mob);
        date= findViewById(R.id.date);

        b1= findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first = e1.getText().toString();
                String last = e2.getText().toString();
                String pass = e3.getText().toString();
                String email = e5.getText().toString();
                String religion = static_spinner.toString();
                String country = static_spinner1.toString();

                String mobno = mob.getText().toString();
                String birth = date.getText().toString();
                if (first.equals("")||last.equals("")||pass.equals("")|| email.equals("")||birth.equals("")||mobno.equals("")||religion.equals("")|| country.equals(""))
                {
                    Toast.makeText(malefemale.this, "Please enter all field ", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    Boolean i = g.checkemail(email);
                    if (i== true )
                    {
                        Toast.makeText(malefemale.this, "Email Exists", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Boolean j = g.insert_data(first, last , pass , email , birth , mobno , religion , country);
                        if(j==true ){
                            Toast.makeText(malefemale.this, "Registration Successful ", Toast.LENGTH_SHORT).show();
                            Intent r = new Intent(malefemale.this , Login.class);
                            startActivity(r);
                        }
                        else
                        {
                            Toast.makeText(malefemale.this, "Registratoin Unsuccessful", Toast.LENGTH_SHORT).show();
                        }
                    }


                }
            }
        });







        date = findViewById(R.id.date);
        date = findViewById(R.id.date);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        malefemale.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        month=month+1;
                        String date2 = day+"/"+month+"/"+year;
                        date.setText(date2);
                    }
                },year,month,day
                );
                datePickerDialog.show();
            }
        });



        Spinner staticSpinner = (Spinner) findViewById(R.id.static_spinner);

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.brew_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner.setAdapter(staticAdapter);



        Spinner staticSpinner1 = (Spinner) findViewById(R.id.static_spinner1);

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter1 = ArrayAdapter
                .createFromResource(this, R.array.brew_array1,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter1
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner1.setAdapter(staticAdapter1);



    }
    }
