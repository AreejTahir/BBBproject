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
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class Main4Activity extends AppCompatActivity {
    String n,p,m,c,b,idd;
    TextView e1,e2,e3,e4,e5;
    SQLiteDatabase db;
    DatabaseHelper dbHelper;
    String name,pasword,contact,city,blood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);



        dbHelper = new DatabaseHelper(this);
        Intent i = getIntent();
        n = i.getStringExtra("name");
        p = i.getStringExtra("pword");
        m = i.getStringExtra("contact");
        c = i.getStringExtra("city");
        b = i.getStringExtra("blood");
        idd=i.getStringExtra("id");
        e1 = (TextView) findViewById(R.id.naa);
        e2 = (TextView) findViewById(R.id.paa);
        e3 = (TextView) findViewById(R.id.cii);
        e4 = (TextView) findViewById(R.id.moo);
        e5 = (TextView) findViewById(R.id.bll);

        e1.setText(n);
        e2.setText(p);
        e3.setText(c);
        e4.setText(m);
        e5.setText(b);


        Button b=(Button)findViewById(R.id.del);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = dbHelper.getWritableDatabase();
                Integer i=db.delete(DatabaseContract.User.TABLE_NAME,DatabaseContract.User._ID + "=?",new String[] {idd});
                if (i > 0) {
                    Toast.makeText(Main4Activity.this,"Donor Deleted! " , Toast.LENGTH_SHORT).show();
                }
                db.close();
                Intent iM = new Intent(Main4Activity.this, choice2.class);
                startActivity(iM);
                finish();
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
                Intent i=new Intent(this,choiceactivity.class);
                startActivity(i);
                finish();
                Toast.makeText(getApplicationContext(),"Successfully Logged out!", LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
