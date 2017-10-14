package com.example.demo.warrantytracker;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Product extends AppCompatActivity {

    EditText e1,e2;
    Button b1,b2;
    DatePicker d1;
    DatabaseReference database;
    FirebaseUser firebaseUser;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        database = FirebaseDatabase.getInstance().getReference().child("users");
        e1=(EditText)findViewById(R.id.cname);
        e2=(EditText)findViewById(R.id.pname);
        b1=(Button)findViewById(R.id.gallery);
        b2=(Button)findViewById(R.id.camera);
        d1=(DatePicker)findViewById(R.id.simpleDatePicker);

       firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        Log.i("Flub",firebaseUser.getUid());

    }



    public void writeNewUser(View view) {

        String cname=e1.getText().toString();
        String pname=e2.getText().toString();
        int day=d1.getDayOfMonth();
        int month=d1.getMonth()+1;
        int year=d1.getYear();

        User user = new User(cname,pname,day,month,year);



        if(!cname.isEmpty()&&!pname.isEmpty()) {
            //Log.i("UID",firebaseUser.getUid());
            database.child(firebaseUser.getUid()).child(pname).setValue(user);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Please do not leave fields empty",Toast.LENGTH_LONG).show();
        }
    }
}
