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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtPassWord,edtUseName;
    private TextView editTextForgotPassword;
    private Button btnSignIn, btnSignIn_SignUp;
    private ImageView imageViewFbLogin,imageViewEmailLogin;
    private ImageButton imageButtonMat,imageButtonNhamMat;
    public static DatabaseHelper database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create db
        database= new DatabaseHelper(this);
        anhxa();
        imageButtonNhamMat.setVisibility(View.INVISIBLE);
        controlButton();
    }
    boolean status=false;
    private void  controlButton() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtUseName.getText().length() != 0 && edtPassWord.getText().length() != 0) {
                    Cursor dataAccount = database.GetData("SELECT * FROM DuLieuTaiKhoan");
                    while (dataAccount.moveToNext()){
                        String userName =dataAccount.getString(0);
                        String password =dataAccount.getString(1);
                        if (edtUseName.getText().toString().equals(userName) && edtPassWord.getText().toString().equals(password)) {
                            Toast.makeText(MainActivity.this, "Ban da dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, MainProfile.class);
                            startActivity(intent);
                            status=true;
                            break;
                        }
                    }
                    if(!dataAccount.moveToNext()&&!status)  {
                        Toast.makeText(MainActivity.this, "Sai thong tin tai khoan hoac mat khau", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Moi ban nhap du thong tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSignIn_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainSignUp.class);
                startActivity(intent);
            }
        });
        imageButtonMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtPassWord.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                imageButtonNhamMat.setVisibility(View.VISIBLE);
                imageButtonMat.setVisibility(View.INVISIBLE);
            }
        });
        imageButtonNhamMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtPassWord.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                imageButtonNhamMat.setVisibility(View.INVISIBLE);
                imageButtonMat.setVisibility(View.VISIBLE);
            }
        });
        editTextForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ForgotPassword.class);
                startActivity(intent);
            }
        });
    }
    private void anhxa() {
        edtUseName= (EditText) findViewById(R.id.edtUserName);
        edtPassWord= (EditText) findViewById(R.id.edtPassword);
        btnSignIn= (Button) findViewById(R.id.btnSignIn);
        btnSignIn_SignUp =(Button) findViewById(R.id.btnSignIn_SignUp);
        imageViewFbLogin=(ImageView) findViewById(R.id.imgfblogin);
        imageViewEmailLogin=(ImageView) findViewById(R.id.imggmaillogin);
        imageButtonMat=(ImageButton) findViewById(R.id.imgMat);
        imageButtonNhamMat=(ImageButton) findViewById(R.id.imgNhamMat);
        editTextForgotPassword=(TextView) findViewById(R.id.forgotPassword);
    }
}