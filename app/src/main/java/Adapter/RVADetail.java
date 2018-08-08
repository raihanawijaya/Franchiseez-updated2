package Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.franchiseez.R;

import java.util.List;

import data.data_card_paket_detail;

/**
 * Created by ASUS on 31/07/2018.
 */

public class RVADetail extends RecyclerView.Adapter<RVADetail.ViewHolder> {

    Context mcontex;
    List<data_card_paket_detail> listdata;

    public RVADetail(Context mcontex, List<data_card_paket_detail> listdata) {
        this.mcontex = mcontex;
        this.listdata = listdata;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nama,harga,fasilitas;

        public ViewHolder(View view){
            super(view);
            nama = (TextView) view.findViewById(R.id.nama_paket);
            harga = (TextView) view.findViewById(R.id.harga_paket);
            fasilitas = (TextView) view.findViewById(R.id.fasilitas);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_paket_product,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        data_card_paket_detail data = listdata.get(position);
        holder.nama.setText(data.getNama_paket());
        holder.harga.setText(data.getHarga());
        holder.fasilitas.setText(data.getFasilitas());

    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


}
