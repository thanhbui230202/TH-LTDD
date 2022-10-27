package caidat.dmt.contenprovider_listcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private static final int contact=1001;
private static final int sms=1002;
Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvents();
    }
    private void addEvents(){
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyManHinhDanhBa();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyManHinhTinNhan();
            }
        });
    }
    private void xulyManHinhDanhBa(){
        Intent intent = new Intent(MainActivity.this,DanhBa.class);
        intent.setClassName("caidat.dmt.contenprovider_listcontact","caidat.dmt.contenprovider_listcontact.DanhBa");
        startActivity(intent);
    }
    private void xulyManHinhTinNhan(){

    }
    private void addControl(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
    }
}