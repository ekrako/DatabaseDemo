package com.example.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);

        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");
        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (name VARCHAR, year INT(4))");

//        myDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Nick',28)");
//        myDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Eran',42)");

        Cursor c= myDatabase.rawQuery("SELECT * FROM users",null);

        int nameIndex =c.getColumnIndex("name");
        int ageIndex =c.getColumnIndex("age");

        c.moveToFirst();

        while (c != null&&!c.isAfterLast()){
            Log.i("name",c.getString(nameIndex));
            Log.i("age",String.valueOf(c.getInt(ageIndex)));
            c.moveToNext();
        }



    }
}
