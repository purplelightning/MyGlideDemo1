package com.ping.glidedemo.activity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.ping.glidedemo.R;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mr.sorrow on 2017/5/1.
 */
public class BaseGlideActivity extends AppCompatActivity {

    @BindView(R.id.tv_glide_1)
    TextView mTvGlide1;
    @BindView(R.id.iv_glide_1)
    ImageView mIvGlide1;
    @BindView(R.id.tv_glide_2)
    TextView mTvGlide2;
    @BindView(R.id.iv_glide_2)
    ImageView mIvGlide2;
    @BindView(R.id.tv_glide_3)
    TextView mTvGlide3;
    @BindView(R.id.iv_glide_3)
    ImageView mIvGlide3;
    @BindView(R.id.tv_glide_4)
    TextView mTvGlide4;
    @BindView(R.id.iv_glide_4)
    ImageView mIvGlide4;
    @BindView(R.id.tv_glide_5)
    TextView mTvGlide5;
    @BindView(R.id.iv_glide_5)
    ImageView mIvGlide5;
    @BindView(R.id.tv_glide_6)
    TextView mTvGlide6;
    @BindView(R.id.iv_glide_6)
    ImageView mIvGlide6;
    @BindView(R.id.tv_glide_7)
    TextView mTvGlide7;
    @BindView(R.id.iv_glide_7)
    ImageView mIvGlide7;
    @BindView(R.id.tv_glide_8)
    TextView mTvGlide8;
    @BindView(R.id.iv_glide_8)
    ImageView mIvGlide8;
    @BindView(R.id.tv_glide_9)
    TextView mTvGlide9;
    @BindView(R.id.iv_glide_9)
    ImageView mIvGlide9;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        mTvGlide1.setText("加载网络图片");
        Glide.with(this).load("http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-28-18094719_120129648541065_8356500748640452608_n.jpg").into(mIvGlide1);

        mTvGlide2.setText("加载资源图片");
        Glide.with(this).load(R.mipmap.ic_launcher).into(mIvGlide2);

        mTvGlide3.setText("加载手机SD卡图片");
        String path = Environment.getExternalStorageDirectory() + "/back.jpg";
        File file = new File(path);
        Uri uri = Uri.fromFile(file);
        Glide.with(this).load(uri).into(mIvGlide3);

        mTvGlide4.setText("加载网络gif");
        String gifUrl = "http://b.hiphotos.baidu.com/zhidao/pic/item/faedab64034f78f066abccc57b310a55b3191c67.jpg";
        Glide.with(this).load(gifUrl).into(mIvGlide4);

        mTvGlide5.setText("加载资源gif");
        Glide.with(this).load(R.drawable.loading).into(mIvGlide5);

        mTvGlide6.setText("加载本地gif");
        String path1 = Environment.getExternalStorageDirectory() + "/meinv2.jpg";
        File file1 = new File(path1);
        Uri uri1 = Uri.fromFile(file1);
        Glide.with(this).load(uri1).placeholder(R.mipmap.ic_launcher).into(mIvGlide6);

        mTvGlide7.setText("加载本地小视频和快照");
        String path2 = Environment.getExternalStorageDirectory() + "/video.mp4";
        File file2 = new File(path2);
        Uri uri2 = Uri.fromFile(file2);
        Glide.with(this).load(uri2).placeholder(R.mipmap.ic_launcher).into(mIvGlide7);


        mTvGlide8.setText("设置缩略图比例,然后，先加载缩略图，再加载原图");
        Glide.with(this).load("http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-28-18094719_120129648541065_8356500748640452608_n.jpg").thumbnail(0.1f).centerCrop().placeholder(R.mipmap.ic_launcher).into(mIvGlide8);

        mTvGlide9.setText("先建立一个缩略图对象，然后，先加载缩略图，再加载原图");
        DrawableRequestBuilder builder = Glide.with(this).load("http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-28-18094719_120129648541065_8356500748640452608_n.jpg");

        Glide.with(this).load(uri2).thumbnail(builder).centerCrop().placeholder(R.mipmap.ic_launcher).into(mIvGlide9);
    }
}
