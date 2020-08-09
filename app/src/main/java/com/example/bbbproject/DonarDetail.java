package com.example.bbbproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class DonarDetail extends AppCompatActivity {
    String n,c,m,p,b;
    TextView t,t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_detail);
        Intent i=getIntent();
        n=i.getStringExtra("namee");
        m=i.getStringExtra("mobilee");
        Toast.makeText(this,m,Toast.LENGTH_SHORT).show();
        //  p=i.getStringExtra("pword");
        c=i.getStringExtra("cityy");

        b=i.getStringExtra("bloodg");
        t=(TextView)findViewById(R.id.n);
        t.setText(n);
        t1=(TextView)findViewById(R.id.c);
        t1.setText(c);

        t2=(TextView)findViewById(R.id.b);
        t2.setText(b);
        t3=(TextView)findViewById(R.id.co);
        t3.setText(m);


    }
    public void call(View view)
    {
        Intent i=new Intent(this,Request.class);
        i.putExtra("mobNo",m);
        startActivity(i);

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
                Intent in=new Intent(DonarDetail.this,choice2.class);
                startActivity(in);
                finish();
                return true;
            case R.id.lg:
                Intent i=new Intent(DonarDetail.this,choiceactivity.class);
                startActivity(i);
                finish();
                Toast.makeText(getApplicationContext(),"Successfully Logged out!", LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}



