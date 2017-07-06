package com.example.kieranhalliday.practiceapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by kieranhalliday on 2017-07-06.
 */

public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondary_activity);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.email_shown);
        TextView tv1 = (TextView) findViewById(R.id.password_shown);

        Bundle extras = getIntent().getExtras();


        tv.setText(extras.getString("email"));
        tv1.setText(extras.getString("password"));


//        Button next_activity = (Button) findViewById(R.id.Button_2);
//        next_activity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intent);
//
//            }
//        });
    }
}
