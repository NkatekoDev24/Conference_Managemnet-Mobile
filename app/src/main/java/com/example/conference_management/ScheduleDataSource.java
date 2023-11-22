package com.example.conference_management;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ScheduleDataSource {

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_TIME = "time";
    public static final String COLUMN_LOCATION = "location";


    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public ScheduleDataSource(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long addSession(ScheduleSession session) {
        ContentValues values = new ContentValues();
        values.put("title", session.getTitle());
        values.put("description", session.getDescription());
        values.put("date", session.getDate());
        values.put("time", session.getTime());
        values.put("location", session.getLocation());
        return database.insert("schedule", null, values);
    }

    public void updateSession(ScheduleSession session) {
        ContentValues values = new ContentValues();
        values.put("title", session.getTitle());
        values.put("description", session.getDescription());
        values.put("date", session.getDate());
        values.put("time", session.getTime());
        values.put("location", session.getLocation());
        database.update("schedule", values, "id = ?", new String[]{String.valueOf(session.getId())});
    }

    public void deleteSession(int sessionId) {
        database.delete("schedule", "id = ?", new String[]{String.valueOf(sessionId)});
    }

    public List<ScheduleSession> getAllSessions() {
        List<ScheduleSession> sessions = new ArrayList<>();
        Cursor cursor = database.query("schedule", null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ScheduleSession session = cursorToSession(cursor);
            sessions.add(session);
            cursor.moveToNext();
        }
        cursor.close();
        return sessions;
    }

    private ScheduleSession cursorToSession(Cursor cursor) {
        ScheduleSession session = new ScheduleSession();

        int idIndex = cursor.getColumnIndex(ScheduleDataSource.COLUMN_ID);
        int titleIndex = cursor.getColumnIndex(ScheduleDataSource.COLUMN_TITLE);
        int descriptionIndex = cursor.getColumnIndex(ScheduleDataSource.COLUMN_DESCRIPTION);
        int dateIndex = cursor.getColumnIndex(ScheduleDataSource.COLUMN_DATE);
        int timeIndex = cursor.getColumnIndex(ScheduleDataSource.COLUMN_TIME);
        int locationIndex = cursor.getColumnIndex(ScheduleDataSource.COLUMN_LOCATION);

        if (idIndex != -1) {
            session.setId(cursor.getInt(idIndex));
        }

        if (titleIndex != -1) {
            session.setTitle(cursor.getString(titleIndex));
        }

        if (descriptionIndex != -1) {
            session.setDescription(cursor.getString(descriptionIndex));
        }

        if (dateIndex != -1) {
            session.setDate(cursor.getString(dateIndex));
        }

        if (timeIndex != -1) {
            session.setTime(cursor.getString(timeIndex));
        }

        if (locationIndex != -1) {
            session.setLocation(cursor.getString(locationIndex));
        }

        return session;
    }

}

