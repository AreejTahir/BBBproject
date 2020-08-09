package com.example.bbbproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class choice2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice2);
        Button b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                {

                    Intent intent = new Intent(choice2.this, searchdonor.class);
                    startActivity(intent);
                }
            }
        });
        Button b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                {

                    Intent intent = new Intent(choice2.this, Main2Activity.class);
                    startActivity(intent);
                }
            }
        });


        Button b3=(Button)findViewById(R.id.con);
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                {

                    Intent intent = new Intent(choice2.this, ContactUs.class);
                    startActivity(intent);
                }
            }


        } );


        Button b4=(Button)findViewById(R.id.b3);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(choice2.this,login.class);
                startActivity(intent);
            }
        });


        Button b5=(Button)findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(choice2.this,Username.class);
                startActivity(intent);
            }
        });



    }

    @Override
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
                Intent in=new Intent(choice2.this,choice2.class);
                startActivity(in);
                finish();
                return true;
            case R.id.lg:
                Intent i=new Intent(choice2.this,choiceactivity.class);
                startActivity(i);
                finish();
                Toast.makeText(getApplicationContext(),"Successfully Logged out!", LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
