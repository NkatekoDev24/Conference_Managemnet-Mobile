package com.example.conference_management;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "conference_schedule.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the schedule table
        String createScheduleTable = "CREATE TABLE schedule (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT," +
                "description TEXT," +
                "date TEXT," +
                "time TEXT," +
                "location TEXT)";
        db.execSQL(createScheduleTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database schema upgrades
        // Example: db.execSQL("DROP TABLE IF EXISTS schedule");
        // Then recreate the table
    }
}

