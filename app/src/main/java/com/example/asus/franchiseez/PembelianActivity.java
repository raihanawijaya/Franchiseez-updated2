package com.example.asus.franchiseez;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PembelianActivity extends AppCompatActivity {

    Spinner spinner;
    TextView namaPaket, fasilitasPaket, hargaPaket;
    RelativeLayout rlOpsiPengiriman, rlMetodePembayaran;
    LinearLayout rlEditAlamat;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembelian);
        context = this;
        rlOpsiPengiriman = findViewById(R.id.rlOpsiPengiriman);
        rlEditAlamat = findViewById(R.id.rlTambahAlamat);
        rlMetodePembayaran = findViewById(R.id.rlMetodePembayaran);

        rlOpsiPengiriman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, OpsiPengirimanActivity.class);
                context.startActivity(intent);
            }
        });

        rlEditAlamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditAlamatActivity.class);
                context.startActivity(intent);
            }
        });

        rlMetodePembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MetodePembayaranActivity.class);
                context.startActivity(intent);
            }
        });

        AddItemsOnSpinner();
    }

    public void AddItemsOnSpinner() {

        spinner = (Spinner) findViewById(R.id.spinnerPaket);
        namaPaket = findViewById(R.id.tvNamaPaket);
        fasilitasPaket = findViewById(R.id.tvFasilitasPaket);
        hargaPaket = findViewById(R.id.tvHargaPaket);

        List<String> list = new ArrayList<String>();
        list.add("Pilih Paket...");

        list.add("Paket 1");
        list.add("Paket 2");
        list.add("Paket 3");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        namaPaket.setVisibility(View.GONE);
                        fasilitasPaket.setVisibility(View.GONE);
                        hargaPaket.setVisibility(View.GONE);
                        break;
                    case 1:
                        namaPaket.setVisibility(View.VISIBLE);
                        fasilitasPaket.setVisibility(View.VISIBLE);
                        hargaPaket.setVisibility(View.VISIBLE);

                        namaPaket.setText("PAKET 1");
                        break;
                    case 2:
                        namaPaket.setVisibility(View.VISIBLE);
                        fasilitasPaket.setVisibility(View.VISIBLE);
                        hargaPaket.setVisibility(View.VISIBLE);
                        namaPaket.setText("PAKET 2");
                        break;
                    case 3:
                        namaPaket.setVisibility(View.VISIBLE);
                        fasilitasPaket.setVisibility(View.VISIBLE);
                        hargaPaket.setVisibility(View.VISIBLE);
                        namaPaket.setText("PAKET 3");
                        break;
                    default:
                        namaPaket.setVisibility(View.GONE);
                        fasilitasPaket.setVisibility(View.GONE);
                        hargaPaket.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}
