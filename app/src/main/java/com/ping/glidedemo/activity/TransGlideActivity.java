package com.ping.glidedemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ping.glidedemo.R;
import com.ping.glidedemo.adapter.TransAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mr.sorrow on 2017/5/1.
 */
public class TransGlideActivity extends AppCompatActivity {

    @BindView(R.id.rv_glide_transformations)
    RecyclerView mRvGlideTransformations;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);
        ButterKnife.bind(this);

        mRvGlideTransformations.setAdapter(new TransAdapter(this));
        mRvGlideTransformations.setLayoutManager(new LinearLayoutManager(this));
    }
}
