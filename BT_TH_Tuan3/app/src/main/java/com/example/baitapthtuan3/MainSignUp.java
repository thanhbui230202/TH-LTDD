package com.example.baitapthtuan3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainSignUp extends AppCompatActivity {
    private EditText edtUserName,edtEmail,edtPassWord,edtConfirmPassword;
    private Button btnSignIn,btnSignUp;
    private ImageButton imageButtonMatPassword,imageButtonNhamMatPassword;
    private ImageButton imageButtonMatConfirmPassword,imageButtonNhamMatConfirmPassword;
    DatabaseHelper helper =new DatabaseHelper(this);
    boolean status=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sign_up);
        edtUserName= (EditText) findViewById(R.id.edtUserName);
        edtEmail= (EditText) findViewById(R.id.edtEmail);
        edtPassWord= (EditText) findViewById(R.id.edtPassword);
        edtConfirmPassword= (EditText) findViewById(R.id.edtConfirmPassword);
        btnSignIn=(Button) findViewById(R.id.btnSignIn);
        btnSignUp=(Button) findViewById(R.id.btnSignUp);
        imageButtonMatPassword=(ImageButton) findViewById(R.id.imgMatPassword);
        imageButtonNhamMatPassword=(ImageButton) findViewById(R.id.imgNhamMatPassword);
        imageButtonMatConfirmPassword=(ImageButton) findViewById(R.id.imgMatConfirmPassword);
        imageButtonNhamMatConfirmPassword=(ImageButton) findViewById(R.id.imgNhamMatConfirmPassword);
        imageButtonNhamMatPassword.setVisibility(View.INVISIBLE);
        imageButtonNhamMatConfirmPassword.setVisibility(View.INVISIBLE);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                status=false;
                if(edtUserName.getText().length()!=0&& edtEmail.getText().length()!=0
                        && edtPassWord.getText().length()!=0&&edtConfirmPassword.getText().length()!=0){
                    if(edtPassWord.getText().toString().equals(edtConfirmPassword.getText().toString())){
                        Cursor dataAccount = MainActivity.database.GetData("SELECT * FROM DuLieuTaiKhoan");
                        while (dataAccount.moveToNext()){
                            String userName =dataAccount.getString(0);
                            String password =dataAccount.getString(1);
                            if(userName.equals(edtUserName.getText().toString())){
                                Toast.makeText(MainSignUp.this, "Ten tai khoan da co nguoi su dung", Toast.LENGTH_SHORT).show();
                                status=true;
                            }
                        }
                        if(!dataAccount.moveToNext() && !status ){
                            TaiKhoan tk = new TaiKhoan();
                            tk.setUserName(edtUserName.getText().toString());
                            tk.setPassword(edtPassWord.getText().toString());
                            helper.insertTaiKhoan(tk);
                            Toast.makeText(MainSignUp.this, "Dang ki thanh cong tro ve man hinh chinh de dang nhap", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(MainSignUp.this, "Mat Khau Khong Khop", Toast.LENGTH_SHORT).show();
                    }
                }else
                    Toast.makeText(MainSignUp.this, "Ban can nhap day du thong tin!!", Toast.LENGTH_SHORT).show();
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainSignUp.this, MainActivity.class);
                startActivity(intent);
            }
        });
        imageButtonMatPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtPassWord.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                imageButtonMatPassword.setVisibility(View.INVISIBLE);
                imageButtonNhamMatPassword.setVisibility(View.VISIBLE);
            }
        });
        imageButtonNhamMatPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtPassWord.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                imageButtonMatPassword.setVisibility(View.VISIBLE);
                imageButtonNhamMatPassword.setVisibility(View.INVISIBLE);
            }
        });
        imageButtonMatConfirmPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtConfirmPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                imageButtonMatConfirmPassword.setVisibility(View.INVISIBLE);
                imageButtonNhamMatConfirmPassword.setVisibility(View.VISIBLE);
            }
        });
        imageButtonNhamMatConfirmPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtConfirmPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                imageButtonMatConfirmPassword.setVisibility(View.VISIBLE);
                imageButtonNhamMatConfirmPassword.setVisibility(View.INVISIBLE);


            }
        });

    }
}