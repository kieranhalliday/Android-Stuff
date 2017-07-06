package com.example.kieranhalliday.practiceapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.logging.StreamHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.email);
        final EditText editText1 = (EditText) findViewById(R.id.password);


        Button next_activity = (Button) findViewById(R.id.Button_1);
        next_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondaryActivity.class);
                String email = String.valueOf(editText.getText());
                String password = String.valueOf(editText1.getText());

                if(!email.contains("@")  || password.equals("Password") || email.length()<=3 || password.length()<1){
                    Context context = getApplicationContext();
                    String text = "Invalid Credentials";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context,text,duration);
                    toast.show();
                    return;
                }

                intent.putExtra("email",email);
                intent.putExtra("password",password);
                startActivity(intent);

            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
