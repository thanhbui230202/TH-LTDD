package caidat.dmt.gk;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
public class DoUong_Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<NuocUong> nuocUongList;

    public DoUong_Adapter(Context context, int layout, List<NuocUong> nuocUongList) {
        this.context = context;
        this.layout = layout;
        this.nuocUongList = nuocUongList;
    }

    @Override
    public int getCount() {
        return nuocUongList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view= layoutInflater.inflate(layout,null);
        // anh xa view
        ImageView imgView =(ImageView) view.findViewById(R.id.imgHinhNuocUong);
        TextView txtTennuoc= (TextView) view.findViewById(R.id.txtTenNuoc);
        TextView txtMoTa= (TextView) view.findViewById(R.id.txtMoTa);
        TextView txthangSX= (TextView) view.findViewById(R.id.txtHangSX);
        NuocUong game = nuocUongList.get(i);
        imgView.setImageResource(game.getImg());
        txtTennuoc.setText(game.getTenNuoc());
        txtMoTa.setText(game.getMoTa());
        txthangSX.setText(game.getHangSX());
        return view;
    }
}