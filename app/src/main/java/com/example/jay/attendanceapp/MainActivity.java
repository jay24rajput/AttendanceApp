package com.example.jay.attendanceapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LinearLayout subjectsLinearLayout;
    private LinearLayout labsLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        subjectsLinearLayout=(LinearLayout)findViewById(R.id.subjects_linear_layout);
        labsLinearLayout=(LinearLayout)findViewById(R.id.labs_linear_layout);
    }
    public void addSubjectsView(View view)
    {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.subjects_list_items, null);
        // Add the new row before the add field button.
        subjectsLinearLayout.addView(rowView, subjectsLinearLayout.getChildCount()-1);
    }

    public void removeSubjectsView(View view)
    {
        subjectsLinearLayout.removeView((View) view.getParent());
    }



    public void addLabsView(View view)
    {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.labs_list_items, null);
        // Add the new row before the add field button.
        labsLinearLayout.addView(rowView, labsLinearLayout.getChildCount()-1);
    }

    public void removeLabsView(View view)
    {
        labsLinearLayout.removeView((View) view.getParent());
    }

    public void startFragmentActivity(View view)
    {
        Intent fragmentActivity=new Intent(this,AttendanceRecord.class);
        startActivity(fragmentActivity);
    }
}
