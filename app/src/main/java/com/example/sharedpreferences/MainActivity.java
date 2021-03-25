package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edN, edP;
    Button  b_r, b_c,b_s;
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Pwd = "pwdKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_c = (Button) findViewById(R.id.buttonClear);
        b_r = (Button) findViewById(R.id.buttonRetrieve);
        b_s = (Button) findViewById(R.id.buttonSave);
        edN = (EditText) findViewById(R.id.edName);
        edP = (EditText) findViewById(R.id.edPwd);
        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        b_c.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                edN.setText("");
                edP.setText("");
            }
        });
        b_s.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String n = edN.getText().toString();
                String p = edP.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Name, n);
                editor.putString(Pwd, p);
                editor.commit();
            }
        });
        b_r.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (sharedpreferences.contains(Name)) {
                edN.setText(sharedpreferences.getString(Name, ""));}
                if (sharedpreferences.contains(Pwd)) {
                    edP.setText(sharedpreferences.getString(Pwd, ""));
                }}
        });
    }
}