package caidat.dmt.kt_pheptinh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Nhan extends AppCompatActivity {
    EditText edtA, edtB, edtkq;
    Button btnNhan;
    int a,b,kq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan2);


        edtA = (EditText) findViewById(R.id.soA);
        edtB = (EditText) findViewById(R.id.soB);
        edtkq = (EditText) findViewById(R.id.ketqua);
        btnNhan = (Button) findViewById(R.id.btn_nhan);


        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Integer.parseInt(edtA.getText().toString());
                b = Integer.parseInt(edtB.getText().toString());
                kq = a * b;
                edtkq.setText(String.valueOf(kq));
            }
        });
    }
}