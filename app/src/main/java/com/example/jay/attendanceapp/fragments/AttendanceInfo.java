package com.example.jay.attendanceapp.fragments;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jay.attendanceapp.R;
import com.example.jay.attendanceapp.data.LabsContract;
import com.example.jay.attendanceapp.data.LabsDbHelper;
import com.example.jay.attendanceapp.data.SubjectsContract;
import com.example.jay.attendanceapp.data.SubjectsDbHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class AttendanceInfo extends Fragment {


    public AttendanceInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_attendance_info, container, false);

        displayDataBaseInfo(rootView);
        return rootView;

    }

    private void displayDataBaseInfo(View rootView)
    {
        SubjectsDbHelper mSubjectsDbHelper=new SubjectsDbHelper(this.getContext());
        LabsDbHelper mLabsDbHelper=new LabsDbHelper(this.getContext());

        SQLiteDatabase subjects_db=mSubjectsDbHelper.getReadableDatabase();
        SQLiteDatabase labs_db=mLabsDbHelper.getReadableDatabase();

        String subjects_projection[]={
                SubjectsContract.SubjectsEntry.SUBJECTS_ID,
                SubjectsContract.SubjectsEntry.COLUMN_SUBJECT_NAME,
                SubjectsContract.SubjectsEntry.COLUMN_SUBJECT_ATTENDANCE,
                SubjectsContract.SubjectsEntry.COLUMN_SUBJECT_TOTAL
        };

        String labs_projection[]={LabsContract.LabsEntry.LABS_ID,
                LabsContract.LabsEntry.COLUMN_LAB_NAME,
                LabsContract.LabsEntry.COLUMN_LAB_ATTENDANCE,
                LabsContract.LabsEntry.COLUMN_LAB_TOTAL
        };

        Cursor subjects_cursor=subjects_db.query(SubjectsContract.SubjectsEntry.SUBJECTS_TABLE_NAME,subjects_projection,
                null,null,null,null,null);

        Cursor labs_cursor=labs_db.query(LabsContract.LabsEntry.LABS_TABLE_NAME,labs_projection,null,
                null,null,null,null);

        try
        {
            TextView displaySubjectsInfo=(TextView)rootView.findViewById(R.id.display_subjects_info);
            displaySubjectsInfo.setText("No of subjects are "+subjects_cursor.getCount());
            displaySubjectsInfo.append("\n"+ SubjectsContract.SubjectsEntry.SUBJECTS_ID
                    +" - " + SubjectsContract.SubjectsEntry.COLUMN_SUBJECT_NAME
                    +" - "+ SubjectsContract.SubjectsEntry.COLUMN_SUBJECT_ATTENDANCE
                    +" - "+ SubjectsContract.SubjectsEntry.COLUMN_SUBJECT_TOTAL);

            int subjectsIdColumnIndex=subjects_cursor.getColumnIndex(SubjectsContract.SubjectsEntry.SUBJECTS_ID);
            int subjectsNameColumnIndex=subjects_cursor.getColumnIndex(SubjectsContract.SubjectsEntry.COLUMN_SUBJECT_NAME);
            int subjectsAttendanceColumnIndex=subjects_cursor.getColumnIndex(SubjectsContract.SubjectsEntry.COLUMN_SUBJECT_ATTENDANCE);
            int subjectsTotalColumnIndex=subjects_cursor.getColumnIndex(SubjectsContract.SubjectsEntry.COLUMN_SUBJECT_TOTAL);

            while(subjects_cursor.moveToNext())
            {
                int currentSubjectId=subjects_cursor.getInt(subjectsIdColumnIndex);
                String currentSubjectName=subjects_cursor.getString(subjectsNameColumnIndex);
                int currentSubjectAttendance=subjects_cursor.getInt(subjectsAttendanceColumnIndex);
                int currentSubjectTotal=subjects_cursor.getInt(subjectsTotalColumnIndex);

                displaySubjectsInfo.append("\n"+currentSubjectId+" - "
                +currentSubjectName+" - "
                +currentSubjectAttendance+" - "
                +currentSubjectTotal);
            }



            TextView displayLabsInfo=(TextView)rootView.findViewById(R.id.display_labs_info);
            displayLabsInfo.setText("No of labs are "+labs_cursor.getCount());
            displayLabsInfo.append("\n"+ LabsContract.LabsEntry.LABS_ID
                    +" - " + LabsContract.LabsEntry.COLUMN_LAB_NAME
                    +" - "+ LabsContract.LabsEntry.COLUMN_LAB_ATTENDANCE
                    +" - "+ LabsContract.LabsEntry.COLUMN_LAB_TOTAL);

            int labsIdColumnIndex=labs_cursor.getColumnIndex(LabsContract.LabsEntry.LABS_ID);
            int labsNameColumnIndex=labs_cursor.getColumnIndex(LabsContract.LabsEntry.COLUMN_LAB_NAME);
            int labsAttendanceColumnIndex=labs_cursor.getColumnIndex(LabsContract.LabsEntry.COLUMN_LAB_ATTENDANCE);
            int labsTotalColumnIndex=labs_cursor.getColumnIndex(LabsContract.LabsEntry.COLUMN_LAB_TOTAL);

            while(labs_cursor.moveToNext())
            {
                int currentLabId=labs_cursor.getInt(labsIdColumnIndex);
                String currentLabName=labs_cursor.getString(labsNameColumnIndex);
                int currentLabAttendance=labs_cursor.getInt(labsAttendanceColumnIndex);
                int currentLabTotal=labs_cursor.getInt(labsTotalColumnIndex);

                displayLabsInfo.append("\n"+currentLabId+" - "
                        +currentLabName+" - "
                        +currentLabAttendance+" - "
                        +currentLabTotal);
            }


        }

        finally {
            subjects_cursor.close();
            labs_cursor.close();
        }
    }
}
