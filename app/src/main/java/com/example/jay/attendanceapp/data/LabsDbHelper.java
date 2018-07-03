package com.example.jay.attendanceapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LabsDbHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME="attendace_labs.db";
    private static final int DATABASE_VERSION=1;

    public LabsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_LABS_TABLE="CREATE TABLE "+ LabsContract.LabsEntry.LABS_TABLE_NAME+" ( "
                + LabsContract.LabsEntry.LABS_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + LabsContract.LabsEntry.COLUMN_LAB_NAME+" TEXT NOT NULL, "
                + LabsContract.LabsEntry.COLUMN_LAB_ATTENDANCE+" INTEGER NOT NULL DEFAULT 0, "
                + LabsContract.LabsEntry.COLUMN_LAB_TOTAL+" INTEGER NOT NULL DEFAULT 0);";

        sqLiteDatabase.execSQL(SQL_CREATE_LABS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
