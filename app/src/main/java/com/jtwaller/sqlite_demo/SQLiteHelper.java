package com.jtwaller.sqlite_demo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.jtwaller.sqlite_demo.SQLContract.SQLEntry;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String TAG = "SQLiteHelper";

    private static final String DATABASE_NAME = "demo.db";

    // Why do some examples start at 2?
    private static final int DATABASE_VERSION = 1;
    private static final String COMMA_SEP = ",";
    private static final String TEXT_TYPE = " TEXT";
    private static final String BIGINT_TYPE = " BIGINT";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + SQLEntry.TABLE_NAME + " (" +
                    SQLEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    SQLEntry.COLUMN_NAME_DATE_CREATED + BIGINT_TYPE + COMMA_SEP +
//                    SQLEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    SQLEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    SQLEntry.COLUMN_NAME_ENTRY_TEXT + TEXT_TYPE + ");";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + SQLEntry.TABLE_NAME;

    SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS notes");
        onCreate(db);
    }

}