package com.example.tugas2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button buttonAddUser;
    DBHandler mydb;
    ListView mylv;

    private View.OnClickListener myClicklistener = new View.OnClickListener() {
        @Override
        public void onClick(@NonNull View view) {
            switch (view.getId()) {
                case R.id.button:
                    goToActivityAddUser();
                    break;
            }
        }
    };

    private void goToActivityAddUser() {
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAddUser = findViewById(R.id.button);
        buttonAddUser.setOnClickListener(myClicklistener);

        mydb = new DBHandler(this);

        List<ArrayList> data = mydb.getAll();
        mylv = (ListView) findViewById(R.id.listView);
        customAdapter cAdapter = new customAdapter(getApplicationContext(), data);
        mylv.setAdapter(cAdapter);
    }
}