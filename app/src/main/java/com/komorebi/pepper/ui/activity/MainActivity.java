package com.komorebi.pepper.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.komorebi.pepper.R;
import com.komorebi.pepper.ui.fragment.HomeFragment;
import com.komorebi.pepper.ui.fragment.LifeFragment;
import com.komorebi.pepper.ui.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawerLayout;

    private ViewPager viewPager;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);


        //DrawerLayout中点击事件
        LinearLayout llNavHead = findViewById(R.id.ll_nav_head);
        llNavHead.setOnClickListener(this);
        LinearLayout ll_productionTeam = findViewById(R.id.ll_productionTeam);
        LinearLayout ll_feedback = findViewById(R.id.ll_feedback);
        LinearLayout ll_setting = findViewById(R.id.ll_setting);
        LinearLayout ll_exits = findViewById(R.id.ll_exits);
        ll_productionTeam.setOnClickListener(this);
        ll_feedback.setOnClickListener(this);
        ll_setting.setOnClickListener(this);
        ll_exits.setOnClickListener(this);


        viewPager = findViewById(R.id.viewpager);
        HomeFragment homeFragment = new HomeFragment();
        LifeFragment lifeFragment = new LifeFragment();
        MineFragment mineFragment = new MineFragment();
        List<Fragment> alFragment = new ArrayList<>();
        alFragment.add(homeFragment);
        alFragment.add(lifeFragment);
        alFragment.add(mineFragment);
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), alFragment);
        viewPager.setAdapter(myFragmentPagerAdapter);
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_drawer:
                break;
            case R.id.ll_productionTeam:
                drawerLayout.closeDrawers();
                break;
            case R.id.ll_feedback:
                drawerLayout.closeDrawers();
                break;
            case R.id.ll_setting:
                drawerLayout.closeDrawers();
                break;
            case R.id.ll_exits:
                drawerLayout.closeDrawers();
                break;
        }
    }


    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> list;

        public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
