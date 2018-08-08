package com.example.asus.franchiseez;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import fragment.AccountFragment;
import fragment.HomeFragment;
import fragment.KoleksiFragment;
import fragment.PembelianFragment;
import fragment.PenjualanFragment;
import fragment.TransaksiFragment;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivityFragment";
    private BottomNavigationView nMainNav;
    private FrameLayout nMainFrame;

    private HomeFragment homeFragment;
    private TransaksiFragment transaksi;
    private AccountFragment accountFragment;


    private MenuItem menuItemSelected;
    private int mMenuItemSelected;
    private static final String SELECTED_ITEM = "selected_item";
    private Boolean exit = false;
    private List<String> listdata1 = new ArrayList<>();
    private int i = 0, j=0;
    private int klik1 = 0;
    private int klik2 = 0;
    private int klik3 = 0;
    private int klik4 = 0;

    private SectionPagerAdapter sectionPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.cont);
        setupViewPager(viewPager);


        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        nMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        nMainNav = (BottomNavigationView) findViewById(R.id.main_nav);
        BottomNavigationViewHelper.disableShiftMode(nMainNav);
        homeFragment = new HomeFragment();
        transaksi = new TransaksiFragment();
        accountFragment = new AccountFragment();


        nMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                selectFragment(item);
                return true;
            }
        });

        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_frame, homeFragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();

        if (savedInstanceState != null) {
            mMenuItemSelected = savedInstanceState.getInt(SELECTED_ITEM, 0);
            menuItemSelected = nMainNav.getMenu().findItem(mMenuItemSelected);
        } else {
            menuItemSelected = nMainNav.getMenu().getItem(0);
        }

        selectFragment(menuItemSelected);



    }

    private void selectFragment(MenuItem item) {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.tmp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar_transaksi);
        Fragment fragment = null;
        Class fragmentClass;
        switch (item.getItemId()) {
            case R.id.nav_home:
                toolbar.setVisibility(View.VISIBLE);
                toolbar1.setVisibility(View.GONE);
                viewPager.setVisibility(View.GONE);
                tabLayout.setVisibility(View.GONE);
                fragmentClass = HomeFragment.class;
                klik1++;
                if(klik1 < 2) {
                    listdata1.add("0");
                    klik2=0;
                    klik3=0;
                    klik4=0;
                    i=0;
                }
                Log.d(TAG,"MANTAP "+ listdata1.size());
                Log.d(TAG,"nilai "+ listdata1.get(listdata1.size()-1));
                break;
            case R.id.nav_transaksi:
                toolbar.setVisibility(View.GONE);
                toolbar1.setVisibility(View.VISIBLE);
                viewPager.setVisibility(View.VISIBLE);
                tabLayout.setVisibility(View.VISIBLE);
                fragmentClass = TransaksiFragment.class;
                klik2++;
                if(klik2 < 2) {
                    listdata1.add("1");
                    klik1=0;
                    klik3=0;
                    klik4=0;
                    i=0;
                }
                Log.d(TAG,"MANTAP "+ listdata1.size());
                Log.d(TAG,"nilai "+ listdata1.get(listdata1.size()-1));


                break;
            case R.id.nav_koleksi:
                toolbar.setVisibility(View.VISIBLE);
                toolbar1.setVisibility(View.GONE);
                viewPager.setVisibility(View.GONE);
                tabLayout.setVisibility(View.GONE);
                fragmentClass = KoleksiFragment.class;
                klik3++;
                if(klik2 < 2) {
                    listdata1.add("2");
                    klik1=0;
                    klik2=0;
                    klik4=0;
                    i=0;
                }
                Log.d(TAG,"MANTAP "+ listdata1.size());
                Log.d(TAG,"nilai "+ listdata1.get(listdata1.size()-1));

                break;
            case R.id.nav_account:
                toolbar.setVisibility(View.GONE);
                toolbar1.setVisibility(View.GONE);
                viewPager.setVisibility(View.GONE);
                tabLayout.setVisibility(View.GONE);
                fragmentClass = AccountFragment.class;
                klik4++;
                if(klik3 < 2) {
                    listdata1.add("3");
                    klik1=0;
                    klik2=0;
                    klik3=0;
                    i=0;
                }
                Log.d(TAG,"MANTAP "+ listdata1.size());
                Log.d(TAG,"nilai "+ listdata1.get(listdata1.size()-1));
                break;

            default:
                fragmentClass = HomeFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_frame, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, mMenuItemSelected);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        i++;
        j=i;
        if(listdata1.size() == 1){
            finish();
        }else if(i <= 3) {
            if (listdata1.get(listdata1.size() - 2) == "0") {
                nMainNav.setSelectedItemId(R.id.nav_home);
                listdata1.remove(listdata1.size()-1);
                listdata1.remove(listdata1.size()-1);
                i=j;

            }else if(listdata1.get(listdata1.size() - 2) == "1"){
                nMainNav.setSelectedItemId(R.id.nav_transaksi);
                listdata1.remove(listdata1.size()-1);
                listdata1.remove(listdata1.size()-1);
                i=j;
            }else if(listdata1.get(listdata1.size() - 2) == "2"){
                nMainNav.setSelectedItemId(R.id.nav_koleksi);
                listdata1.remove(listdata1.size()-1);
                listdata1.remove(listdata1.size()-1);
                i=j;
            }else if(listdata1.get(listdata1.size() - 2) == "3"){
                nMainNav.setSelectedItemId(R.id.nav_account);
                listdata1.remove(listdata1.size()-1);
                listdata1.remove(listdata1.size()-1);
                i=j;
            }

        }else if(i==4 || i==5){
            nMainNav.setSelectedItemId(R.id.nav_home);
            i=j;
            if(i==5){
                finish();
            }
        }else {
            finish();
        }
        Log.d(TAG,"YOOOPS "+ listdata1.size()+" "+i);

    }

    private void setupViewPager(ViewPager viewPager){
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PembelianFragment(),"Pembelian");
        adapter.addFragment(new PenjualanFragment(),"Penjualan");
        viewPager.setAdapter(adapter);
    }

    private void setFragment(Fragment fragment){
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_frame, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.commit();

    }
}
