package com.example.baitapthtuan3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.content.Intent;
public class MainProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);
        ImageView imageView,imageViewSetting;
        imageView= (ImageView) findViewById(R.id.imageBack);
        imageViewSetting=(ImageView) findViewById(R.id.imgSetting);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainProfile.this,MainActivity.class);
                startActivity(intent);
            }
        });
        imageViewSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainProfile.this,DanhSachTaiKhoan.class);
                startActivity(intent);
            }
        });
    }
}