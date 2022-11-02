package com.example.quanlimaytinh2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Dong_activity extends AppCompatActivity {

    ImageView imgsua,imgxoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dong);

        //anh xa
        imgsua= (ImageView) findViewById(R.id.suacp);
        imgxoa= (ImageView) findViewById(R.id.xoacp);

        //
        imgsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dong_activity.this,SuaActivity.class);
                startActivity(i);
            }
        });
    }
}