package caidat.dmt.gk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Home extends Fragment {
    ListView listNuocUong;
    ArrayList<NuocUong> nuocUong;
    DoUong_Adapter adapterGame3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home,container,false);
        listNuocUong =(ListView) view.findViewById(R.id.listViewDowLoad);
        nuocUong = new ArrayList<>();
        nuocUong.add(new NuocUong("CocaCola","Coca-Cola",R.drawable.cocacola," Công ty Coca-Cola"));
        nuocUong.add(new NuocUong("Mirinda Cam","Mirinda",R.drawable.mirrinda,"PepѕiCo"));
        nuocUong.add(new NuocUong("Sữa trái cây Nutrifood","Nutrifood",R.drawable.nutriboot,"Công ty CP Thực phẩm Dinh Dưỡng Bình Dương"));
        nuocUong.add(new NuocUong("Pepsi","Pepsi",R.drawable.pepsi,"PepѕiCo"));
        nuocUong.add(new NuocUong("Sprite","Sprite",R.drawable.sprite,"Công ty Coca-Cola"));
        nuocUong.add(new NuocUong("Fanta Cam","Fanta",R.drawable.fanta,"Công ty Coca-Cola"));
        nuocUong.add(new NuocUong("7 Up","7 Up",R.drawable.bayup," Dr Pepper Snapple Group của Mỹ và PepsiCo"));
        nuocUong.add(new NuocUong("Bia Tiger","Tiger",R.drawable.tiger,"Công ty CP Thực phẩm Công Nghệ Sài Gòn (INFOODCO)"));
        nuocUong.add(new NuocUong("Sting Dâu","Sting",R.drawable.sting_lon,"PepѕiCo"));
        nuocUong.add(new NuocUong("Monster","Monster",R.drawable.monster,"Công ty TNHH Monster"));
        nuocUong.add(new NuocUong("Bia 333","333",R.drawable.biababa,"SABECO"));
        nuocUong.add(new NuocUong("Bia Sài Gòn","Sài Gòn",R.drawable.saigon,"SABECO"));
        adapterGame3 = new DoUong_Adapter(getContext(),R.layout.custom_line,nuocUong);
        listNuocUong.setAdapter(adapterGame3);

        listNuocUong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(),Mota.class);
                intent.putExtra("key1",nuocUong.get(i).getMoTa());
                startActivity(intent);
            }
        });
        return view;
    }
}
