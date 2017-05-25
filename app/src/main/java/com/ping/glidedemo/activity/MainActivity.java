package com.ping.glidedemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ping.glidedemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bt_base)
    Button mBtBase;
    @BindView(R.id.bt_recycler)
    Button mBtRecycler;
    @BindView(R.id.bt_trans)
    Button mBtTrans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_base, R.id.bt_recycler, R.id.bt_trans})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_base:
                startActivity(new Intent(MainActivity.this, BaseGlideActivity.class));
                break;
            case R.id.bt_recycler:
                startActivity(new Intent(MainActivity.this, RecyclerGlideActivity.class));
                break;
            case R.id.bt_trans:
                startActivity(new Intent(MainActivity.this, TransGlideActivity.class));
                break;
        }
    }
}
