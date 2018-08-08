package fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.asus.franchiseez.Actifity_lihat_semua.RekomendasiActivity;
import com.example.asus.franchiseez.Actifity_lihat_semua.TopFranchiseActivity;
import com.example.asus.franchiseez.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Adapter.RVASaran;
import Adapter.RVASaran2;
import data.data_card_saran;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener {

    private SliderLayout mDemoSlider;

    RecyclerView horizontal_recycler_view, rcv_grid;
    RVASaran horizontalAdapter;
    RVASaran2 rcvgridAdapter;
    TextView lihatsemua1,lihatsemua2;

    List<data_card_saran> data;
    private static final String TAG = "HomeFragment";
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_home, container, false);
        horizontal_recycler_view= (RecyclerView) view.findViewById(R.id.rcvsaran);
        data = fill_data();

        horizontalAdapter=new RVASaran(data, getContext());

        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManager);
        horizontal_recycler_view.setAdapter(horizontalAdapter);

        rcv_grid = (RecyclerView) view.findViewById(R.id.rcv2);
        rcvgridAdapter = new RVASaran2(data, getContext());
        rcv_grid.setLayoutManager(new GridLayoutManager(getContext(),2));
        rcv_grid.setAdapter(rcvgridAdapter);


        lihatsemua1 = (TextView) view.findViewById(R.id.lihat_semua1);
        lihatsemua1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),RekomendasiActivity.class);
                startActivity(i);
            }
        });

        lihatsemua2 = (TextView) view.findViewById(R.id.lihatsemua2);
        lihatsemua2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getContext(),TopFranchiseActivity.class);
                startActivity(i);
            }
        });
        // 4 code your aktivity
        // implementasi your slider

        mDemoSlider = (SliderLayout) view.findViewById(R.id.slider1);

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
            TextSliderView textSliderView = new TextSliderView(getActivity());
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
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Left_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(3000);
        mDemoSlider.addOnPageChangeListener(this);

        // if you have even


        return view;

    }

    public List<data_card_saran> fill_data(){

        List<data_card_saran> listdata = new ArrayList<>();
        listdata.add(new data_card_saran(R.drawable.image1,"Pasco bisnis terenak dan baguss","1.800.000"));
        listdata.add(new data_card_saran(R.drawable.image1,"Pasco","1.800.000"));
        listdata.add(new data_card_saran(R.drawable.image1,"Pasco","1.800.000"));
        listdata.add(new data_card_saran(R.drawable.image1,"Pasco","1.800.000"));
        listdata.add(new data_card_saran(R.drawable.image1,"Pasco","1.800.000"));
        listdata.add(new data_card_saran(R.drawable.image1,"Pasco","1.800.000"));
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
        Toast.makeText(getContext().getApplicationContext(),slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();

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
