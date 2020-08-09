package com.example.bbbproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Pattern;

import static android.widget.Toast.LENGTH_SHORT;
import static com.example.bbbproject.DatabaseContract.User.TABLE_NAME;

public class registration extends AppCompatActivity {

    EditText name,city,mobile,password,username,repassword,email;
    private static final Pattern Name_pattern=Pattern.compile( "(?=.*[a-zA-Z])");

    //   String matchname="(?=.*[a-zA-Z])";
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    Spinner s;
    ImageView image;
    Button b1;
    AutoCompleteTextView bloodgroup;
    public static final String[] booodGroup=new String[]{"A+","A-","AB+","AB-","B+","B-","O+","O-"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // getSupportActionBar().setTitle("REGISTER TO SAVE LIFE");

        bloodgroup=findViewById(R.id.b);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,booodGroup);
        bloodgroup.setAdapter(adapter);
        image=(ImageView)findViewById(R.id.i1) ;
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodgroup.showDropDown();

            }
        });


        dbHelper = new DatabaseHelper(this);
        username=(EditText) findViewById(R.id.n);
        name=(EditText) findViewById(R.id.n2);
        city=(EditText) findViewById(R.id.c);
        mobile=(EditText) findViewById(R.id.m);
        password=(EditText) findViewById(R.id.p);
        repassword=(EditText) findViewById(R.id.p1);
        // bloodgroup=(EditText) findViewById(R.id.b);
        email=(EditText) findViewById(R.id.e1);

      /*  String[] bloodGroup=getResources().getStringArray(R.array.blood_group1);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,bloodGroup);
        bloodgroup.setAdapter(adapter);*/
        // s=(Spinner) findViewById(R.id.spiner);
       /* String[] bloodGroup=getResources().getStringArray(R.array.blood_groupp);
        ArrayAdapter adopter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,bloodGroup);
        adopter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        s.setAdapter(adopter);*/
        b1=(Button) findViewById(R.id.bb);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1=username.getText().toString();
                String n2=name.getText().toString();
                String n3=city.getText().toString();
                String n4=mobile.getText().toString();
                String n5=password.getText().toString();
                String n6=repassword.getText().toString();
                String n7=bloodgroup.getText().toString();
                String n8=email.getText().toString();

                if(n1.isEmpty()) {
                    username.setError("Username cant be empty");}
                else if(n2.isEmpty()) {
                    name.setError("Name cant be empty");}
             /*   else if(!n2.matches("/^[a-z,A-Z]*$/")) //name can only have alphabets and space
                   { name.setError("Name can only have Alphabets");}*/



               /*    else if(n2.matches("[0-9]*"))
                   { name.setError("Name can only have Alphabets");}
                   else if(n2.matches("[@#$%^&+=-_?/;:.,`!(){}[]]*"))
                   { name.setError("Name can only have Alphabets");}*/



                else if(n3.isEmpty()) {
                    city.setError("City cant be empty");}
               /*    else if(!n3.matches("[a-z,A-Z]*"))
                   { city.setError("City can only have Alphabets");}*/
                else if(n4.isEmpty()) {
                    mobile.setError("Mobile number cant be empty");}

                else if(n4.length()<11 ||n4.length()>11)
                {
                    mobile.setError("Mobile number must be eleven digit long");
                    //Toast.makeText(getApplicationContext(), "Mobile number must be eleven digit long", LENGTH_SHORT).show();
                }
                else if(n5.isEmpty()) {
                    password.setError("Password cant be empty");}
                else if(n5.length()<6)
                {password.setError("Please enter password of minimum length 6");}

                else if(n6.isEmpty()) {
                    repassword.setError("Field cant be empty");}
                else if(!n5.equals(n6))
                {
                    repassword.setError("Password  not matched");
                }
                else if(n7.isEmpty()) {
                    bloodgroup.setError("BloodGroup cant be empty");}
                else if(n8.isEmpty()) {
                    email.setError("Email cant be empty");
                }











                else if(!Patterns.EMAIL_ADDRESS.matcher(n8).matches())//matches given input with pattern
                {
                    email.setError("Please enter valid email address");
                }












                else {
                    db = dbHelper.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put(DatabaseContract.Userss.COL_Uname, n1);
                    values.put(DatabaseContract.Userss.COL_nam, n2);
                    values.put(DatabaseContract.Userss.COL_city, n3);
                    values.put(DatabaseContract.Userss.COL_mob, n4);
                    values.put(DatabaseContract.Userss.COL_passw, n5);
                    values.put(DatabaseContract.Userss.COL_REpassw, n6);
                    values.put(DatabaseContract.Userss.COL_bloodg, n7);
                    values.put(DatabaseContract.Userss.COL_email, n8);

                    long newRowId = db.insert(TABLE_NAME, null, values);
                    if (newRowId > 0) {
                        //  Toast.makeText(getApplicationContext(), "New Record Inserted: " + newRowId, LENGTH_SHORT).show();

                        Toast.makeText(getApplicationContext(), "Successfully Registered!", LENGTH_SHORT).show();
                    }

                    db.close();
                    // Toast.makeText(getApplicationContext(), "UNAME " + n1 + "NAME " + n2 + "CITY " + n3 + "MOBILE " + n4 + "PASWORD " + n5 + "REPASWORD " + n6 + "BLOOD GROUP " + n7 + "EMAIL " + n8, LENGTH_SHORT).show();
                    Intent intent = new Intent(registration.this, choice2.class);
                    startActivity(intent);
                }
            }
        });
    }

}
