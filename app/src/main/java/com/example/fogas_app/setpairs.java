package com.example.fogas_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class setpairs extends AppCompatActivity {

    Button backbtn, btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
    DatabaseReference mDatabase;
    DatabaseReference pairRef;
    EditText edit_0, edit_1, edit_2, edit_3, edit_4, edit_5, edit_6, edit_7, edit_8, edit_9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setpairs);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        pairRef = FirebaseDatabase.getInstance().getReference("/pairs");
        backbtn = findViewById(R.id.btn_back);
        ArrayList<Pair> loadedPairs = new ArrayList<>();
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        edit_0 = findViewById(R.id.edit_0);
        edit_1 = findViewById(R.id.edit_1);
        edit_2 = findViewById(R.id.edit_2);
        edit_3 = findViewById(R.id.edit_3);
        edit_4 = findViewById(R.id.edit_4);
        edit_5 = findViewById(R.id.edit_5);
        edit_6 = findViewById(R.id.edit_6);
        edit_7 = findViewById(R.id.edit_7);
        edit_8 = findViewById(R.id.edit_8);
        edit_9 = findViewById(R.id.edit_9);

        ArrayList<EditText> editTexts =  new ArrayList<>();
        editTexts.add(edit_0);
        editTexts.add(edit_1);
        editTexts.add(edit_2);
        editTexts.add(edit_3);
        editTexts.add(edit_4);
        editTexts.add(edit_5);
        editTexts.add(edit_6);
        editTexts.add(edit_7);
        editTexts.add(edit_8);
        editTexts.add(edit_9);

        if(getIntent().hasExtra("PAIR_LIST")){
            loadedPairs = getIntent().getParcelableArrayListExtra("PAIR_LIST");
        }

        if(!loadedPairs.isEmpty()){
            for(int i=0; i<loadedPairs.size(); i++){
               renderData(editTexts.get(i), i, loadedPairs);
           }
        }

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastModifiedSingleton.getInstance().setLastModified(0);
                saveDataToDatabase(edit_0, "0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastModifiedSingleton.getInstance().setLastModified(1);
                saveDataToDatabase(edit_1, "1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastModifiedSingleton.getInstance().setLastModified(2);
                saveDataToDatabase(edit_2, "2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastModifiedSingleton.getInstance().setLastModified(3);
                saveDataToDatabase(edit_3, "3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastModifiedSingleton.getInstance().setLastModified(4);
                saveDataToDatabase(edit_4, "4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastModifiedSingleton.getInstance().setLastModified(5);
                saveDataToDatabase(edit_5, "5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastModifiedSingleton.getInstance().setLastModified(6);
                saveDataToDatabase(edit_6, "6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastModifiedSingleton.getInstance().setLastModified(7);
                saveDataToDatabase(edit_7, "7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastModifiedSingleton.getInstance().setLastModified(8);
                saveDataToDatabase(edit_8, "8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastModifiedSingleton.getInstance().setLastModified(9);
                saveDataToDatabase(edit_9, "9");
            }
        });

    }

    void renderData(EditText editText, int index, ArrayList<Pair> loadedPairs){
        editText.setText(loadedPairs.get(index).getText());
    }

    void saveDataToDatabase(EditText input, String key){
        String inputText = input.getText().toString();
        Pair pairToSave = new Pair(key,inputText);
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().push();
        mDatabase.child("pairs").child(key).setValue(pairToSave);
        System.out.println("data saved");
    }



}
