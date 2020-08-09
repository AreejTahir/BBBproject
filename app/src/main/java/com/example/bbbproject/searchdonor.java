package com.example.bbbproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class searchdonor extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    ImageView i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchdonor);
        b1=(Button)findViewById(R.id.A);
        b2=(Button)findViewById(R.id.a);

        b3=(Button)findViewById(R.id.B);
        b4=(Button)findViewById(R.id.b);

        b5=(Button)findViewById(R.id.AB);
        b6=(Button)findViewById(R.id.ab);

        b7=(Button)findViewById(R.id.O);
        b8=(Button)findViewById(R.id.o);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val="A+";
                Intent i=new Intent(searchdonor.this,Main3Activity.class);
                i.putExtra("x",val);

                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val="A-";
                Intent i=new Intent(searchdonor.this,Main3Activity.class);
                i.putExtra("x",val);
                startActivity(i);
            }
        });



        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val="B+";
                Intent i=new Intent(searchdonor.this,Main3Activity.class);
                i.putExtra("x",val);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val="B-";
                Intent i=new Intent(searchdonor.this,Main3Activity.class);
                i.putExtra("x",val);
                startActivity(i);
            }
        });


        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val="AB+";
                Intent i=new Intent(searchdonor.this,Main3Activity.class);
                i.putExtra("x",val);
                startActivity(i);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val="AB-";
                Intent i=new Intent(searchdonor.this,Main3Activity.class);
                i.putExtra("x",val);
                startActivity(i);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val="O+";
                Intent i=new Intent(searchdonor.this,Main3Activity.class);
                i.putExtra("x",val);
                startActivity(i);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val="O-";
                Intent i=new Intent(searchdonor.this,Main3Activity.class);
                i.putExtra("x",val);
                startActivity(i);
            }
        });


    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.logout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.home:
                Intent in=new Intent(this,choice2.class);
                startActivity(in);
                finish();
                return true;
            case R.id.lg:
                Intent inn=new Intent(this,choiceactivity.class);
                startActivity(inn);
                finish();
                Toast.makeText(getApplicationContext(),"Successfully Logged out!", LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}

