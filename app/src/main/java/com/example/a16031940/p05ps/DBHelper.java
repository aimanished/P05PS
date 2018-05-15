package com.example.a16031940.p05ps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "p05ps.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NOTE = "songs_table";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_YEARS = "years";
    private static final String COLUMN_SINGER = "singers";
    private static final String COLUMN_STARS = "stars";
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createNoteTableSql = "CREATE TABLE " + TABLE_NOTE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_SINGER + " TEXT, " + COLUMN_YEARS +" TEXT, " +  COLUMN_TITLE + " TEXT, " + COLUMN_STARS + " TEXT " + ") ";
        db.execSQL(createNoteTableSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
        onCreate(db);
    }

    public long insertSong(String title , String singers , int years , int stars) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_SINGER, singers);
        values.put(COLUMN_YEARS, years);
        values.put(COLUMN_STARS, stars);

        long result = db.insert(TABLE_NOTE, null, values);
        db.close();
        Log.d("SQL Insert ",""+ result); //id returned, shouldn’t be -1
        return result;
    }
    public ArrayList<String> getAllSongs() {
        ArrayList<String> notes = new ArrayList<String>();

        String selectQuery = "SELECT " + COLUMN_ID + ","
                + COLUMN_STARS + "," + COLUMN_TITLE + "," + COLUMN_YEARS + "," + COLUMN_SINGER + " FROM " + TABLE_NOTE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String year = cursor.getString(2);
                String singer = cursor.getString(3);
                String title = cursor.getString(4);
                notes.add(name +","+year+","+singer+","+title);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return notes;
    }

}

