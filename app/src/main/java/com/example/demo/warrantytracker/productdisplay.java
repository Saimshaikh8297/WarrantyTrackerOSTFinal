package com.example.demo.warrantytracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class productdisplay extends AppCompatActivity {

    DatabaseReference databaseReference;
    TextView t1,t2,t3;
    FirebaseUser firebaseUser;
    String userd,userm,usery;
    String prodkey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdisplay);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("users");
        t1=(TextView) findViewById(R.id.textView1);
        t2=(TextView) findViewById(R.id.textView2);
        t3=(TextView) findViewById(R.id.textView3);
        Bundle bundle=getIntent().getExtras();
        prodkey=bundle.getString("name");

        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children=dataSnapshot.child(firebaseUser.getUid()).getChildren();

               for(DataSnapshot key: children)
               {
                  User user=key.getValue(User.class);

                   //t1.setText(userp);
                   //t2.setText(user.cname);
                  if(user.pname.equals(prodkey))
                  {
                      t2.setText("Product Name: "+user.pname);
                      t1.setText("Company Name: "+key.child("cname").getValue().toString());
                      userd=key.child("day").getValue().toString();
                      userm=key.child("month").getValue().toString();
                      usery=key.child("year").getValue().toString();
                      //t3.setText(user.day);
                      t3.setText("Purchase Date: "+userd+"/"+userm+"/"+usery);

                  }


               }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





    }



    }

