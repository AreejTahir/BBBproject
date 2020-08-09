package com.example.bbbproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;


public class Edit extends AppCompatActivity {

    String n,p,m,c,b,idd;
    EditText e1,e2,e3,e4,e5;
    String name,pasword,contact,city,blood;
    public static final String[] booodGroup=new String[]{"A+","A-","AB+","AB-","B+","B-","O+","O-"};
    DatabaseHelper dbHelper;

    String s1,s2,s3,s4,s5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        dbHelper = new DatabaseHelper(this);
        Intent i = getIntent();
        n = i.getStringExtra("name");
        p = i.getStringExtra("pword");
        m = i.getStringExtra("contact");
        c = i.getStringExtra("city");
        b = i.getStringExtra("blood");
        idd=i.getStringExtra("id");
        e1 = (EditText) findViewById(R.id.na);
        e2 = (EditText) findViewById(R.id.pa);
        e3 = (EditText) findViewById(R.id.ci);
        e4 = (EditText) findViewById(R.id.mo);
        e5 = (EditText) findViewById(R.id.bl);

        e1.setText(n);
        e2.setText(p);
        e3.setText(c);
        e4.setText(m);
        e5.setText(b);
        final AutoCompleteTextView bloodgroup = findViewById(R.id.bl);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, booodGroup);
        bloodgroup.setAdapter(adapter);
        ImageView image = (ImageView) findViewById(R.id.i1);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodgroup.showDropDown();

            }
        });

        Button bn = (Button) findViewById(R.id.bu);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText());
                e2.setText(e2.getText());
                e3.setText(e3.getText());
                e4.setText(e4.getText());
                e5.setText(e5.getText());
                name = e1.getText().toString();
                pasword = e2.getText().toString();
                city = e3.getText().toString();
                contact = e4.getText().toString();
                blood = e5.getText().toString();

                //validation
                if (name.isEmpty()) {
                    e1.setError("Name cant be empty");
                }
                else if (pasword.isEmpty()) {
                    e2.setError("Password cant be empty");
                }
                else if (city.isEmpty()) {
                    e3.setError("City cant be empty");
                }
                else if (contact.isEmpty()) {
                    e4.setError("Contact cant be empty");
                }
                else if(contact.length()<11 ||contact.length()>11)
                {
                    e4.setError("Mobile number must be eleven digit long");}


                else   if (blood.isEmpty()) {
                    e5.setError("BloodGroup cant be empty");
                }





                else {


                    Toast.makeText(getApplicationContext(), name + pasword + city + contact + blood, LENGTH_SHORT).show();












                    boolean isUpdated = dbHelper.UpdateRecord(idd,name, city, contact, pasword, blood);
                    if (isUpdated == true) {
                        Toast.makeText(getApplicationContext(), "Data is updated", LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getApplicationContext(), "Updation failed!", LENGTH_SHORT).show();
                    }
                    Intent i = new Intent(Edit.this, choice2.class);
                    startActivity(i);
                    finish();


                }//else end
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
                Intent in=new Intent(Edit.this,choice2.class);
                startActivity(in);
                finish();
                return true;
            case R.id.lg:
                Intent i=new Intent(Edit.this,choiceactivity.class);
                startActivity(i);
                finish();
                Toast.makeText(getApplicationContext(),"Successfully Logged out!", LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }




}
