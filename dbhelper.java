package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper {
    public static final String dbname="login.db";

    public dbhelper(Context context) {
        super(context, "login.db", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(username TEXT primary key, password TEXT)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists users");
    }
    public Boolean insertData(String username, String password) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result=db.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
    public Boolean checkusername(String username) {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery("Select * from users where username=?", new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkusernamepassword(String username, String password) {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery("Select * from users where username=? and password=?", new String[] {username, password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
