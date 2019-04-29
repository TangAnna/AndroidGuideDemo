package com.example.tang.welcomedemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    private TextView mTvStart;
    //图片资源
    private int[] imgs = new int[]{R.mipmap.welcome_01test, R.mipmap.welcome_02test, R.mipmap.welcome_03test};
    private List<Fragment> mFragmentList;
    private MyPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvStart = findViewById(R.id.tv_start);
        mViewPager = findViewById(R.id.vp_welcome);
        mViewPager.addOnPageChangeListener(this);

        mFragmentList = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            mFragmentList.add(WelcomeFragment.getInstance(imgs[i], i));
        }
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        if (i == imgs.length - 1) {
            mTvStart.setVisibility(View.VISIBLE);
        } else {
            mTvStart.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return mFragmentList.get(i);
        }

        @Override
        public int getCount() {
            return mFragmentList == null ? 0 : mFragmentList.size();
        }
    }
}
