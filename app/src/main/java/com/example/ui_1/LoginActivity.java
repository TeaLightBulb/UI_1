package com.example.ui_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText userNameED;
    EditText passwordED;
    Button button;
    String[] items = {"male","female","others"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = findViewById(R.id.button_first);
        userNameED = findViewById(R.id.ED1);
        passwordED = findViewById(R.id.ED2);

        SharedPreferences sharedPreferences_1 = getSharedPreferences("prefs2", MODE_PRIVATE);
        String str_name = sharedPreferences_1.getString("name","");
        String str_pass = sharedPreferences_1.getString("pass","");
        if(!str_name.equals("") && !str_pass.equals("")){
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }

        button.setOnClickListener(v ->
        {
            String name = userNameED.getText().toString();
            String password = passwordED.getText().toString();

//            Intent intent = new Intent(this, HomeActivity.class);
//            intent.putExtra("message_key", "Hi " + name + " Your Password is " + "'" + password + "'");
//            startActivity(intent);

            //Creating a variable sp to store Shared Preference object
            SharedPreferences sp = getSharedPreferences("prefs2", MODE_PRIVATE);
            //Creating editor object for shared preference
            SharedPreferences.Editor editor = sp.edit();
            //putting values as key-value pairs
            editor.putString("name", name);
            editor.putString("pass", password);
            //Committing data, so that its written to storage immediately.
            editor.commit();
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });


            // Take the instance of Spinner and
            // apply OnItemSelectedListener on it which
            // tells which item of spinner is clicked
            Spinner spinner = findViewById(R.id.spinner);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getApplicationContext(), items[position], Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            // Create the instance of ArrayAdapter
            // having the list of courses
            ArrayAdapter ad
                    = new ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item,
                    items);

            // set simple layout resource file
            // for each item of spinner
            ad.setDropDownViewResource(
                    android.R.layout
                            .simple_spinner_dropdown_item);

            // Set the ArrayAdapter (ad) data on the
            // Spinner which binds data to spinner
            spinner.setAdapter(ad);
        }

}



                            /* previous code */


//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        userNameED = (EditText)findViewById(R.id.ED1);
//        passwordED =(EditText)findViewById(R.id.ED2);
//        button = findViewById(R.id.button_first);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(LoginActivity.this, "hi "+userNameED.getText().toString()+" your password is "+ passwordED.getText().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });

