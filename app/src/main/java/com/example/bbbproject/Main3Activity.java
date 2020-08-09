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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class Main3Activity extends AppCompatActivity {

    String letter;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    String mm;
    String name1,city,mobile,password,bloodG;
    String name2,mobile2,city2,password2,bloodG2;
    ImageView i;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toast.makeText(getApplicationContext(), "Please click on the name to know details of the donor! " , LENGTH_SHORT).show();
        i=findViewById(R.id.search);
        Intent intent2 = getIntent();
        letter =(intent2.getStringExtra("x"));
        // Toast.makeText(this,letter, Toast.LENGTH_SHORT).show();
        dbHelper=new DatabaseHelper(this);
        // db=dbHelper.getReadableDatabase();
        final List<String> usersList=new ArrayList();



     /*   String val1 = naa;
        String[] columns={DatabaseContract.Users._ID, COL_NAME,COL_CONTINENT,COL_POPULATION,COL_AREA,COL_FLAG,COL_LANGUAGE};
        Cursor c = db.query(TABLE_NAME, columns, COL_NAME + "=?",
          */


        String bloodgroup=letter;
        db=dbHelper.getWritableDatabase();
        String[] columns = { DatabaseContract.User._ID, DatabaseContract.User.COL_Name, DatabaseContract.User.COL_City,DatabaseContract.User.COL_Mobile,
                DatabaseContract.User.COL_password,DatabaseContract.User.COL_Blood};
        String query = "SELECT * FROM "+DatabaseContract.User.TABLE_NAME ;
        Cursor c = db.query(DatabaseContract.User.TABLE_NAME,columns,DatabaseContract.User.COL_Blood + "=?",
                new String[] {bloodgroup}, null, null, null, null);
        if(c.getCount()>0) {
            while (c.moveToNext()) {

                Long id = c.getLong(0);
                name1 = c.getString(1);
                city = c.getString(2);
                mobile = c.getString(3);
                password = c.getString(4);
                bloodG = c.getString(5);

                usersList.add(name1);
            }


            lv=(ListView) findViewById(R.id.list);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, usersList);

            lv.setAdapter(adapter);

            // c.close();
            mm="0".concat(mobile);
            // Toast.makeText(getApplicationContext(), mm, Toast.LENGTH_SHORT).show();

            final Intent n=new Intent(this,DonarDetail.class);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String naa = ((TextView) view).getText().toString();
                    //  Toast.makeText(getApplicationContext(),   naa, Toast.LENGTH_SHORT).show();





                    db=dbHelper.getWritableDatabase();
                    String[] columns = { DatabaseContract.User._ID, DatabaseContract.User.COL_Name, DatabaseContract.User.COL_City,DatabaseContract.User.COL_Mobile,
                            DatabaseContract.User.COL_password,DatabaseContract.User.COL_Blood};
                    String query = "SELECT * FROM "+DatabaseContract.User.TABLE_NAME ;
                    Cursor c = db.query(DatabaseContract.User.TABLE_NAME,columns,DatabaseContract.User.COL_Name + "=?",
                            new String[] {naa}, null, null, null, null);
                    if(c.getCount()>0) {
                        while (c.moveToNext()) {

                            Long idd = c.getLong(0);
                            name2 = c.getString(1);
                            city2 = c.getString(2);
                            mobile2 = c.getString(3);
                            password2 = c.getString(4);
                            bloodG2 = c.getString(5);




                            String m="0".concat(mobile2);

                            n.putExtra("namee",name2);
                            n.putExtra("mobilee",m);

                            n.putExtra("pword",password2);

                            n.putExtra("cityy",city2);
                            n.putExtra("bloodg",bloodG2);
                            startActivity(n);

                            //  usersList.add(name1);
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "No record found " , LENGTH_SHORT).show();

                    }
                    db.close();

                }

            });


















        }
        else
        {
            Toast.makeText(getApplicationContext(), "No record found " , LENGTH_SHORT).show();

        }
        db.close();







        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e1 = (EditText) findViewById(R.id.t1);
                String val = e1.getText().toString();
                if (val.isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Please enter city name! " , LENGTH_SHORT).show();
                }
                //   usersList.clear();

                // Toast.makeText(getApplicationContext(),val, Toast.LENGTH_SHORT).show();
                else{
                    db = dbHelper.getWritableDatabase();
                    String[] columns = {DatabaseContract.User._ID, DatabaseContract.User.COL_Name, DatabaseContract.User.COL_City, DatabaseContract.User.COL_Mobile,
                            DatabaseContract.User.COL_password, DatabaseContract.User.COL_Blood};
                    String query = "SELECT * FROM " + DatabaseContract.User.TABLE_NAME;
                    Cursor c = db.query(DatabaseContract.User.TABLE_NAME, columns, DatabaseContract.User.COL_City + "=?",
                            new String[]{val}, null, null, null, null);
                    if (c.getCount() > 0) {
                        usersList.clear();
                        while (c.moveToNext()) {

                            Long id = c.getLong(0);
                            name1 = c.getString(1);
                            city = c.getString(2);
                            mobile = c.getString(3);
                            password = c.getString(4);
                            bloodG = c.getString(5);
                            if(bloodG.equals(letter)) {

                                usersList.add(name1);
                            }
                        }


                        lv = (ListView) findViewById(R.id.list);
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Main3Activity.this, android.R.layout.simple_list_item_1, usersList);

                        lv.setAdapter(adapter);

                        // c.close();
                        mm = "0".concat(mobile);
                        //  Toast.makeText(getApplicationContext(), mm, Toast.LENGTH_SHORT).show();

                        final Intent n = new Intent(Main3Activity.this, DonarDetail.class);
                        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String naa = ((TextView) view).getText().toString();
                                // Toast.makeText(getApplicationContext(), naa, Toast.LENGTH_SHORT).show();


                                db = dbHelper.getWritableDatabase();
                                String[] columns = {DatabaseContract.User._ID, DatabaseContract.User.COL_Name, DatabaseContract.User.COL_City, DatabaseContract.User.COL_Mobile,
                                        DatabaseContract.User.COL_password, DatabaseContract.User.COL_Blood};
                                String query = "SELECT * FROM " + DatabaseContract.User.TABLE_NAME;
                                Cursor c = db.query(DatabaseContract.User.TABLE_NAME, columns, DatabaseContract.User.COL_Name + "=?",
                                        new String[]{naa}, null, null, null, null);
                                if (c.getCount() > 0) {
                                    while (c.moveToNext()) {

                                        Long idd = c.getLong(0);
                                        name2 = c.getString(1);
                                        city2 = c.getString(2);
                                        mobile2 = c.getString(3);
                                        password2 = c.getString(4);
                                        bloodG2 = c.getString(5);


                                        String m = "0".concat(mobile2);
                                        //if(bloodG2.equals(letter)){
                                        n.putExtra("namee", name2);
                                        n.putExtra("mobilee", m);

                                        n.putExtra("pword", password2);

                                        n.putExtra("cityy", city2);
                                        n.putExtra("bloodg", bloodG2);
                                        startActivity(n);}


                                    //  usersList.add(name1);
                                    // }
                                } else {
                                    Toast.makeText(getApplicationContext(), "No record found ", LENGTH_SHORT).show();

                                }
                                db.close();

                            }

                        });


                    } else {
                        Toast.makeText(getApplicationContext(), "No record found ", LENGTH_SHORT).show();

                    }
                    db.close();


                }//else




















            }
        });//end i listener

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

