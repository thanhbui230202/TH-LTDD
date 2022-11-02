package com.example.quanlimaytinh2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SuaActivity extends AppCompatActivity {

    Button btsuas;
    EditText edtTens,edtloais;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sua);

        //anh xa
        btsuas = (Button) findViewById(R.id.btsuas);
        edtTens = (EditText) findViewById(R.id.edtnhaptens);
        edtloais = (EditText) findViewById(R.id.edtloais);

        //su kien sua
        btsuas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tent= edtTens.getText().toString();
                String loait = edtloais.getText().toString();
                if(tent.equals("") || loait.equals("")){
                    Toast.makeText(SuaActivity.this, "Điền đầy đủ thông tin trước khi sua", Toast.LENGTH_SHORT).show();
                }
                else {
                    database = new Database(SuaActivity.this,"quanLiMayTinh.sqlite",null,1);
                    database.QueryData("update  computer set tenmay = '"+tent+"',loai = '"+ loait +"' where id = 1 ");
                    Toast.makeText(SuaActivity.this, "Sửa số 1 thành công công!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}