package com.example.fogas_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class mainmenu extends AppCompatActivity {

    Button callPractiseUp;
    Button callPairsUp;
    Button callMemoryUp;
    Button exitApp;
    DatabaseReference pairRef;
    private ArrayList<Pair> loadedPairs;
    private ArrayList<Pair> loadedOrderedPairs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mainmenu);

        callPractiseUp = findViewById(R.id.practise_screen);

        //database
        loadedPairs = new ArrayList<>();
        pairRef = FirebaseDatabase.getInstance().getReference("/pairs");
        //database

        callPractiseUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainmenu.this, practise.class);
                startActivity(intent);
            }
        });

        callPairsUp = findViewById(R.id.pair_screen);

        callPairsUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainmenu.this, setpairs.class);
                Collections.sort(loadedPairs, new Comparator<Pair>() {
                    @Override
                    public int compare(Pair o1, Pair o2) {
                        return o1.getNumber().compareTo(o2.getNumber());
                    }
                });
                intent.putExtra("PAIR_LIST", loadedPairs);
                startActivity(intent);
            }
        });

        callMemoryUp = findViewById(R.id.memory_screen);

        callMemoryUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainmenu.this ,memory.class);
                startActivity(intent);
            }
        });




        pairRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Pair pair = snapshot.getValue(Pair.class);
                System.out.println("###Loaded: onChildAdded" + pair.getText());
                loadedPairs.add(pair);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                loadedPairs.remove(lastModifiedSingleton.getInstance().getLastModified());
                Pair pair = snapshot.getValue(Pair.class);
                System.out.println("###Loaded onChildChanged: " + pair.getText());
                loadedPairs.add(pair);
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                Pair pair = snapshot.getValue(Pair.class);
                loadedPairs.remove(pair);
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





        exitApp = findViewById(R.id.exit);
        exitApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0 );

            }
        });


    }
}