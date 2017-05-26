package com.renjue.yuzhilai.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.renjue.yuzhilai.R;
import com.renjue.yuzhilai.fragment.FragmentCourse;
import com.renjue.yuzhilai.fragment.FragmentMine;
import com.renjue.yuzhilai.fragment.FragmentStudy;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去头
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);
        initView();
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, new FragmentStudy()).commit();
        rg.setOnCheckedChangeListener(this);
    }

    private void initView() {
        rg = (RadioGroup) findViewById(R.id.rg);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_study:
                replaceFragment(new FragmentStudy());
                break;
            case R.id.rb_course:
                replaceFragment(new FragmentCourse());
                break;
            case R.id.rb_mine:
                replaceFragment(new FragmentMine());
                break;
        }
    }
    public void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
    }
}
