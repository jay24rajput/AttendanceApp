package com.example.jay.attendanceapp.data;

import android.provider.BaseColumns;

public class SubjectsContract {

    private SubjectsContract(){};

    public static final class SubjectsEntry implements BaseColumns
    {
        public static final String SUBJECTS_TABLE_NAME="subjects";
        public static final String SUBJECTS_ID=BaseColumns._ID;
        public static final String COLUMN_SUBJECT_NAME="name";
        public static final String COLUMN_SUBJECT_TOTAL="total_lectures";
        public static final String COLUMN_SUBJECT_ATTENDANCE="lectures_attended";

    }

}
