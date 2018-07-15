package com.example.jay.attendanceapp.Activities;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.jay.attendanceapp.Activities.AttendanceRecord;
import com.example.jay.attendanceapp.R;
import com.example.jay.attendanceapp.data.LabsContract;
import com.example.jay.attendanceapp.data.LabsDbHelper;
import com.example.jay.attendanceapp.data.SubjectsContract;
import com.example.jay.attendanceapp.data.SubjectsDbHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout subjectsLinearLayout;
    private LinearLayout labsLinearLayout;
    int totalSubjects=0;
    int totalLabs=0;
    int tag=0;
    List<EditText> allSubjectsEditTextViews=new ArrayList<EditText>();
    List<EditText> allLabsEditTextViews=new ArrayList<EditText>();
    private SubjectsDbHelper mSubjectsDbHelper;
    private LabsDbHelper mLabsDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subjectsLinearLayout=(LinearLayout)findViewById(R.id.subjects_linear_layout);
        labsLinearLayout=(LinearLayout)findViewById(R.id.labs_linear_layout);
        EditText initialSubject=(EditText)findViewById(R.id.subjects_edit_text_view);
        EditText initialLab=(EditText)findViewById(R.id.labs_edit_text_view);
        initialSubject.setTag(tag);
        allSubjectsEditTextViews.add(initialSubject);
        allLabsEditTextViews.add(initialLab);
        totalSubjects++;
        totalLabs++;

        mSubjectsDbHelper=new SubjectsDbHelper(this);
        mLabsDbHelper=new LabsDbHelper(this);

    }
    public void addSubjectsView(View view)
    {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView =  inflater.inflate(R.layout.subjects_list_items, null);
        // Add the new row before the add field button.
        subjectsLinearLayout.addView(rowView, subjectsLinearLayout.getChildCount()-1);
        EditText subjectsEditText=rowView.findViewById(R.id.subjects_edit_text_view);
        allSubjectsEditTextViews.add(subjectsEditText);
        totalSubjects++;

    }

    public void removeSubjectsView(View view)
    {
        View subjectToRemove= (View) view.getParent();
        allSubjectsEditTextViews.remove(subjectToRemove.findViewById(R.id.subjects_edit_text_view));
        subjectsLinearLayout.removeView((View) view.getParent());
        totalSubjects--;
    }



    public void addLabsView(View view)
    {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.labs_list_items, null);
        // Add the new row before the add field button.
        labsLinearLayout.addView(rowView, labsLinearLayout.getChildCount()-1);
        EditText labsEditTextView=rowView.findViewById(R.id.labs_edit_text_view);
        allLabsEditTextViews.add(labsEditTextView);
        totalLabs++;
    }

    public void removeLabsView(View view)
    {
        View labToRemove= (View) view.getParent();
        allLabsEditTextViews.remove(labToRemove.findViewById(R.id.labs_edit_text_view));
        labsLinearLayout.removeView((View) view.getParent());
        totalLabs--;
    }

    public void enterNamesToDatabase()
    {
        //String[] subjectNames=new String[totalSubjects];
        //String[] labNames=new String[totalLabs];
        SQLiteDatabase subjects_db=mSubjectsDbHelper.getWritableDatabase();
        SQLiteDatabase labs_db=mLabsDbHelper.getWritableDatabase();



        for(int i=0;i<totalSubjects;i++)
        {
            ContentValues values=new ContentValues();

            EditText subject= (EditText) allSubjectsEditTextViews.get(i);
            String subjectString=subject.getText().toString().trim();
            values.put(SubjectsContract.SubjectsEntry.COLUMN_SUBJECT_NAME,subjectString);

            long newRowId=subjects_db.insert(SubjectsContract.SubjectsEntry.SUBJECTS_TABLE_NAME,null,values);
        }

        for(int j=0;j<totalLabs;j++)
        {
            ContentValues values=new ContentValues();

            EditText lab=(EditText)allLabsEditTextViews.get(j);
            String labsString=lab.getText().toString().trim();
            values.put(LabsContract.LabsEntry.COLUMN_LAB_NAME,labsString);

            long newRowId=labs_db.insert(LabsContract.LabsEntry.LABS_TABLE_NAME,null,values);
        }

        startFragmentsActivity();

    }

    private void startFragmentsActivity()
    {
        Intent fragmentActivity=new Intent(this,AttendanceRecord.class);
        startActivity(fragmentActivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                enterNamesToDatabase();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

