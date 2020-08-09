package com.example.bbbproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class Username extends AppCompatActivity {
    EditText UNAME, PASWORD;
    Button b1;
    String h;

    String uname,pword,contact,city,mobile,blood,ID;
    SQLiteDatabase db;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);

        dbHelper = new DatabaseHelper(this);
        UNAME = (EditText) findViewById(R.id.nn);
        PASWORD = (EditText) findViewById(R.id.pp);
        b1 = (Button) findViewById(R.id.boo);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1 = UNAME.getText().toString();
                String n2 = PASWORD.getText().toString();

                if (n1.isEmpty()) {
                    UNAME.setError("Enter Name");
                } else if (n2.isEmpty()) {
                    PASWORD.setError("Enter Password");
                }

                else
                {
                    db = dbHelper.getWritableDatabase();

                    String[] columns = {DatabaseContract.User._ID,DatabaseContract.User.COL_Name, DatabaseContract.User.COL_password, DatabaseContract.User.COL_Blood, DatabaseContract.User.COL_City, DatabaseContract.User.COL_Mobile};
                    String query = "SELECT * FROM " + DatabaseContract.User.TABLE_NAME;
                    Cursor c = db.query(DatabaseContract.User.TABLE_NAME, columns, DatabaseContract.User.COL_Name + "=?",
                            new String[]{ n1 }, null, null, null, null);
                    if(c.getCount()>0) {
                        //     while (c.moveToNext()) {
                        c.moveToFirst();
                        Long id=c.getLong(0);
                        uname = c.getString(1);
                        pword = c.getString(2);
                        blood = c.getString(3);


                        city = c.getString(4);
//String h=c.getString(5);
                        contact = c.getString(5);
                        String kk=String.valueOf(id);
                        Toast.makeText(getApplicationContext(), kk+uname+pword+blood+city, LENGTH_SHORT).show();

                        h = "0".concat(contact);
                        if ((uname.equals(n1)) && (pword.equals(n2))) {
                            Intent intent = new Intent(Username.this, Main4Activity.class);
                            intent.putExtra("id",kk);

                            intent.putExtra("name", uname);
                            intent.putExtra("pword", pword);
                            intent.putExtra("blood", blood);
                            intent.putExtra("city", city);
                            intent.putExtra("contact", h);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Invalid Name or Password", LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Invalid Name or Password", LENGTH_SHORT).show();
                    }

                    //   }
                    db.close();
                    // makeText(getApplicationContext(), "UNAME " + uname + "PASS " + pword +"  "+city, LENGTH_SHORT).show();





                }//else


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
                Intent in=new Intent(Username.this,choice2.class);
                startActivity(in);
                finish();
                return true;
            case R.id.lg:
                Intent i=new Intent(Username.this,choiceactivity.class);
                startActivity(i);
                finish();
                Toast.makeText(getApplicationContext(),"Successfully Logged out!", LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }




}