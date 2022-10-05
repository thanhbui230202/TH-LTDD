package caidat.dmt.gk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Mota extends AppCompatActivity {
    TextView txtMota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mota);
        txtMota =findViewById(R.id.textmota);
        Intent intent = getIntent();
        txtMota.setText(intent.getStringExtra("key1"));
    }
}