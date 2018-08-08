package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.asus.franchiseez.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.RVATransaksi;
import data.data_card_transaksi;

/**
 * A simple {@link Fragment} subclass.
 */
public class PembelianFragment extends Fragment {
    RecyclerView recyclerView;

    RecyclerView.Adapter adapter;

    RecyclerView.LayoutManager layoutManager;

    List<data_card_transaksi> lists;

    List<String> spinnerItem;

    Spinner spinner;


    public PembelianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pembelian, container, false);
        spinner = v.findViewById(R.id.spinerPembelian);
        recyclerView = v.findViewById(R.id.rvPembelian);
        lists = new ArrayList<>();
        adapter = new RVATransaksi(lists);
        layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        spinnerItem = new ArrayList<>();
        spinnerItem.add("All");
        spinnerItem.add("Bahan baku");
        spinnerItem.add("Franchise");

        spinner.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,spinnerItem));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
//                Toast.makeText(getContext(),"Item = "+item,Toast.LENGTH_SHORT).show();
                if(item.equals(spinnerItem.get(0))){
                    lists.clear();
                    lists.add(new data_card_transaksi("https://mir-s3-cdn-cf.behance.net/project_modules/disp/7a325c12071131.56258498e5548.jpg","ALL","Raihana","12.000.000","Sudah dikirim"));
                    lists.add(new data_card_transaksi("https://mir-s3-cdn-cf.behance.net/project_modules/disp/7a325c12071131.56258498e5548.jpg","ALL","Raihana","12.000.000","Sudah dikirim"));
                    lists.add(new data_card_transaksi("https://mir-s3-cdn-cf.behance.net/project_modules/disp/7a325c12071131.56258498e5548.jpg","ALL","Raihana","12.000.000","Sudah dikirim"));
                    adapter.notifyDataSetChanged();
                }else if(item.equals(spinnerItem.get(1))){
                    lists.clear();
                    lists.add(new data_card_transaksi("https://mir-s3-cdn-cf.behance.net/project_modules/disp/7a325c12071131.56258498e5548.jpg","Bahan baku","Raihana","12.000.000","Sudah dikirim"));
                    lists.add(new data_card_transaksi("https://mir-s3-cdn-cf.behance.net/project_modules/disp/7a325c12071131.56258498e5548.jpg","Bahan baku","Raihana","12.000.000","Sudah dikirim"));
                    lists.add(new data_card_transaksi("https://mir-s3-cdn-cf.behance.net/project_modules/disp/7a325c12071131.56258498e5548.jpg","Bahan baku","Raihana","12.000.000","Sudah dikirim"));
                    adapter.notifyDataSetChanged();

                }else if(item.equals(spinnerItem.get(2))){
                    lists.clear();
                    lists.add(new data_card_transaksi("https://mir-s3-cdn-cf.behance.net/project_modules/disp/7a325c12071131.56258498e5548.jpg","Franchise","Raihana","12.000.000","Sudah dikirim"));
                    lists.add(new data_card_transaksi("https://mir-s3-cdn-cf.behance.net/project_modules/disp/7a325c12071131.56258498e5548.jpg","Franchise","Raihana","12.000.000","Sudah dikirim"));
                    lists.add(new data_card_transaksi("https://mir-s3-cdn-cf.behance.net/project_modules/disp/7a325c12071131.56258498e5548.jpg","Franchise","Raihana","12.000.000","Sudah dikirim"));
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return v;
    }

}
