package com.example.jay.attendanceapp.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.jay.attendanceapp.fragments.AttendanceInfo;
import com.example.jay.attendanceapp.fragments.WeeklyTable;

public class AttendanceInfoAdapter extends FragmentPagerAdapter {

    public AttendanceInfoAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0)
            return new WeeklyTable();

        if(position==1)
            return new AttendanceInfo();
        return null;
    }



    @Override
    public int getCount() {
        return 2;

    }

    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);
        if(position==0){
            return "Weekly Table";
        }
        if(position==1){
            return "Attendance Info";
        }

        return "";
    }
}

