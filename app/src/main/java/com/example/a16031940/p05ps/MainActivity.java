package com.example.a16031940.p05ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTitle , etSinger , etYear;
    RadioGroup rg;
    Button btnInsert , btnShow;
    ArrayList<String>al;
    String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.Title);
        etSinger = findViewById(R.id.singers);
        etYear = findViewById(R.id.Year);
        rg = findViewById(R.id.rg);
        btnInsert = findViewById(R.id.insert);
        btnShow = findViewById(R.id.show);


        al = new ArrayList<String>();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selecteID = rg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selecteID);
                String title = etTitle.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                String singer = etSinger.getText().toString();
                int star = Integer.parseInt(rb.getText().toString());

                DBHelper dbh = new DBHelper(MainActivity.this);
                long row_affected = dbh.insertSong(title,singer,year,star);
                dbh.close();

                if(row_affected != -1){
                    Toast.makeText(MainActivity.this,"Inserted successfully!",Toast.LENGTH_SHORT).show();
                }




            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = findViewById(R.id.testung);

                DBHelper dbh = new DBHelper(MainActivity.this);
                al.clear();
                al.addAll(dbh.getAllSongs());
                dbh.close();
                String txt = "";
               for(int i = 0;i<al.size();i++){
                    String tmp = al.get(i);
                    txt += tmp + "\n";
              }


                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("data",txt);
                startActivity(i);
            }
        });


    }
}
