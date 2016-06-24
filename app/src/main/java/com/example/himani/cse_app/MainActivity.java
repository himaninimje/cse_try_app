package com.example.himani.cse_app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button s_signup,t_signup;
    EditText pass;
    EditText cpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost tabhost= (TabHost) findViewById(R.id.tabhost);
        tabhost.setup();
        TabHost.TabSpec teacher=tabhost.newTabSpec("teacher");
        TabHost.TabSpec student = tabhost.newTabSpec("student");

        teacher.setIndicator("teacher");
        student.setIndicator("student");
        teacher.setContent(R.id.TEACHER);
        student.setContent(R.id.STUDENT);

        tabhost.addTab(teacher);
        tabhost.addTab(student);
        s_signup= (Button)findViewById(R.id.s_signup);
        s_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass = (EditText) findViewById(R.id.s_pass);
                cpass = (EditText) findViewById(R.id.s_cpass);
                EditText name = (EditText) findViewById(R.id.s_name);
                EditText email = (EditText) findViewById(R.id.s_email);
                EditText year = (EditText) findViewById(R.id.s_year);
                String message = "";
                int flag = 0;
                if (name.getText().toString().isEmpty() || email.getText().toString().isEmpty() ||year.getText().toString().isEmpty()||
                        pass.getText().toString().isEmpty()||cpass.getText().toString().isEmpty()) {
                    message+="All fields are compulsory";
                    flag=1;
                }
                else{
                    if (!(pass.getText().toString().equals(cpass.getText().toString()))) {
                        message += "\nPassword Doesnt Match";
                        flag = 1;
                    }
                    if (!((email.getText().toString().contains("@"))&&(email.getText().toString().contains(".")))){
                        message+="\nInvalid Email-id";
                        flag=1;
                    }
                    if (year.getText().toString().equals("") || Integer.parseInt(year.getText().toString()) > 5 || Integer.parseInt(year.getText().toString()) < 1) {
                        message += "\nIncorrect year";
                        flag = 1;
                    }
                }
                if(flag==1) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setCancelable(true);
                    dialog.setMessage(message);
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface disg, int id) {
                            pass.setText("");
                            cpass.setText("");
                        }

                    });
                    dialog.create().show();
                }
                else {
                    Intent nextactivity= new Intent(MainActivity.this, StudentList.class);
                    startActivity(nextactivity);

                }
            }
        });


        t_signup=(Button) findViewById(R.id.t_signup);
        t_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pass=(EditText) findViewById(R.id.t_pass);
                cpass=(EditText) findViewById(R.id.t_cpass);
                EditText name=(EditText) findViewById(R.id.t_name);
                EditText email=(EditText) findViewById(R.id.t_email);
                EditText dept=(EditText) findViewById(R.id.t_dept);
                String message="";
                int flag=0;
                if (name.getText().toString().isEmpty() || email.getText().toString().isEmpty() ||dept.getText().toString().isEmpty()||
                        pass.getText().toString().isEmpty()||cpass.getText().toString().isEmpty()) {
                    message+="All fields are compulsory";
                    flag=1;
                }
                else{
                    if (!(pass.getText().toString().equals(cpass.getText().toString()))) {
                        message += "\nPassword Doesnt Match";
                        flag = 1;
                    }
                    if (!((email.getText().toString().contains("@"))&&(email.getText().toString().contains(".")))){
                        message+="\nInvalid Email-id";
                        flag=1;
                    }
                }
                if(flag==1) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setCancelable(true);
                    dialog.setMessage(message);
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface disg, int id) {
                            pass.setText("");
                            cpass.setText("");
                        }

                    });
                    dialog.create().show();
                }
            }
        });
    }


}
