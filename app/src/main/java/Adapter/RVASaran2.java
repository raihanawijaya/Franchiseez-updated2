package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.franchiseez.R;
import com.example.asus.franchiseez.activity_detil_product.DetilProductActivity;

import java.util.Collections;
import java.util.List;

import data.data_card_saran;

/**
 * Created by ASUS on 20/07/2018.
 */

public class RVASaran2 extends RecyclerView.Adapter<RVASaran2.ViewHolder> {

    List<data_card_saran> listdata = Collections.emptyList();
    Context mcontex;
    public RVASaran2(List<data_card_saran> listdata, Context mcontex) {
        this.listdata = listdata;
        this.mcontex = mcontex;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView1,textView2;
        CardView cardView;

        public ViewHolder(View view){
            super(view);
            imageView = (ImageView) view.findViewById(R.id.image2);
            textView1 = (TextView) view.findViewById(R.id.title_card2);
            textView2 = (TextView) view.findViewById(R.id.harga2);
            cardView = (CardView) view.findViewById(R.id.cardutama2);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_saran2_home, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        data_card_saran data = listdata.get(position);
        holder.imageView.setImageResource(data.getImage());
        holder.textView1.setText(data.getTitle());
        holder.textView2.setText(data.getHarga());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mcontex,DetilProductActivity.class);
                mcontex.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


}