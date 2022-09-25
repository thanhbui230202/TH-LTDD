package caidat.dmt.list_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DoUong_Adapter extends BaseAdapter {
    private Context  context;
    private int layout;
    private List<DoUong> doUongList;

    public DoUong_Adapter(Context context, int layout, List<DoUong> doUongList) {
        this.context = context;
        this.layout = layout;
        this.doUongList = doUongList;
    }

    @Override
    public int getCount() {
        return doUongList.size();
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
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(layout,null);
        TextView txtTen= (TextView) view.findViewById(R.id.textview_firt);
        TextView txtMota = (TextView) view.findViewById(R.id.textview_2);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.image_hinh);

        DoUong doUong = doUongList.get(i);
        txtTen.setText(doUong.getTen());
        txtMota.setText(doUong.getMota());
        imgHinh.setImageResource(doUong.getHinh());
        return view;
    }
}
