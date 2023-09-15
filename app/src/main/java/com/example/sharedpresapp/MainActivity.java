package com.example.sharedpresapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button saveButton;
    private TextView result;
    private EditText enterMessage;
    private SharedPreferences myPrefs;
    private static final String PREFS_NAME = "myPrefFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterMessage = (EditText) findViewById(R.id.enterMessage);
        result = (TextView) findViewById(R.id.result);
        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPrefs = getSharedPreferences(PREFS_NAME,0);
                SharedPreferences.Editor editor = myPrefs.edit();
                editor.putString("message", enterMessage.getText().toString());
                editor.commit();
            }
        });
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME,0);
        if (prefs.contains("message")) {
         String message = prefs.getString("message", "not found");
         result.setText("message" + message);
        }
    }
}