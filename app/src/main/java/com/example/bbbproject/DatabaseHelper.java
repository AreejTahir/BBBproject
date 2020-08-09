package com.example.bbbproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper  extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "BLOODSSINFORMATION.db";
    private static final String CREATE_TBL_USERS = "CREATE TABLE "
            + DatabaseContract.User.TABLE_NAME + " ("
            + DatabaseContract.User._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DatabaseContract.User.COL_Name + " TEXT NOT NULL, "
            + DatabaseContract.User.COL_City + " TEXT NOT NULL,"
            + DatabaseContract.User.COL_Mobile + " INTEGER NOT NULL,"
            + DatabaseContract.User.COL_password + " TEXT NOT NULL,"
            + DatabaseContract.User.COL_Blood + " TEXT NOT NULL)";
    /* private static final String CREATE_TBL_LOGIN = "CREATE TABLE "
             + DatabaseContract.Users.TABLE_NAME + " ("
             + DatabaseContract.Users._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
             + DatabaseContract.Users.COL_username + " TEXT NOT NULL, "
             + DatabaseContract.Users.COL_pass + " TEXT NOT NULL)";*/
    private static final String CREATE_TBL_REG = "CREATE TABLE "
            + DatabaseContract.Userss.TABLE_NAME + " ("
            + DatabaseContract.Userss._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DatabaseContract.Userss.COL_Uname + " TEXT NOT NULL, "
            + DatabaseContract.Userss.COL_nam + " TEXT NOT NULL, "
            + DatabaseContract.Userss.COL_city + " TEXT NOT NULL,"
            + DatabaseContract.Userss.COL_mob + " INTEGER,"
            + DatabaseContract.Userss.COL_passw + " TEXT NOT NULL,"
            + DatabaseContract.Userss.COL_REpassw + " TEXT NOT NULL,"
            + DatabaseContract.Userss.COL_bloodg + " TEXT NOT NULL,"
            + DatabaseContract.Userss.COL_email + " TEXT NOT NULL)";




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TBL_USERS);
        // db.execSQL(CREATE_TBL_LOGIN);
        db.execSQL(CREATE_TBL_REG);

        // TODO Auto-generated method stub
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }
    public boolean UpdateRecord(String idd,String name,String city,String mobile,String pword,String blood)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(DatabaseContract.User.COL_Name,name);
        values.put(DatabaseContract.User.COL_City,city);
        values.put(DatabaseContract.User.COL_Mobile,mobile);
        values.put(DatabaseContract.User.COL_password,pword);
        values.put(DatabaseContract.User.COL_Blood,blood);
        String[] wherearg={idd};
        db.update(DatabaseContract.User.TABLE_NAME,values,DatabaseContract.User._ID + "=?",wherearg);
        return true;

    }
    public boolean checkUsername(String name)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        //  Cursor c=db.rawQuery(" Select * from " + DatabaseContract.Userss.TABLE_NAME + " where " + DatabaseContract.Userss.COL_Uname + " =? " ,
        //        new String[]{name}) ;
        Cursor c=db.rawQuery( " select * from " + DatabaseContract.Userss.TABLE_NAME + " where " + DatabaseContract.Userss.COL_Uname + "=?",  new String[]{name});
        if(c.getCount() >0)
        {
            return true;
        }
        else {
            return false;
        }
    }

}
