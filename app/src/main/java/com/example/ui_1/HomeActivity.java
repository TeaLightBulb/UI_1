package com.example.ui_1;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    ImageView button;

    //TEST CHANGES

    ImageView UserDP;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        TextView name = findViewById(R.id.receivedName);
        /*receiving the name and showing it to the screen*/
        SharedPreferences sharedPreferences = getSharedPreferences("prefs2", MODE_PRIVATE);
        String str_name = sharedPreferences.getString("name","");
        name.setText(String.format(str_name));
/**
        //the below code is just to show that how we can add string using  %s
        name.setText(String.format("Username -> %s", str_name));
**/

        /**  the code is for show the user_dp in the HomeActivity  **/
        UserDP = findViewById(R.id.userSelectedPic);
        /*receiving the image uri from the prefs2 xml file that is previously used to store the name , pass etc */
        sharedPreferences = getSharedPreferences("prefs2", MODE_PRIVATE);
        String selectedImageUri = sharedPreferences.getString("selectedImageUri", "");

        // Check if a URI is saved
        if (selectedImageUri != null) {
            // Load the image into the ImageView
            UserDP.setImageURI(Uri.parse(selectedImageUri));
        }

        /**this part of the code is used to take the image uri using intent **/
        /*  Retrieve the URI from the Intent  */
//        Intent intent = getIntent();
//        if(intent != null && intent.hasExtra("selectedImageUri")){
//            String selectedImageUri = intent.getStringExtra("selectedImageUri");
//            // Load the image into the ImageView
//            UserDP.setImageURI(Uri.parse(selectedImageUri));
//        }


        /**code to show the nationality**/
        TextView nationality = findViewById(R.id.receivedNation);
        int nation = sharedPreferences.getInt("nationality", Integer.parseInt("0"));
        if(nation == 1){
            nationality.setText("Your Nationality is Indian");
        }
        else{
            nationality.setText("your Nationality is not Indian");
        }
        /* the below code is to show the gender part*/
        TextView gender = findViewById(R.id.receivedGender);
        int gender1 = sharedPreferences.getInt("gender", Integer.parseInt("0"));
        if(gender1 == 1){
            gender.setText("Your gender is Male");
        }
        else{
            gender.setText("your gender is Female");
        }



        /**code for the logout button**/

        button = findViewById(R.id.action_image);
        /*the code is for the Logout button*/
        button.setOnClickListener(v ->
        {
            //Creating a variable sp to store Shared Preference object
            SharedPreferences sp = getSharedPreferences("prefs2", MODE_PRIVATE);
            //Creating editor object for shared preference
            SharedPreferences.Editor editor = sp.edit();
            //putting values as key-value pairs
            editor.remove("name");
            editor.remove("pass");
            editor.remove("selectedImageUri");
            //Committing data, so that its written to storage immediately.
            editor.commit();
            Intent intent_2 = new Intent(HomeActivity.this, SignupActivity.class);
            startActivity(intent_2);
            finish();
        });

    }


/**this part of the code is used to fetch the name and password from the signup activity
                                    NOT IMPORTANT  **/
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
//        SharedPreferences sharedPref =getSharedPreferences("prefs2",MODE_PRIVATE);
//        final SharedPreferences mSharedPreference= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
//        String value=(mSharedPreference.getString("name", ""));
//        received_msg = findViewById(R.id.receivedName);
//        Intent intent = getIntent();
//        String str = intent.getStringExtra("message_key");
//        received_msg.setText(str);

}