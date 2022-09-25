package caidat.dmt.list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Sub_Activity extends AppCompatActivity {
TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        txtView =findViewById(R.id.textView_1);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
    }
}