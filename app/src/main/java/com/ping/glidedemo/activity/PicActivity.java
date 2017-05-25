package com.ping.glidedemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.ping.glidedemo.R;
import com.ping.glidedemo.beans.Meizi;

import java.util.List;

/**
 * Created by ss on 2017/5/21.
 */

public class PicActivity extends FragmentActivity{

    private ViewPager mViewPager;
    private List<Meizi> mDatas;
    private static final String EXTRA_POSGET="com.ping.glidedemo.position";

//    public static Intent newIntent(Context packageContext,Integer pos){
//        Intent intent=new Intent(packageContext,PicActivity.class);
//        intent.putExtra(EXTRA_POSACT,pos);
//        return intent;
//    }


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
//            setContentView(R.layout.pic_show);
            setContentView(R.layout.fragment_pic);

//        FragmentManager fm=getSupportFragmentManager();
//        Fragment fragment=fm.findFragmentById(R.id.fragment_container);
//
//        if(fragment==null){
//            fragment=new PicFragment();
//            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
//        }
//
//        mViewPager=(ViewPager) findViewById(R.id.activity_mViewPager);

//        mDatas=Meizi.getResults();


    }

//    protected Fragment createFragment(){
//        int position=(int) getIntent().getSerializableExtra(EXTRA_POSGET);
//        return PicFragment.newInstance(position);
//    }
}
