package com.example.jay.attendanceapp.data;

import android.provider.BaseColumns;

public class LabsContract {

    private LabsContract(){};

    public static final class LabsEntry implements BaseColumns
    {
        public static final String LABS_TABLE_NAME="labs";
        public static final String LABS_ID=BaseColumns._ID;
        public static final String COLUMN_LAB_NAME="name";
        public static final String COLUMN_LAB_TOTAL="total_attendance";
        public static final String COLUMN_LAB_ATTENDANCE="labs_attended";
    }
}
