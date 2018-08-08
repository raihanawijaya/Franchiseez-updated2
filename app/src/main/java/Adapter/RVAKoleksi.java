package Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.franchiseez.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import data.data_card_koleksi;
import data.data_card_transaksi;

public class RVAKoleksi extends RecyclerView.Adapter<RVAKoleksi.ViewHolder> {

    List<data_card_koleksi> lists;
    Context context;

    public RVAKoleksi (List<data_card_koleksi> lists) {
        this.lists = lists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_koleksi,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvFrancname.setText(lists.get(position).FrancName);
        holder.tvFrancOrderStock.setText(lists.get(position).FrancOrderStock);
        if (!lists.get(position).UrlFrancLogo.isEmpty()) Picasso.with(context).load(lists.get(position).UrlFrancLogo).fit().placeholder(R.drawable.image3).into(holder.ivFrancLogo);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivFrancLogo;
        TextView tvFrancname, tvFrancOrderStock;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFrancLogo = itemView.findViewById(R.id.ivFrancLogo);
            tvFrancname = itemView.findViewById(R.id.tvFrancName);
            tvFrancOrderStock = itemView.findViewById(R.id.tvOrderStock);
        }
    }
}
