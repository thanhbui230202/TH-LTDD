package caidat.dmt.kt_pheptinh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
private Button btnCong,btnTru,btnNhan,btnChia,btnLOG,btnChialaydu,btnSS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCong =  findViewById(R.id.btn_Cong);
        btnTru =  findViewById(R.id.btn_Tru);
        btnNhan =  findViewById(R.id.btn_Nhan);
        btnChia =  findViewById(R.id.btn_Chia);
        btnLOG =  findViewById(R.id.btn_LOG);
        btnChialaydu =  findViewById(R.id.btn_Chialaydu);
        btnSS =  findViewById(R.id.btn_SS);


        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Cong.class);
                startActivity(intent);
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Tru.class);
                startActivity(intent);
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Nhan.class);
                startActivity(intent);
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Chia.class);
                startActivity(intent);
            }
        });
        btnLOG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LOG.class);
                startActivity(intent);
            }
        });
        btnSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SoSanh.class);
                startActivity(intent);
            }
        });
        btnChialaydu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Chialaydu.class);
                startActivity(intent);
            }
        });
    }
}