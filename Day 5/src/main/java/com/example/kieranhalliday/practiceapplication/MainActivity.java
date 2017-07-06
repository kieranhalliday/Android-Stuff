package com.example.kieranhalliday.practiceapplication;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    TextView textView;
    RadioGroup radioGroup;
    RadioButton r1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        r1 = (RadioButton) findViewById(R.id.r1);
        radioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

        int val = Math.abs(r1.getId()-checkedId)+1;
        textView.setText("You have selected the " + val +" Radio Button");
    }
}
