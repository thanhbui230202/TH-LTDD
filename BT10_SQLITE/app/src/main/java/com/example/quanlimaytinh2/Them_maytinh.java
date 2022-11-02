package com.example.quanlimaytinh2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Them_maytinh extends AppCompatActivity {

    Button btthemt,bthuyt;
    EditText edtthemtent,edtthemloait;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_maytinh);

        // anh xa
        edtthemloait = (EditText)findViewById(R.id.edtloait);
        edtthemtent = (EditText)findViewById(R.id.edtnhaptent);
        btthemt = (Button) findViewById(R.id.btthemt);
        bthuyt = (Button) findViewById(R.id.bthuyt);

        //click button huy
        bthuyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Them_maytinh.this,MainActivity.class);
                startActivity(i);
            }
        });

        //click them
        btthemt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tent= edtthemtent.getText().toString();
                String loait = edtthemloait.getText().toString();
                if(tent.equals("") || loait.equals("")){
                    Toast.makeText(Them_maytinh.this, "Điền đầy đủ thông tin trước khi thêm", Toast.LENGTH_SHORT).show();
                }
                else {
                    database = new Database(Them_maytinh.this,"quanLiMayTinh.sqlite",null,1);
                    database.QueryData("insert into computer values(null,'"+tent+"','"+ loait +"')");
                    Toast.makeText(Them_maytinh.this, "Thêm thành công công!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}