package com.komorebi.pepper.ui.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.komorebi.pepper.R;
import com.komorebi.pepper.ui.adapter.ViewPagerFgAdapter;
import com.komorebi.pepper.ui.fragment.HomeFragment;
import com.komorebi.pepper.ui.fragment.LifeFragment;
import com.komorebi.pepper.ui.fragment.MineFragment;
import com.komorebi.pepper.utils.ShowSureDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawerLayout;
    private RelativeLayout mLeftMenu;

    private ViewPager viewPager;

    private RadioGroup radioGroup;
    private RadioButton rbHome, rbLife, rbMine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.left_drawer:
                break;
            case R.id.ll_productionTeam:
                drawerLayout.closeDrawers();
                intent = new Intent(MainActivity.this, TeamActivity.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.ll_feedback:
                intent = new Intent(MainActivity.this, BugFeedbackActivity.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                drawerLayout.closeDrawers();
                break;
            case R.id.ll_setting:
                intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                drawerLayout.closeDrawers();
                break;
            case R.id.ll_exits:
                showAlertDialog();
                break;
        }
    }


    public void initView() {

        mLeftMenu = findViewById(R.id.left_drawer);
        mLeftMenu.setOnClickListener(this);

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
        List<Fragment> alFragment = new ArrayList<>(3);
        alFragment.add(homeFragment);
        alFragment.add(lifeFragment);
        alFragment.add(mineFragment);
        ViewPagerFgAdapter viewPagerFgAdapter = new ViewPagerFgAdapter(getSupportFragmentManager(), alFragment);
        viewPager.setAdapter(viewPagerFgAdapter);

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

        setRadioButton(R.drawable.selector_tab_home, rbHome);
        setRadioButton(R.drawable.selector_tab_life, rbLife);
        setRadioButton(R.drawable.selector_tab_mine, rbMine);

//        RadioGroup选中状态改变监听
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        viewPager.setCurrentItem(0);
                        rbHome.setTextSize(14);
                        rbLife.setTextSize(12);
                        rbMine.setTextSize(12);
                        break;
                    case R.id.rb_life:
                        viewPager.setCurrentItem(1);
                        rbHome.setTextSize(12);
                        rbLife.setTextSize(14);
                        rbMine.setTextSize(12);
                        break;
                    case R.id.rb_mine:
                        viewPager.setCurrentItem(2);
                        rbHome.setTextSize(12);
                        rbLife.setTextSize(12);
                        rbMine.setTextSize(14);
                        break;
                }
            }
        });
    }

    //在RadioButton使用中，可能需要放入图片，但是XML中无法直接设置图片的大小
    public void setRadioButton(int id, RadioButton radioButton) {
        Drawable drawable = getResources().getDrawable(id);
        drawable.setBounds(0, 0, 80, 80);
        radioButton.setCompoundDrawables(null, drawable, null, null);//只放上面
    }

    public void showAlertDialog() {
        ShowSureDialog sureDialog = new ShowSureDialog(this, "是否退出登录？", new ShowSureDialog.CallBack() {
            @Override
            public void CallBack() {
                //清除密码
                SharedPreferences userInfo = getSharedPreferences("userInfo", MODE_PRIVATE);
                SharedPreferences.Editor editor = userInfo.edit();//获取Editor
                editor.clear();
                editor.apply();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                //为了防止，点击退出登录后按返回键还能回到程序中
                finish();
                startActivity(intent);
            }
        });
        sureDialog.showDialog();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        long exitTime = System.currentTimeMillis();
        //设置按键频率与关闭应用的关系
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!drawerLayout.isDrawerOpen(mLeftMenu)) {
                if ((System.currentTimeMillis() - exitTime) > 300 && (System.currentTimeMillis() - exitTime) < 2000) {
                    //返回桌面
                    finish();
                } else if ((System.currentTimeMillis() - exitTime) < 300) {
                    exitTime = System.currentTimeMillis();
                } else {
                    exitTime = System.currentTimeMillis();
                    Toast.makeText(MainActivity.this, "再按一次返回键退出", Toast.LENGTH_SHORT).show();
                }
                return true;
            } else {
                drawerLayout.closeDrawers();
                return true;
            }
        }
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            if (!drawerLayout.isDrawerOpen(mLeftMenu)) {
                drawerLayout.openDrawer(mLeftMenu);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
