package com.pack.bicisegura;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;

public class Pestañas_entrega2 extends Fragment {
    TabItem MasPel, MenosPel;
    ViewPager viewPager;
    TabLayout tablayout;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.pestanas_entrega2, container, false);

        Toast.makeText(getActivity(), "Ya se están viendo todas las denuncias", Toast.LENGTH_LONG).show();


        tablayout = view.findViewById(R.id.tab_layout);
        //tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewPager = view.findViewById(R.id.vista_pags);
        //tablayout.setupWithViewPager(viewPager);

        MasPel = view.findViewById(R.id.mas);
        MenosPel = view.findViewById(R.id.menos);
        tablayout.setTabTextColors(Color.parseColor("#000000"), Color.parseColor("#ffffff"));

        viewPager.setAdapter(new PagerAdapter(getChildFragmentManager(), tablayout.getTabCount())); //setAdapter(PagerAdapter)
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));

        tablayout.addOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //pagerAdapter = new PagerController(getChildFragmentManager(),tablayout.getTabCount());
        //viewPager.setAdapter();
        //viewPager


        return view;

    }
    public class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }


        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new Mas_Peligrosas();
                case 1:
                    return new Menos_Peligrosas();

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }
}
