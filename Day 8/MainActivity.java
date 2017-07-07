package com.example.kieranhalliday.practiceapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences.Editor editor = getSharedPreferences("Login", MODE_PRIVATE).edit();
        editor.putString("Email","a@hotmail.com");
        editor.putString("Password","test");
        editor.apply();

        final EditText editText = (EditText) findViewById(R.id.email);
        final EditText editText1 = (EditText) findViewById(R.id.password);


        Button next_activity = (Button) findViewById(R.id.Button_1);
        next_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondaryActivity.class);
                String email = String.valueOf(editText.getText());
                String password = String.valueOf(editText1.getText());
                Context context = getApplicationContext();
                String text = "Invalid Credentials";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,text,duration);

                if(!email.contains("@")  || password.equals("Password") || email.length()<=3 || password.length()<1){
                    toast.show();
                    return;
                }else{
                    SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Login",MODE_PRIVATE);
                    if(!sharedPreferences.getString("Email", null).equals(email)){
                        text = "Wrong email";
                        toast = Toast.makeText(context,text,duration);
                        toast.show();
                        return;
                    }
                    if(!sharedPreferences.getString("Password", null).equals(password)){
                        text = "Wrong password";
                        toast = Toast.makeText(context,text,duration);
                        toast.show();
                        return;
                    }
                }

                intent.putExtra("email",email);
                intent.putExtra("password",password);
                startActivity(intent);

            }
        });
    }
}
