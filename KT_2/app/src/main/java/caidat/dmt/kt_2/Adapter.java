package caidat.dmt.kt_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    Context context;
    ArrayList<Item> list;

    public Adapter(Context context, ArrayList<Item> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
     Item item = list.get(position);
     holder.tenkh.setText(item.getTenkh());
     holder.tentg.setText(item.getTentg());
     holder.dactinh.setText(item.getDactinh());
     holder.maula.setText(item.getMaula());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tenkh,tentg,dactinh,maula;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tenkh = itemView.findViewById(R.id.tenkhoahoc);
            tentg = itemView.findViewById(R.id.tenthuonggoi);
            dactinh = itemView.findViewById(R.id.dactinh);
            maula = itemView.findViewById(R.id.maula);
        }
    }


}
