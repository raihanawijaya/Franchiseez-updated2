package com.example.asus.franchiseez.Actifity_lihat_semua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.asus.franchiseez.MainActivity;
import com.example.asus.franchiseez.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.RVATop;
import data.data_card_saran;

public class TopFranchiseActivity extends AppCompatActivity {
    RecyclerView rcv_top;
    RVATop RVAT;
    List<data_card_saran> data;
    ImageView back_arrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_franchise);

        data = fill_data();
        rcv_top = (RecyclerView) findViewById(R.id.rcv_top_franchise);
        RVAT = new RVATop(this,data);
        rcv_top.setLayoutManager(new GridLayoutManager(this,2));
        rcv_top.setAdapter(RVAT);

        back_arrow = (ImageView) findViewById(R.id.arrow_back_top);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TopFranchiseActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

    }

    public List<data_card_saran> fill_data() {

        List<data_card_saran> listdata = new ArrayList<>();
        listdata.add(new data_card_saran(R.drawable.image1, "Pasco bisnis terenak dan baguss", "1.800.000"));
        listdata.add(new data_card_saran(R.drawable.image1, "Pasco", "1.800.000"));
        listdata.add(new data_card_saran(R.drawable.image1, "Pasco", "1.800.000"));
        listdata.add(new data_card_saran(R.drawable.image1, "Pasco", "1.800.000"));
        listdata.add(new data_card_saran(R.drawable.image1, "Pasco", "1.800.000"));
        listdata.add(new data_card_saran(R.drawable.image1, "Pasco", "1.800.000"));
        return listdata;
    }

}
