package com.example.asus.franchiseez;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import Adapter.RVAAlamat;
import Adapter.RVAKoleksi;
import data.data_card_alamat;
import data.data_card_koleksi;

import static java.security.AccessController.getContext;

public class EditAlamatActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    RecyclerView.Adapter adapter;

    RecyclerView.LayoutManager layoutManager;

    List<data_card_alamat> lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_alamat);

//        Toolbar toolbar = (Toolbar) .findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.rvAlamat);
        lists = new ArrayList<>();
        adapter = new RVAAlamat(lists);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        initDummy();
    }

    private void initDummy(){
        lists.add(new data_card_alamat("Raihana","085770077756","Jl. H. Suaib No. 3b Krukut, Limo, Depok"));
        adapter.notifyDataSetChanged();
    }

}
