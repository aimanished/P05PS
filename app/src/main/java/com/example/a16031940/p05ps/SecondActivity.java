package com.example.a16031940.p05ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Song>song;
    DBHelper dbh = new DBHelper(SecondActivity.this);
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    lv = findViewById(R.id.lv);
    Intent i = getIntent();
    data = (Song)i.getSerializableExtra("data");

    }
}
