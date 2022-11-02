package com.example.shaadi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {

    private static final String dbname = "register";




    public database(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String q = "create table users (id integer primary key autoincrement , fname text , lname text , password text , email text, bdate NUMERIC , mobno NUMERIC, religion text, language text)";
        sqLiteDatabase.execSQL(q);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("drop table if exists users");
            onCreate(sqLiteDatabase);
    }

    public boolean insert_data(String first , String last , String password , String email , String bdate , String mobno ,String religion ,String language )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("fname" , first);
        c.put("lname",last);
        c.put("password",password);
        c.put("email",email);
        c.put("bdate",bdate);
        c.put("mobno",mobno);
        c.put("religion",language);
        c.put("language",religion);

        long r = db.insert("users", null , c);
        if(r==-1) return false;
        else
            return true ;


    }
    public Boolean checkemail(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from users where email = ?", new String[]{email});
        if (c.getCount()>0)
            return true;
        else
            return false;


    }

    public Boolean checklogin(String email , String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from users where email = ? and password = ?", new String[]{email , password});
        if (c.getCount()>0)
            return true;
        else
            return false;


    }


}
