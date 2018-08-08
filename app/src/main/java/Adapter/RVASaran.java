package Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.franchiseez.R;
import com.example.asus.franchiseez.activity_detil_product.DetilProductActivity;

import java.util.Collections;
import java.util.List;

import data.data_card_saran;

/**
 * Created by ASUS on 19/07/2018.
 */
public class RVASaran extends RecyclerView.Adapter<RVASaran.ViewHolder> {

    List<data_card_saran> listdata = Collections.emptyList();
    Context mcontex;
    public RVASaran(List<data_card_saran> listdata, Context mcontex) {
        this.listdata = listdata;
        this.mcontex = mcontex;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView1,textView2;
        CardView cardView;

        public ViewHolder(View view){
            super(view);
            imageView = (ImageView) view.findViewById(R.id.image);
            textView1 = (TextView) view.findViewById(R.id.title_card);
            textView2 = (TextView) view.findViewById(R.id.harga);
            cardView = (CardView) view.findViewById(R.id.cardutama);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_saran_home, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        data_card_saran data = listdata.get(position);
        holder.imageView.setImageResource(data.getImage());

        if (position == 0){
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(holder.cardView.getLayoutParams());
            lp.setMargins(getPixelValue(mcontex,24), 0, 0, 0);
            holder.cardView.setLayoutParams(lp);
        }

        if(position == listdata.size() - 1 ){
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(holder.cardView.getLayoutParams());
            lp.setMargins(getPixelValue(mcontex,15), 0, getPixelValue(mcontex,15), 0);
            holder.cardView.setLayoutParams(lp);
        }
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


    public static int getPixelValue(Context context, int dimenId) {
        Resources resources = context.getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dimenId,
                resources.getDisplayMetrics()
        );
    }


}