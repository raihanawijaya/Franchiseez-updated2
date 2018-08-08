package Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.franchiseez.R;

import java.util.List;

import data.data_card_alamat;


public class RVAAlamat extends RecyclerView.Adapter<RVAAlamat.ViewHolder> {
    List<data_card_alamat> lists;
    Context context;

    public RVAAlamat (List<data_card_alamat> lists){this.lists = lists;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_alamat,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNamaPembeli.setText(lists.get(position).namaPembeli);
        holder.tvTeleponPembeli.setText(lists.get(position).teleponPembeli);
        holder.tvAlamatPembeli.setText(lists.get(position).alamatPembeli);

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvNamaPembeli, tvTeleponPembeli, tvAlamatPembeli;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNamaPembeli=itemView.findViewById(R.id.tv_nama_pembeli);
            tvTeleponPembeli=itemView.findViewById(R.id.tv_telepon_pembeli);
            tvAlamatPembeli=itemView.findViewById(R.id.tv_alamat_pembeli);
        }
    }
}

