package com.example.fogas_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class practise extends AppCompatActivity {

    Button callMemory;
    Button backbtn;
    Button callPairs;
    Button randomNumberBtn;
    EditText sorozat_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_practise);

        callMemory = findViewById(R.id.help_screen);


        callMemory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(practise.this ,memory.class);
                startActivity(intent);
            }
        });

        callPairs = findViewById(R.id.pair_button);

        callPairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(practise.this, setpairs.class);
                startActivity(intent);
            }
        });


        backbtn = findViewById(R.id.backbutton);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });

        randomNumberBtn = findViewById(R.id.random_btn);
        sorozat_text = findViewById(R.id.sorozat_text);
        randomNumberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String randomString = generateRandomString();
                sorozat_text.setText(randomString);
            }
        });

    }

    String generateRandomString(){
        String randomString = "";
        Random random = new Random();
        for(int i=0; i<10; i++){
            int randomNumber = random.nextInt(10);
            randomString += (Integer.toString(randomNumber));
        }
        System.out.println(randomString);
        return randomString;
    }
}