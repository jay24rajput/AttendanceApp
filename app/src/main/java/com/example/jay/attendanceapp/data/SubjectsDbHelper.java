package com.example.jay.attendanceapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SubjectsDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="attendace_subjects.db";
    private static final int DATABASE_VERSION=1;

    public SubjectsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_SUBJECTS_TABLE="CREATE TABLE "+ SubjectsContract.SubjectsEntry.SUBJECTS_TABLE_NAME+" ( "
                + SubjectsContract.SubjectsEntry.SUBJECTS_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + SubjectsContract.SubjectsEntry.COLUMN_SUBJECT_NAME+" TEXT NOT NULL, "
                + SubjectsContract.SubjectsEntry.COLUMN_SUBJECT_ATTENDANCE+" INTEGER NOT NULL DEFAULT 0, "
                + SubjectsContract.SubjectsEntry.COLUMN_SUBJECT_TOTAL+" INTEGER NOT NULL DEFAULT 0);";

        sqLiteDatabase.execSQL(SQL_CREATE_SUBJECTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
