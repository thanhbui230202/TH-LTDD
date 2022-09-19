package com.example.baitapthtuan3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {
    EditText edtForgotUserName,edtNhapMa;
    Button btnForgotXacNhan,btnBack;
    TextView txtPassword,txtRanDomMa;
    ImageView imgRefresh;
    RandomStringExmple rd = new RandomStringExmple();
    boolean status=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        btnBack= (Button) findViewById(R.id.btnBack);
        edtForgotUserName =(EditText) findViewById(R.id.edtFogottaiKhoan);
        btnForgotXacNhan=(Button) findViewById(R.id.btnXacNhanFogot);
        txtPassword=(TextView)findViewById(R.id.txtMatKhauDaLay);
        txtRanDomMa=(TextView) findViewById(R.id.txtRanDomMa) ;
        imgRefresh =(ImageView) findViewById(R.id.imgRefresh);
        edtNhapMa=(EditText) findViewById(R.id.edtNhapMa);
        txtRanDomMa.setText(rd.RanDomString());
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgotPassword.this,MainActivity.class);
                startActivity(intent);
            }
        });
        imgRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtRanDomMa.setText(rd.RanDomString());
            }
        });
        btnForgotXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                status=false;
                if (edtForgotUserName.getText().length() != 0  && edtNhapMa.getText().length() !=0 ) {
                    Cursor dataAccount = MainActivity.database.GetData("SELECT * FROM DuLieuTaiKhoan");
                    while (dataAccount.moveToNext()){
                        String userName =dataAccount.getString(0);
                        String password =dataAccount.getString(1);
                        if (edtForgotUserName.getText().toString().equals(userName)) {
                            status=true;
                            if(edtNhapMa.getText().toString().equals(txtRanDomMa.getText().toString())){
                                txtPassword.setText("Mat khau: "+password);
                                break;
                            }else{
                                Toast.makeText(ForgotPassword.this, "Ma xac nhan khong dung", Toast.LENGTH_SHORT).show();
                                txtRanDomMa.setText(rd.RanDomString());
                            }break;
                        }
                    }
                    if(!dataAccount.moveToNext() && !status ){
                        Toast.makeText(ForgotPassword.this, "Thong tin tai khoan khong chinh xac", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ForgotPassword.this, "Moi ban nhap du thong tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}