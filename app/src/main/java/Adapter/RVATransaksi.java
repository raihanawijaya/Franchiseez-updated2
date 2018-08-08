package Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.franchiseez.R;

import com.squareup.picasso.Picasso;

import java.util.List;

import data.data_card_transaksi;

public class RVATransaksi extends  RecyclerView.Adapter<RVATransaksi.ViewHolder> {

    List<data_card_transaksi> lists;
    Context context;

    public RVATransaksi(List<data_card_transaksi> lists) {
        this.lists = lists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_transaksi,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvCardTransaksiStatus.setText(lists.get(position).status);
        holder.tvCardTransaksiPrice.setText(lists.get(position).price);
        holder.tvCardTransaksiTitle.setText(lists.get(position).title);
        holder.tvCardTransaksiName.setText(lists.get(position).by);

        if(!lists.get(position).urlImage.isEmpty()) Picasso.with(context).load(lists.get(position).urlImage).fit().placeholder(R.drawable.image3).into(holder.ivCardTransaksi);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivCardTransaksi;
        TextView tvCardTransaksiTitle, tvCardTransaksiName, tvCardTransaksiPrice,
                tvCardTransaksiStatus;

        public ViewHolder(View itemView) {
            super(itemView);
            ivCardTransaksi = itemView.findViewById(R.id.ivCardTransaksi);
            tvCardTransaksiName = itemView.findViewById(R.id.tvCardTransaksiName);
            tvCardTransaksiTitle = itemView.findViewById(R.id.tvCardTransaksiTitle);
            tvCardTransaksiPrice = itemView.findViewById(R.id.tvCardTransaksiPrice);
            tvCardTransaksiStatus = itemView.findViewById(R.id.tvCardTransaksiStatus);
        }
    }
}
