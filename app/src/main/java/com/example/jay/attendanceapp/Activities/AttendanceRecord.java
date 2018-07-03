package com.example.jay.attendanceapp.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jay.attendanceapp.Adapters.AttendanceInfoAdapter;
import com.example.jay.attendanceapp.R;

public class AttendanceRecord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_record);


        ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager);
        AttendanceInfoAdapter adapter=new AttendanceInfoAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
