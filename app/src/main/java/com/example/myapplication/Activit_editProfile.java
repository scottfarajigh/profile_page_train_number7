package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activit_editProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activit_edit_profile);

        String userName = getIntent().getStringExtra("userName");
        String userBio = getIntent().getStringExtra("userBio");

        EditText editText = findViewById(R.id.EditProfile_et);
        EditText editText2 = findViewById(R.id.bio_et);
        editText2.setText(userBio);
        editText.setText(userName);
        Button doneBtn = findViewById(R.id.doneBtn);

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editText.getText().toString();
                String userBio = editText2.getText().toString();
                Intent intent = new Intent();

                intent.putExtra("userName",userName);
                intent.putExtra("userBio",userBio);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}