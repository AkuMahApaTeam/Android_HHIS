package com.mrabid.hhis;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mrabid.hhis.Adapter.PagerAdapter;


public class MainActivity extends AppCompatActivity {

    ViewPager _viewPager;
    TabLayout _tabLayout;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        _viewPager = (ViewPager) findViewById(R.id.ViewPager);
        _tabLayout = (TabLayout) findViewById(R.id.TabLayout);

        // tab 1 (RiwayatPasien)
        TabLayout.Tab firstTab = _tabLayout.newTab();
        firstTab.setText("Patients");
        firstTab.setIcon(R.drawable.pasien);
        _tabLayout.addTab(firstTab);

        // tab 2 (Dokter)
        TabLayout.Tab secondTab = _tabLayout.newTab();
        secondTab.setText("Article");
        secondTab.setIcon(R.drawable.newspaper);
        _tabLayout.addTab(secondTab);


        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), _tabLayout.getTabCount());
        _viewPager.setAdapter(adapter);

        _viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(_tabLayout));
    }
}
