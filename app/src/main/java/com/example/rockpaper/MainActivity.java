package com.example.rockpaper;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference ref=db.getReference();
    DatabaseReference gref=ref.child("game");

    TextView tv;
    Button bt2 ;
    Button bt1;
    Button bt3 ;
    @Override
    protected void onStart() {
        super.onStart();

        gref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String string =dataSnapshot.getValue().toString();
                tv.setText(string);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // ref.child("user").setValue("rand");
       tv= (TextView)findViewById(R.id.textView);
        bt2=(Button)findViewById(R.id.paper);
         bt1 =(Button)findViewById(R.id.rock);
         bt3 =(Button)findViewById(R.id.scisor);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              gref.setValue("Rock");
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gref.setValue("Paper");
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gref.setValue("Scisor");
            }
        });




    }

}
