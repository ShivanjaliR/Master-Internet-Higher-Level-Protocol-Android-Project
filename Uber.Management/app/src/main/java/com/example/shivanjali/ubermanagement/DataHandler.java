package com.example.shivanjali.ubermanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Shivanjali on 11/13/2015.
 */

public class DataHandler extends SQLiteOpenHelper{
    public static final String DATABASE_NAME ="UberService.db";
    public static final String TABLE_NAME ="Customer";
    public static final String Col_1 ="ID";
    public static final String Col_2 ="Name";
    public static final String Col_3 ="PhoneNo";
    public static final String Col_4 ="EmailId";

    public DataHandler(Context context) {
        super(context,DATABASE_NAME,null,1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE_NAME + " (" +
                        Col_1 + " INTEGER PRIMARY KEY, " +
                        Col_2 + " TEXT NOT NULL, " +
                        Col_3 + " INTEGER  NOT NULL, " +
                        Col_4 + " TEXT NOT NULL " +
                        ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists"+TABLE_NAME);
        onCreate(db);
    }
}
