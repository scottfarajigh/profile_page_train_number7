package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button saveInformationBtn = findViewById(R.id.main_saveInformation_btn);
        saveInformationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Informations Saved " , Toast.LENGTH_LONG).show();
            }
        });

        CheckBox androidCb = findViewById(R.id.main_android_cb);
        androidCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this,"Android Skill selected",Toast.LENGTH_LONG).show();
            }
        });

        CheckBox seepLearningCb = findViewById(R.id.main_deepLearning_cb);
        seepLearningCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this,"DeepLearning Skill selected",Toast.LENGTH_LONG).show();
            }
        });

        CheckBox uiCb = findViewById(R.id.main_ui_cb);
        uiCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this,"UI/UX Skill selected",Toast.LENGTH_LONG).show();
            }
        });
        RadioGroup radioGroup = findViewById(R.id.main_radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.main_tehran_rb:
                        Toast.makeText(MainActivity.this,"you select TEHRAN",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.main_alborz_rb:
                        Toast.makeText(MainActivity.this,"you select ALBORZ",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.main_gilan_rb:
                        Toast.makeText(MainActivity.this,"you select GILAN",Toast.LENGTH_LONG).show();
                }
            }
        });

        Button editProfileBtn = findViewById(R.id.main_editProfile_btn);
        editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Activit_editProfile.class);
                TextView userNameTv = findViewById(R.id.main_userName_tv);
                intent.putExtra("userName",userNameTv.getText());

                TextView userBioTv = findViewById(R.id.main_userBio_tv);
                intent.putExtra("userBio",userBioTv.getText());
                startActivityForResult(intent,2222);
            }
        });

        Button viewWebBtn = findViewById(R.id.main_viewWev_btn);
        viewWebBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://shahreketabonline.com"));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2222 && resultCode == Activity.RESULT_OK && data != null){

            String userName = data.getStringExtra("userName");
            TextView textView = findViewById(R.id.main_userName_tv);
            textView.setText(userName);

            String userBio = data.getStringExtra("userBio");
            TextView textView2 = findViewById(R.id.main_userBio_tv);
            textView2.setText(userBio);

        }
    }
}