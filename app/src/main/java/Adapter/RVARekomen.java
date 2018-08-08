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

import com.example.asus.franchiseez.R;
import com.example.asus.franchiseez.activity_detil_product.DetilProductActivity;

import java.util.Collections;
import java.util.List;

import data.data_card_saran;

/**
 * Created by ASUS on 29/07/2018.
 */

public class RVARekomen  extends RecyclerView.Adapter<RVARekomen.ViewHolder> {

    List<data_card_saran> listdata = Collections.emptyList();
    Context mcontex;

    public RVARekomen(List<data_card_saran> listdata, Context mcontex) {
        this.listdata = listdata;
        this.mcontex = mcontex;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView1,textView2;
        CardView cardView;

        public ViewHolder(View view){
            super(view);
            imageView = (ImageView) view.findViewById(R.id.image3);
            textView1 = (TextView) view.findViewById(R.id.title_card3);
            textView2 = (TextView) view.findViewById(R.id.harga3);
            cardView = (CardView) view.findViewById(R.id.cardutama3);
        }

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.card_rekomendasi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        data_card_saran data = listdata.get(position);
        holder.imageView.setImageResource(data.getImage());
        holder.textView1.setText(data.getTitle());
        holder.textView2.setText(data.getHarga());

        if(position == 0 || position == 1){
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(holder.cardView.getLayoutParams());
            lp.setMargins(20, getPixelValue(mcontex,15), 0, 0);
            holder.cardView.setLayoutParams(lp);
        }

        if(position == listdata.size()-2 || position == listdata.size()-1){

            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(holder.cardView.getLayoutParams());
            lp.setMargins(getPixelValue(mcontex,5), getPixelValue(mcontex,10), 0, getPixelValue(mcontex,15));
            holder.cardView.setLayoutParams(lp);

        }
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
