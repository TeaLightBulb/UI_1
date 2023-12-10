package com.example.ui_1;

import static com.example.ui_1.R.id.*;

import static kotlinx.coroutines.BuildersKt.launch;
import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SignupActivity extends AppCompatActivity {

    EditText userNameED;
    EditText passwordED;
    Button button;
    ImageView userDPED;
    CheckBox indianCheckBox;
    int indian;

    RadioGroup radioGroup;
    RadioButton male_button ;
    RadioButton female_button;
    int gender;

    String profPic ;

    ImageView chooseImage;
    ImageView profileImage;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        indianCheckBox = findViewById(check_nationality);
        indianCheckBox.setOnCheckedChangeListener(
            (buttonView, isChecked) -> {
                if(isChecked){
                    indian = 1;
                }
                else{
                    indian = 0;
                }
            }
        );

        radioGroup = findViewById(radio_gender);
        male_button = findViewById(radio_male);
        female_button = findViewById(radio_female);

        radioGroup.setOnCheckedChangeListener(
                (group, checkedId) -> {
                    if(checkedId == male_button.getId()){
                        //  if the male radio is selected the gender veriable is set to 1
                        gender = 1;
                    }
                    else{
                        //else female radio is selected the gender veriable is set to 0
                        gender = 0;
                    }
                }
        );


        button = findViewById(button_first);
        userNameED = findViewById(ED1);
        passwordED = findViewById(ED2);
        userDPED = findViewById(profilePic);

        /**  taking the name pass and other inputs  **/
        SharedPreferences sharedPreferences = getSharedPreferences("prefs2", MODE_PRIVATE);
        String str_name = sharedPreferences.getString("name","");
        String str_pass = sharedPreferences.getString("pass","");
        int checkBox = sharedPreferences.getInt("check", Integer.parseInt("0"));
        if(!str_name.equals("") && !str_pass.equals("")){
            Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }


        /**choose the image and send the image to the Homeactivity**/
        chooseImage = findViewById(camera);
        profileImage = findViewById(profilePic);
        ActivityResultLauncher<PickVisualMediaRequest> pickMedia =
                registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), uri -> {
                    if (uri != null) {
                        Log.d("PhotoPicker", "Selected URI: " + uri);
                        profileImage.setImageURI(uri);

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        //putting the uri as key value pair
                        editor.putString("selectedImageUri", uri.toString());
                        editor.apply();

                        /* Send the selected URI to HomeActivity*/
                        /*The problem with this code is that the moment you upload the image the code takes you to the HomeActivity*/
//                        Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
//                        intent.putExtra("selectedImageUri", uri.toString());
//                        startActivity(intent);
                    } else {
                        Log.d("PhotoPicker", "No media selected");
                    }
                });
        chooseImage.setOnClickListener(v ->
        {
            pickMedia.launch(new PickVisualMediaRequest.Builder()
                    .setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE)
                    .build());
        });

        button.setOnClickListener(v ->
        {
            /**taking inputs form relative Textview**/
            String name = userNameED.getText().toString();
            String password = passwordED.getText().toString();

            //Creating a variable sp to store Shared Preference object
            SharedPreferences sp = getSharedPreferences("prefs2", MODE_PRIVATE);
            //Creating editor object for shared preference
            SharedPreferences.Editor editor = sp.edit();
            //putting values as key-value pairs
            editor.putString("name", name);
            editor.putString("pass", password);
            editor.putInt("nationality", indian);
            editor.putInt("gender", gender);
            //Committing data, so that its written to storage immediately.
            editor.commit();
            Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });




    }
}