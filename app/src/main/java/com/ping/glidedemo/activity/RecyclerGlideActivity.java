package com.ping.glidedemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ping.glidedemo.R;
import com.ping.glidedemo.adapter.MeiziAdapter;
import com.ping.glidedemo.adapter.MeiziAdapter0;
import com.ping.glidedemo.beans.Meizi;
import com.ping.glidedemo.beans.Meizi0;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mr.sorrow on 2017/5/1.
 */
public class RecyclerGlideActivity extends AppCompatActivity {

    private List<Meizi> data = new ArrayList<>();
    private List<String> data0 = new ArrayList<String>();
    private MeiziAdapter0 mAdapter0;
    private MeiziAdapter mAdapter;
    private Context mContext = this;
    public static final String EXTRA_POS = "com.ping.glidedemo.position";

    @BindView(R.id.recycler_mm)
    RecyclerView mRecyclerMm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ButterKnife.bind(this);

        initData();
        initData0();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_staggerdview:
                mAdapter = new MeiziAdapter(this.getApplicationContext(), data);
                mRecyclerMm.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                mRecyclerMm.setAdapter(mAdapter);
                go1();
                break;
            case R.id.action_listview:
                mAdapter0 = new MeiziAdapter0(this.getApplicationContext(), data0);
                mRecyclerMm.setLayoutManager(new LinearLayoutManager(this));
                mRecyclerMm.setAdapter(mAdapter0);
                go();
                break;
            case R.id.action_gridview:
                mAdapter0 = new MeiziAdapter0(this.getApplicationContext(), data0);
                mRecyclerMm.setLayoutManager(new GridLayoutManager(this, 3));
                mRecyclerMm.setAdapter(mAdapter0);
                go();
                break;
            case R.id.action_hor_gridview:
                mAdapter0 = new MeiziAdapter0(this.getApplicationContext(), data0);
                mRecyclerMm.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL));
                mRecyclerMm.setAdapter(mAdapter0);
                go();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initData0() {
        String[] aa = new String[]{
                "http://img.my.csdn.net/uploads/201309/01/1378037235_3453.jpg",
                "http://img.my.csdn.net/uploads/201309/01/1378037235_7476.jpg",
                "http://img.my.csdn.net/uploads/201309/01/1378037235_9280.jpg",
                "http://img.my.csdn.net/uploads/201309/01/1378037234_3539.jpg",
                "http://img.my.csdn.net/uploads/201309/01/1378037234_6318.jpg",
                "http://img.my.csdn.net/uploads/201309/01/1378037194_2965.jpg",
                "http://img.my.csdn.net/uploads/201309/01/1378037193_1687.jpg",
                "http://img.my.csdn.net/uploads/201309/01/1378037193_1286.jpg",
                "http://img.my.csdn.net/uploads/201309/01/1378037192_8379.jpg",
                "http://img.my.csdn.net/uploads/201309/01/1378037178_9374.jpg",
                "http://img.my.csdn.net/uploads/201309/01/1378037177_1254.jpg",
                "http://img.my.csdn.net/uploads/201308/31/1377949480_4490.jpg",
                "http://img.my.csdn.net/uploads/201308/31/1377949455_6792.jpg",
                "http://img.my.csdn.net/uploads/201308/31/1377949455_6345.jpg",
                "http://img.my.csdn.net/uploads/201308/31/1377949442_4553.jpg",
                "http://img.my.csdn.net/uploads/201308/31/1377949441_8987.jpg",
                "http://img.my.csdn.net/uploads/201308/31/1377949441_5454.jpg",
                "http://img.my.csdn.net/uploads/201308/31/1377949454_6367.jpg",
                "http://img.my.csdn.net/uploads/201308/31/1377949442_4562.jpg"};
        for(int j=0;j<2;j++){
            for(int i=0;i<aa.length;i++){
                data0.add(aa[i]);
            }
        }
    }

    private void initData() {
        String json1 = "{\n" +
                "  \"error\": false, \n" +
                "  \"results\": [\n" +
                "    {\n" +
                "      \"_id\": \"5907cf57421aa90c7d49ad19\", \n" +
                "      \"createdAt\": \"2017-05-02T08:14:15.561Z\", \n" +
                "      \"desc\": \"5-2\", \n" +
                "      \"publishedAt\": \"2017-05-02T12:00:17.802Z\", \n" +
                "      \"source\": \"chrome\", \n" +
                "      \"type\": \"\\u798f\\u5229\", \n" +
                "      \"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493748634970&di=1f5cc70d77180e4d02b7dbdc156ff53d&imgtype=0&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2015%2F285%2F38%2F0E743HD5TJJP.jpg\", \n" +
                "      \"used\": true, \n" +
                "      \"who\": \"daimajia\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        String json2 = "{\n" +
                "  \"error\": false, \n" +
                "  \"results\": [\n" +
                "    {\n" +
                "      \"_id\": \"59029242421aa9544ed889ff\", \n" +
                "      \"createdAt\": \"2017-04-28T08:52:18.878Z\", \n" +
                "      \"desc\": \"4-28\", \n" +
                "      \"publishedAt\": \"2017-04-28T11:49:38.12Z\", \n" +
                "      \"source\": \"chrome\", \n" +
                "      \"type\": \"\\u798f\\u5229\", \n" +
                "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-28-18094719_120129648541065_8356500748640452608_n.jpg\", \n" +
                "      \"used\": true, \n" +
                "      \"who\": \"daimajia\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        String json3 = "{\n" +
                "  \"error\": false, \n" +
                "  \"results\": [\n" +
                "    {\n" +
                "      \"_id\": \"59013b1a421aa9544b774088\", \n" +
                "      \"createdAt\": \"2017-04-27T08:28:10.755Z\", \n" +
                "      \"desc\": \"4-27\", \n" +
                "      \"publishedAt\": \"2017-04-27T13:16:46.955Z\", \n" +
                "      \"source\": \"chrome\", \n" +
                "      \"type\": \"\\u798f\\u5229\", \n" +
                "      \"url\": \"http://opaqcw6az.bkt.clouddn.com/icon.jpg\", \n" +
                "      \"used\": true, \n" +
                "      \"who\": \"daimajia\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        String json4 = "{\n" +
                "  \"error\": false, \n" +
                "  \"results\": [\n" +
                "    {\n" +
                "      \"_id\": \"58ffe1b5421aa9544ed889e6\", \n" +
                "      \"createdAt\": \"2017-04-26T07:54:29.874Z\", \n" +
                "      \"desc\": \"4-26\", \n" +
                "      \"publishedAt\": \"2017-04-26T11:30:43.767Z\", \n" +
                "      \"source\": \"chrome\", \n" +
                "      \"type\": \"\\u798f\\u5229\", \n" +
                "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-25-13651793_897557617014845_571817176_n.jpg\", \n" +
                "      \"used\": true, \n" +
                "      \"who\": \"daimajia\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        String json5 = "{\n" +
                "  \"error\": false, \n" +
                "  \"results\": [\n" +
                "    {\n" +
                "      \"_id\": \"58fe8e05421aa9544b77406d\", \n" +
                "      \"createdAt\": \"2017-04-25T07:45:09.55Z\", \n" +
                "      \"desc\": \"4-25\", \n" +
                "      \"publishedAt\": \"2017-04-25T13:11:39.357Z\", \n" +
                "      \"source\": \"chrome\", \n" +
                "      \"type\": \"\\u798f\\u5229\", \n" +
                "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-24-18013547_1532023163498554_215541963087151104_n.jpg\", \n" +
                "      \"used\": true, \n" +
                "      \"who\": \"dmj\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        String json6 = "{\n" +
                "  \"error\": false, \n" +
                "  \"results\": [\n" +
                "    {\n" +
                "      \"_id\": \"30\", \n" +
                "      \"createdAt\": \"2017-04-25T07:45:09.55Z\", \n" +
                "      \"desc\": \"4-25\", \n" +
                "      \"publishedAt\": \"2017-04-25T13:11:39.357Z\", \n" +
                "      \"source\": \"chrome\", \n" +
                "      \"type\": \"\\u798f\\u5229\", \n" +
                "      \"url\": \"http://img.blog.csdn.net/20140814135951252?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaGFydmljODgwOTI1/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center\", \n" +
                "      \"used\": true, \n" +
                "      \"who\": \"dmj\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

//                {"id":30,"name":"CSS\u672a\u6765","picSmall":"http:\/\/img.mukewang.com\/54c87c73000150cf06000338-300-170.jpg","picBig":"http:\/\/img.mukewang.com\/54c87c73000150cf06000338.jpg","description":"CSS\u4e4b\u7236Bert Bos\u5e26\u6765\u7684\u5206\u4eab\u3002","learner":13436}],"msg":"\u6210\u529f"}

        String[] pic = new String[]{json1, json2, json3, json4, json5, json6};
        for (int i = 0; i < 40; i++) {
            Gson gson = new Gson();
            int x = (int) (Math.random() * 6);
            Meizi meizi = gson.fromJson(pic[x], Meizi.class);
            data.add(meizi);
        }
    }

    public void go() {

        mAdapter0.setOnItemClickListener(new MeiziAdapter0.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Toast.makeText(RecyclerGlideActivity.this,"ddd",Toast.LENGTH_SHORT).show();
                //设置缩放动画
                final ScaleAnimation animation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration(500);
                animation.setFillAfter(true);
                view.setAnimation(animation);
                Intent intent = new Intent(RecyclerGlideActivity.this, PicActivity.class);
                intent.putExtra(EXTRA_POS, position);

                startActivity(intent);

                //延迟跳转
//                Timer time=new Timer();
//                TimerTask tk=new TimerTask(){
//                    @Override
//                    public void run(){
//                        startActivity(intent);
//                        finish();
//                    }
//                };time.schedule(tk,2000);
            }
        });
    }

    public void go1() {

        mAdapter.setOnItemClickListener(new MeiziAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Toast.makeText(RecyclerGlideActivity.this,"ddd",Toast.LENGTH_SHORT).show();
                //设置缩放动画
                final ScaleAnimation animation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration(500);
                animation.setFillAfter(true);
                view.setAnimation(animation);
                Intent intent = new Intent(RecyclerGlideActivity.this, PicActivity.class);
                intent.putExtra(EXTRA_POS, position);

                startActivity(intent);

            }
        });
    }

}
