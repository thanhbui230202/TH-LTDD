package com.example.quanlimaytinh2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ComputerAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Computer> congvieclist;

    @Override
    public int getCount() {
        return congvieclist.size();
    }

    public ComputerAdapter(Context context, int layout, List<Computer> congvieclist) {
        this.context = context;
        this.layout = layout;
        this.congvieclist = congvieclist;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class Viewholder{
        TextView txtComputer;
        ImageView imgUpdate,imgDelete;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Viewholder holder;
        if(view == null){
            holder = new Viewholder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.txtComputer = (TextView)view.findViewById(R.id.tencp);
            holder.imgDelete=(ImageView)  view.findViewById(R.id.xoacp);
            holder.imgUpdate = (ImageView) view.findViewById(R.id.suacp);
            view.setTag(holder);
        }else{
            holder =(Viewholder) view.getTag();
        }
        Computer computer = congvieclist.get(i);
        holder.txtComputer.setText(computer.getTencp());


        return view;
    }



}
