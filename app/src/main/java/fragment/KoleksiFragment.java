package fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.franchiseez.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.RVAKoleksi;
import Adapter.RVATransaksi;
import data.data_card_koleksi;
import data.data_card_transaksi;

/**
 * A simple {@link Fragment} subclass.
 */
public class KoleksiFragment extends Fragment {

    RecyclerView recyclerView;

    RecyclerView.Adapter adapter;

    RecyclerView.LayoutManager layoutManager;

    List<data_card_koleksi> lists;


    public KoleksiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_koleksi, container, false);
        initObject(getContext(), v);
        initDummy();
        return v;
    }



    private void initDummy(){
        lists.add(new data_card_koleksi("","Dum dum 1","Order Stock"));
        lists.add(new data_card_koleksi("","Dum dum 2","Order Stock"));
        lists.add(new data_card_koleksi("","Dum dum 3","Order Stock"));
        lists.add(new data_card_koleksi("","Dum dum 4","Order Stock"));
        lists.add(new data_card_koleksi("","Dum dum 5","Order Stock"));
        lists.add(new data_card_koleksi("","Dum dum 6","Order Stock"));

        adapter.notifyDataSetChanged();
    }

    private void initObject (Context context, View v){
        Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolbar);
        recyclerView = v.findViewById(R.id.rvKoleksi);
        lists = new ArrayList<>();
        adapter = new RVAKoleksi(lists);
        layoutManager = new GridLayoutManager(context,2);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

}
