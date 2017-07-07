package com.example.kieranhalliday.practiceapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    TextView textView;
    Button button;
    CheckBox c1,c2,c3,c4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);
        c1 = (CheckBox) findViewById(R.id.c1);
        c2 = (CheckBox) findViewById(R.id.c2);
        c3 = (CheckBox) findViewById(R.id.c3);
        c4 = (CheckBox) findViewById(R.id.c4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=0;

                if(c1.isChecked()){
                    textView.setText("Checkbox 1");
                    count++;
                }
                if(c2.isChecked()){
                    if(count==0){
                        textView.setText("Checkbox 2");
                    }else{
                        textView.append(" and Checkbox 2");
                    }
                    count++;
                }
                if(c3.isChecked()){
                    if(count==0){
                        textView.setText("Checkbox 3");
                    }else{
                        textView.append(" and Checkbox 3");
                    }
                    count++;
                }
                if(c4.isChecked()){
                    if(count==0){
                        textView.setText("Checkbox 4");
                    }else{
                        textView.append(" and Checkbox 4");
                    }
                    count++;
                }
                textView.append(" selected");
                for(int i=1;i<count-1;i++) {
                    textView.setText(textView.getText().toString().replaceFirst("and", ","));
                }
            }
        });

    }
}
