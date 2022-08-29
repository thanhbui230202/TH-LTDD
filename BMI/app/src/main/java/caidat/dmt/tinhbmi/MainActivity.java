package caidat.dmt.tinhbmi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtWeight,edtHeight;
    Button btnCalculator;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        getEvent();
    }

    public void anhxa(){
        edtWeight= (EditText) findViewById(R.id.editTextWeight);
        edtHeight= (EditText) findViewById(R.id.editTextHeight);
        btnCalculator=(Button) findViewById(R.id.buttoncalculator);
        txtKetQua= (TextView) findViewById(R.id.textViewKetQua);
    }

    public void getEvent(){
        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtWeight.getText().length()!=0 && edtHeight.getText().length()!=0){
                    float BMI;
                    float weight=Float.parseFloat(String.valueOf(edtWeight.getText()));
                    float height=Float.parseFloat(String.valueOf(edtHeight.getText()))/100;
                    BMI=weight/(height*height);
                    if(BMI<18){
                        txtKetQua.setText(BMI+"\nNguoi gay");
                    }else if(BMI<24.9){
                        txtKetQua.setText(BMI+"\nNguoi binh thuong");
                    }else if(BMI<29.9){
                        txtKetQua.setText(BMI+"\nNguoi beo phi do I");
                    }else if(BMI<34.9){
                        txtKetQua.setText(BMI+"\nNguoi beo phi do II");
                    }else{
                        txtKetQua.setText(BMI+"\nNguoi beo phi do III");
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Nhap day du thong tin", Toast.LENGTH_SHORT).show();
                    txtKetQua.setText("");
                }
            }
        });
    }
}