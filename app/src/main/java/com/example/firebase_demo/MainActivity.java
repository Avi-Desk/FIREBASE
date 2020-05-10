package com.example.firebase_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
EditText txtname,txtage,txtphone,txtheight;
Button btnsave;
DatabaseReference reff;
Member member;
long m=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtname=(EditText)findViewById(R.id.txtname);
        txtage=(EditText)findViewById((R.id.txtage));
        txtphone=(EditText)findViewById(R.id.txtphone);
        txtheight=(EditText)findViewById((R.id.txtheight));
        btnsave=(Button)findViewById(R.id.btnsave);
        member=new Member();
        reff= FirebaseDatabase.getInstance().getReference().child("Member");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    m=(dataSnapshot.getChildrenCount());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Agea=Integer.parseInt(txtage.getText().toString().trim());
                Float ht = Float.parseFloat((txtheight.getText().toString().trim()));
                Long pno = Long.parseLong(txtphone.getText().toString().trim());

                member.setName(txtname.getText().toString().trim());
                member.setAge(Agea);
                member.setHeight(ht);
                member.setPhone(pno);

                reff.child(String.valueOf(m+1)).setValue(member);
                Toast.makeText(MainActivity.this,"Data Inserted Sucessfully", Toast.LENGTH_LONG).show();

            }
        });


    }
}
