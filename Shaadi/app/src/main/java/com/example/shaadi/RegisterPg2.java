package com.example.shaadi;

//import static com.example..R.colo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;


public class RegisterPg2<binding> extends AppCompatActivity  {
    EditText date ;
    RadioButton radioButton4, radioButton5;
    Spinner static_spinner , static_spinner1;
    EditText e1 ,e2, e3 ,e5,editTextTextPersonName3;
    Button b1 ; 
    database g ;
    String language = "test";
    String religion ="test2" ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_pg2);

        g= new database(this);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        e5=findViewById(R.id.e5);
        static_spinner = findViewById(R.id.static_spinner);
        static_spinner1= findViewById(R.id.static_spinner1);
        radioButton4 = findViewById(R.id.radioButton4);
        radioButton5 = findViewById(R.id.radioButton5);
        editTextTextPersonName3=findViewById(R.id.mob);
        date= findViewById(R.id.date);

        b1= findViewById(R.id.b1);
        
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first = e1.getText().toString();
                String last = e2.getText().toString();
                String pass = e3.getText().toString();
                String email = e5.getText().toString();


                String male = radioButton4.getText().toString();
                String female = radioButton5.getText().toString();
                String mobno = editTextTextPersonName3.getText().toString();
                String birth = date.getText().toString();
                if (first.equals("")||last.equals("")||pass.equals("")|| email.equals("")||birth.equals("")||mobno.equals("")||religion.equals("")|| language.equals(""))
                {
                    Toast.makeText(RegisterPg2.this, "Please enter all field ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    
                    Boolean i = g.checkemail(email);
                    if (i== true )
                    {
                                Toast.makeText(RegisterPg2.this, "Email Exists", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                       Boolean j = g.insert_data(first, last , pass , email , birth , mobno , religion , language);
                       if(j==true ){
                           Toast.makeText(RegisterPg2.this, "Registration Successful ", Toast.LENGTH_SHORT).show();
                           Intent r = new Intent(RegisterPg2.this , Login.class);
                           startActivity(r);
                       }
                       else
                       {
                           Toast.makeText(RegisterPg2.this, "Registratoin Unsuccessful", Toast.LENGTH_SHORT).show();
                       }
                    }

                    
                    
                }
                
                
                
                
//                e1.setText("");
//                e2.setText("");
//                e3.setText("");
                e5.setText("");
                
                
                
            }
        });


        
        

      
        
//        getSupportActionBar().hide();
       // getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor()));



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
                        RegisterPg2.this, new DatePickerDialog.OnDateSetListener() {
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


       static_spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               language = static_spinner1.getSelectedItem().toString();
               Log.d("==", language);
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });

        static_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                religion = static_spinner.getSelectedItem().toString();
                Log.d("===", religion);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });







    }





}