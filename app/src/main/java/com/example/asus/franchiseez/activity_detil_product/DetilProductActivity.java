package com.example.asus.franchiseez.activity_detil_product;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.asus.franchiseez.Actifity_lihat_semua.RekomendasiActivity;
import com.example.asus.franchiseez.PembelianActivity;
import com.example.asus.franchiseez.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Adapter.RVADetail;
import data.data_card_paket_detail;

public class DetilProductActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener{
    private SliderLayout mDemoSlider;
    private RecyclerView rcv_detail;
    private RVADetail RVAD;
    private RelativeLayout rlDetailProductGabung;
    Context context;

    List<data_card_paket_detail> data;
    ImageView arrow_back_detail;
    Toolbar toolbar;
    ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil_product);

        context = this;
        data = fill_data();
        rcv_detail = (RecyclerView) findViewById(R.id.rcv_detail);
        RVAD = new RVADetail(this,data);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rcv_detail.setLayoutManager(horizontalLayoutManager);
        rcv_detail.setAdapter(RVAD);

        rlDetailProductGabung = findViewById(R.id.rlDetailProductGabung);

        rlDetailProductGabung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PembelianActivity.class);
                context.startActivity(intent);

            }
        });

        arrow_back_detail = (ImageView) findViewById(R.id.arrow_back_detail);
        arrow_back_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetilProductActivity.this,RekomendasiActivity.class);
                startActivity(i);
            }
        });


        mDemoSlider = (SliderLayout) findViewById(R.id.slider2);

        // and add url image with internet
        // you can see hannibal is textview
        // and url is image
        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "https://www.franchiseindia.com//uploads/content/fi/art/5b2cc6553a1f4.jpg");
        url_maps.put("Big Bang Theory", "https://www.mannlawyers.com/wp-content/uploads/2018/03/franchises.jpg");
        url_maps.put("House of Cards", "https://www.pacificabs.com/wp-content/uploads/2018/01/franchise2.jpg");
        url_maps.put("keren","https://73v3u36iopz178i0z3a33g7d-wpengine.netdna-ssl.com/wp-content/uploads/2017/09/global-franchises-768x512.jpg");

        // when we show slider, we must create for or while, you can add it
        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }

        // you can change animasi, time page and anythink.. read more on github
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(3000);
        mDemoSlider.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);
        mDemoSlider.addOnPageChangeListener(this);

    }

    public List<data_card_paket_detail> fill_data(){

        List<data_card_paket_detail> listdata = new ArrayList<>();
        listdata.add(new data_card_paket_detail("Paket Fame","Rp 7.600.000","Paket Outdoor dari harga normal 10.000.000 diskon menjadi 7.800.000 saja\n" +
                "(Paket Lengkap sudah dengan Booth/Gerobak dan Perlengkapan siap berjualan)"));
        listdata.add(new data_card_paket_detail("Paket Hits","Rp 8.600.000","Paket Indoor dari harga normal 12.000.000 diskon menjadi 8.800.000 saja\n" +
                "(Paket Lengkap sudah dengan Booth/Gerobak dan Perlengkapan siap berjualan))"));
        listdata.add(new data_card_paket_detail("Paket Fame","Rp 10.600.000","Dari harga normal 8.000.000 diskon menjadi 6.600.000 saja\n" +
                "(Peralatan komplit hanya Tanpa Booth/Gerobak))"));

        return listdata;
    }

    @Override
    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(getApplicationContext(),slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();

        // you can handle even this method
        // webview or go activity
        // ok dude
        // thanks for watching
        // if you have ask, please comments like and subsribe
        // thanks
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
