package com.example.bbbproject;

import android.provider.BaseColumns;

public class DatabaseContract{
        public DatabaseContract() {}


    /* Inner class that defines the table contents */
    public static abstract class User implements BaseColumns {
        public static final String TABLE_NAME = "DONORTABLEEE";
        public static final String COL_Name = "Name";
        public static final String COL_City = "City";
        public static final String COL_Mobile = "Mobile";
        public static final String COL_password = "password";
        public static final String COL_Blood = "BloodGroup";

    }
    /*
    public static abstract class Users implements BaseColumns {
        public static final String TABLE_NAME = "LOGINTABLE";
        public static final String COL_username = "UserName";
        public static final String COL_pass= "PASSWORD";

    }*/
    public static abstract class Userss implements BaseColumns {
        public static final String TABLE_NAME = "REGISTRATIONTABLEEE";
        public static final String COL_Uname = "username";
        public static final String COL_nam = "name";
        public static final String COL_city= "CITY";
        public static final String COL_mob= "MOBILE";
        public static final String COL_passw= "PASWORD";
        public static final String COL_REpassw= "RETYPEPASWORD";
        public static final String COL_bloodg= "BLOODGROUPP";
        public static final String COL_email= "EMAIL";



    }

}
