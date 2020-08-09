package com.example.bbbproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
import static com.example.bbbproject.DatabaseContract.User.TABLE_NAME;

public class Main2Activity extends AppCompatActivity {
    EditText name,city,mobile,password,blood;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    public static final String[] booodGroup=new String[]{"A+","A-","AB+","AB-","B+","B-","O+","O-"};
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final AutoCompleteTextView bloodgroup=findViewById(R.id.b);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,booodGroup);
        bloodgroup.setAdapter(adapter);
        ImageView image=(ImageView)findViewById(R.id.i1) ;
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodgroup.showDropDown();

            }
        });


        dbHelper = new DatabaseHelper(this);
        name=(EditText) findViewById(R.id.n);
        city=(EditText) findViewById(R.id.c);
        mobile=(EditText) findViewById(R.id.m);
        password=(EditText) findViewById(R.id.p);
        blood=(EditText) findViewById(R.id.b);
        b1=(Button) findViewById(R.id.bb);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1 = name.getText().toString();
                String n2 = city.getText().toString();
                String n3 = mobile.getText().toString();
                String n4 = password.getText().toString();
                String n5 = blood.getText().toString();


                //validation
                if (n1.isEmpty()) {
                    name.setError("Name cant be empty");
                }
                else if (n2.isEmpty()) {
                    city.setError("City cant be empty");
                }
                else if (n3.isEmpty()) {
                    mobile.setError("Mobile Number cant be empty");
                }

                else if(n3.length()<11 ||n3.length()>11)
                {
                    mobile.setError("Mobile number must be eleven digit long");}



                else if (n4.isEmpty()) {
                    password.setError("Password cant be empty");
                }
                else   if (n5.isEmpty()) {
                    blood.setError("BloodGroup cant be empty");
                }




                else
                {
                    db = dbHelper.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put(DatabaseContract.User.COL_Name, n1);
                    values.put(DatabaseContract.User.COL_City, n2);
                    values.put(DatabaseContract.User.COL_Mobile, n3);
                    values.put(DatabaseContract.User.COL_password, n4);
                    values.put(DatabaseContract.User.COL_Blood, n5);

                    long newRowId = db.insert(TABLE_NAME, null, values);
                    if (newRowId > 0) {
                        Toast.makeText(getApplicationContext(), "New Record Inserted: " + newRowId, LENGTH_SHORT).show();
                        finish();
                    }

                    db.close();
                }//else




                //     Toast.makeText(getApplicationContext(),"NAME "+n1+"CITY "+n2+"MOB "+n3+"PASS "+n4+"BLOOD"+n5, LENGTH_SHORT).show();



            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.edit,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.edit:
                Intent i=new Intent(this,login.class);
                startActivity(i);
                return true;
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
