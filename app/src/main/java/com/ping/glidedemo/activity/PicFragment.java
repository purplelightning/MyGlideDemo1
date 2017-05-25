package com.ping.glidedemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.ping.glidedemo.R;
import com.ping.glidedemo.beans.Meizi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ss on 2017/5/21.
 */

public class PicFragment extends Fragment {

    private static final String ARG_POS="position";

    private List<Meizi> mData;
    private List<Meizi> data = new ArrayList<>();
    private int pos;
    private ImageView mImageView;

    public static PicFragment newInstance(int pos){
        Bundle args=new Bundle();
        args.putSerializable(ARG_POS,pos);

        PicFragment fragment=new PicFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData = new ArrayList<>();
        initData();
//        int pos=(int) getActivity().getIntent().getSerializableExtra(RecyclerGlideActivity.EXTRA_POS);
        int position=(int) getArguments().getSerializable(ARG_POS);
        String url = mData.get(position).getResults().get(0).getUrl();


        Glide.with(this).load(url).into(mImageView);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState){
        View v=inflater.inflate(R.layout.fragment_pic,parent,false);

        mImageView=(ImageView) v.findViewById(R.id.image_full);

        return v;
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
                "      \"url\": \"http://img.mukewang.com/54c87c73000150cf06000338-300-170.jpg\", \n" +
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

}
