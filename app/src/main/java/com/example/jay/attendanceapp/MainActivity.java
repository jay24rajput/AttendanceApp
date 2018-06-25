package com.example.jay.attendanceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void add_edittext(){
        LayoutParams lparams = new ViewGroup.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        EditText et1=new EditText(this);
        et1.setLayoutParams(lparams);
        et1.setText("test");
        this.layout.addView(et1);

        //layout = findViewById(R.id.linearlayout1);
        //EditText et = new EditText(this);
        //et.setHint("Enter Subject Name");
        //layout.addView(et);
    }
    public void add_button(){

        layout = findViewById(R.id.linearlayout1);
        Button bt = new Button(this);
        bt.setText('+');
        layout.addView(bt);
    }

    public void remove_button(){
        Button bt = findViewById(R.id.subjects_add);
        layout.removeView(bt);
    }
    public void onClick(){
        remove_button();
        //add_edittext();
        //add_button();
    }
    public void timetable(View view){
        
    }


}
