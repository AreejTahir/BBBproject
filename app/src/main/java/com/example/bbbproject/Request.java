package com.example.bbbproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class Request extends AppCompatActivity {
    String contact;
    private static final int REQUEST_CALL=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        Intent i=getIntent();
        contact=i.getStringExtra("mobNo");
        ImageView imagecall=(ImageView)findViewById(R.id.Phoneecall);
        imagecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MakePhoneCall();
            }
        });

    }
    private void MakePhoneCall()
    {
        if(contact.trim().length()>0)
        {
            if(ContextCompat.checkSelfPermission(Request.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(Request.this,new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }
            else{
                String dail="tel:"+contact;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dail)));
            }
        }

        // Toast.makeText(getApplicationContext(), "Clicked" ,LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==REQUEST_CALL)
        {
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
            {
                MakePhoneCall();
            }
            else
            {
                Toast.makeText(this,"Permission denied", LENGTH_SHORT).show();
            }
        }
    }
    public void Sentmessage(View view)
    {
        //  int y=Integer.parseInt(contact);
        /*Intent intent=new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms","03349918806",null));
        intent.putExtra("sms_body","Blood urgently needed...");
        startActivity(intent);*/
        Intent i=new Intent(this,MessageActivity.class);
        i.putExtra("contactt",contact);
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
