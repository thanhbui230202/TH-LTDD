package caidat.dmt.list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView lv_douong;
ArrayList<DoUong> arrayDoUong;
DoUong_Adapter doUong_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        doUong_adapter= new DoUong_Adapter(this,R.layout.layout_iteam,arrayDoUong);
        lv_douong.setAdapter(doUong_adapter);


        lv_douong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,Sub_Activity.class);
                intent.putExtra("name",arrayDoUong.get(i)+"");
                startActivity(intent);
            }
        });
    }
    private void Anhxa(){
        lv_douong = (ListView) findViewById(R.id.list_view_douong);
        arrayDoUong = new ArrayList<>();
        arrayDoUong.add(new DoUong("Campuchino","Campuchino nóng",R.drawable.campuchino));
        arrayDoUong.add(new DoUong("Nước chanh","Nước chanh đá",R.drawable.nuoc_chanh));
        arrayDoUong.add(new DoUong("Nước trái cây","Nước trái cây thập cẩm",R.drawable.nuoc_traicay));
    }
}