package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    Button buttonListUser;
    Button buttonSubmit;

    EditText usernameinput, passwordinput;
    DataModel usermodel;
    DBHandler mydb;

    private View.OnClickListener myClicklistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button2:
                    goToActivityListUser();
                    break;
                case R.id.button3:
                    funcAddUser();
                    break;
            }
        }
    };

    private void funcAddUser() {
        String getNama = usernameinput.getText().toString();
        String getPass = passwordinput.getText().toString();
        usermodel = new DataModel(1, getNama, getPass);
        mydb.insertUser(usermodel);
    }


    private void goToActivityListUser() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mydb = new DBHandler(this);

        buttonListUser = findViewById(R.id.button2);
        buttonListUser.setOnClickListener(myClicklistener);

        usernameinput = findViewById(R.id.user);
        passwordinput = findViewById(R.id.pass);

        buttonSubmit = findViewById(R.id.button3);
        buttonSubmit.setOnClickListener(myClicklistener);
    }
}