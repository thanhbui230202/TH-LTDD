package com.example.quanlimaytinh2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button them;
    Database database;
    ListView lvComputer;
    ArrayList<Computer> arrayComputer;
    ComputerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //anh xa
        lvComputer = (ListView)findViewById(R.id.lvComputer);
        arrayComputer = new ArrayList<>();
        adapter  = new ComputerAdapter(this,R.layout.activity_dong,arrayComputer);
        lvComputer.setAdapter(adapter);
        them = (Button)findViewById(R.id.btthemm);



        //tao database
        database = new Database(this,"quanLiMayTinh.sqlite",null,1);

        //tao bang category
        database.QueryData("create TABLE IF NOT EXISTS category(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "loai varchar(200))");
        //tao bang computer
        database.QueryData("create table if not exists computer (id integer primary key AUTOINCREMENT," +
                "tenmay varchar(200)," +
                "loai varchar(200))");
        //select data
        Cursor dataCP =database.getdata("select * from computer");
        while(dataCP.moveToNext()){
            String tenCp = dataCP.getString(1);
            int id = dataCP.getInt(0);
            arrayComputer.add(new Computer(id,tenCp));
        }
        adapter.notifyDataSetChanged();


        //click button them
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Them_maytinh.class);
                startActivity(i);
            }
        });

    }

}