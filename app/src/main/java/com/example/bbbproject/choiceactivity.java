package com.example.bbbproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.icu.text.DisplayContext.LENGTH_SHORT;
import static android.widget.Toast.makeText;



public class choiceactivity extends AppCompatActivity {
    EditText UNAME, PASWORD;
    Button b1,bp;
    DatabaseHelper dbHelper;
    String uname,pword;
    SQLiteDatabase db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choiceactivity);
        getSupportActionBar().setTitle("LOGIN TO SAVE LIFE");


        //  dbHelper = new DatabaseHelper(this);
        UNAME = (EditText) findViewById(R.id.n);
        PASWORD = (EditText) findViewById(R.id.c);

        b1 = (Button) findViewById(R.id.b2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1 = UNAME.getText().toString();
                String n2 = PASWORD.getText().toString();
                //   makeText(getApplicationContext(), n1+ n2, LENGTH_SHORT).show();



                if(n1.isEmpty())
                {
                    UNAME.setError("Username cant be empty!");

                }
                else if(n2.isEmpty())
                {
                    PASWORD.setError("Password cant be empty!");

                }




                else{
                    dbHelper = new DatabaseHelper(choiceactivity.this);
                    db = dbHelper.getWritableDatabase();

                    String[] columns = {DatabaseContract.Userss.COL_Uname, DatabaseContract.Userss.COL_city, DatabaseContract.Userss.COL_bloodg, DatabaseContract.Userss.COL_email, DatabaseContract.Userss.COL_REpassw, DatabaseContract.Userss.COL_nam, DatabaseContract.Userss.COL_passw};
                    String query = "SELECT * FROM " + DatabaseContract.Userss.TABLE_NAME;
                    Cursor c = db.query(DatabaseContract.Userss.TABLE_NAME, columns, DatabaseContract.Userss.COL_Uname + "=?",
                            new String[]{ n1}, null, null, null, null);
                    if(c.getCount()>0) {
                        c.moveToFirst();
                        //  while (c.moveToNext()) {
                        uname = c.getString(0);
                        pword = c.getString(4);


                        /// }
                        Toast.makeText(getApplicationContext(),uname+pword, Toast.LENGTH_SHORT).show();


                        if ((uname.equals(n1)) && (pword.equals(n2))) {
                            Intent intent = new Intent(choiceactivity.this, choice2.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(),"Invalid username3 or password", Toast.LENGTH_SHORT).show();

                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Invalid username4 or password", Toast.LENGTH_SHORT).show();
                    }
                    db.close();








                }//else end




            }
        });







        Button b11 = (Button) findViewById(R.id.b1);
        b11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                {

                    Intent intent = new Intent(choiceactivity.this, registration.class);
                    startActivity(intent);
                }
            }
        });


    }

}
