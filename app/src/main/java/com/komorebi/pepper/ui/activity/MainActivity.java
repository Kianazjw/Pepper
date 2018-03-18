package com.komorebi.pepper.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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


    private RadioGroup radioGroup;
    private RadioButton rbHome, rbLife, rbMine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);

        initView();

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


    public void initView() {

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

        //viewPager和RadioGroup关联
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioGroup.check(R.id.rb_home);
                        break;
                    case 1:
                        radioGroup.check(R.id.rb_life);
                        break;
                    case 2:
                        radioGroup.check(R.id.rb_mine);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

//        RadioGroup部分
        radioGroup = findViewById(R.id.radioGroup);
        rbHome = findViewById(R.id.rb_home);
        rbLife = findViewById(R.id.rb_life);
        rbMine = findViewById(R.id.rb_mine);

        //在RadioButton使用中，可能需要放入图片，但是XML中无法直接设置图片的大小
        Drawable drawableHome = getResources().getDrawable(R.drawable.selector_tab_home);
        //由 x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
        // left,tob,rigth,bottom 指该矩形各条边到画布坐标轴的距离（一般是画布的左顶点水平方向为X轴，垂直方向为Y轴，Y轴向下为正
        drawableHome.setBounds(0, 0, 80, 80);
        rbHome.setCompoundDrawables(null, drawableHome, null, null);//只放上面

        Drawable drawableLife = getResources().getDrawable(R.drawable.selector_tab_life);
        drawableLife.setBounds(0, 0, 80, 80);
        rbLife.setCompoundDrawables(null, drawableLife, null, null);

        Drawable drawableMine = getResources().getDrawable(R.drawable.selector_tab_mine);
        drawableMine.setBounds(0, 0, 80, 80);
        rbMine.setCompoundDrawables(null, drawableMine, null, null);

//        RadioGroup选中状态改变监听
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        viewPager.setCurrentItem(0, false);
                        rbHome.setTextSize(14);
                        rbLife.setTextSize(12);
                        rbMine.setTextSize(12);
                        break;
                    case R.id.rb_life:
                        viewPager.setCurrentItem(1, false);
                        rbHome.setTextSize(12);
                        rbLife.setTextSize(14);
                        rbMine.setTextSize(12);
                        break;
                    case R.id.rb_mine:
                        viewPager.setCurrentItem(2, false);
                        rbHome.setTextSize(12);
                        rbLife.setTextSize(12);
                        rbMine.setTextSize(14);
                        break;
                }
            }
        });
    }
}
