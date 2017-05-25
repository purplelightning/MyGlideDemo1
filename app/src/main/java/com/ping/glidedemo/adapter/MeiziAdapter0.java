package com.ping.glidedemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.ping.glidedemo.R;
import com.ping.glidedemo.activity.PicActivity;
import com.ping.glidedemo.activity.RecyclerGlideActivity;
import com.ping.glidedemo.beans.Meizi;
import com.ping.glidedemo.beans.Meizi0;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by Mr.sorrow on 2017/5/2.
 */

public class MeiziAdapter0 extends RecyclerView.Adapter<MeiziAdapter0.ViewHolder>{

    private Context mContext;
    private List<Meizi> mData;
    private LayoutInflater mInflater;

    public interface OnItemClickListener
    {
        void onItemClick(View view,int position);
    }

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        this.mListener=listener;
    }

    public MeiziAdapter0(Context context, List<Meizi> data) {
        mContext = context;
        mData = data;
        mInflater=LayoutInflater.from(context);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //        @BindView(R.id.iv_mm)
        ImageView mIvMm0;
        Context context1;

        public ViewHolder(View view) {
            super(view);
            mIvMm0=(ImageView) view.findViewById(R.id.iv_mm0);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override public void onClick(View itemView) {
//                    if (getAdapterPosition() != RecyclerView.NO_POSITION) {
//                        Context c = itemView.getContext();
//                        //TODO: startActivity or others
//                    }
//                }
//            });


        }
    }

//    @Override
//    public int getItemViewType(int position) {
//        WindowManager windowManager = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
//        DisplayMetrics dm = new DisplayMetrics();
//        Display display = windowManager.getDefaultDisplay();
//        display.getMetrics(dm);
//        final int screenWidth = dm.widthPixels;
//        return Math.round((float) screenWidth / (float) mData.get(position).getHeight() * 10f);
//    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view = mInflater.inflate(R.layout.item_mezi0, parent, false);
        ViewHolder holder=new ViewHolder(view);

        holder.context1=parent.getContext();



        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        //存在记录的高度时先Layout再异步加载图片
//        if (mData.get(holder.getAdapterPosition()).getHeight() > 0) {
//            ViewGroup.LayoutParams layoutParams = holder.mIvMm.getLayoutParams();
//            layoutParams.height = mData.get(holder.getAdapterPosition()).getHeight();
//        }

        WindowManager windowManager = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        final int screenWidth = dm.widthPixels;
//        String url = mData.get(position).getResults().get(0).getUrl();
        String url = mData.get(position).getResults().get(0).getUrl();
//        Glide.with(mContext).load(url).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(new SimpleTarget<Bitmap>
//                        (screenWidth, screenWidth) {
//                    @Override
//                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                        if(holder.getAdapterPosition() != RecyclerView.NO_POSITION) {
//                            if (mData.get(holder.getAdapterPosition()).getHeight() <= 0) {
//                                int width = resource.getWidth();
//                                int height = resource.getHeight();
//                                int realHeight = screenWidth * height / width / 2;
//                                mData.get(holder.getAdapterPosition()).setHeight(realHeight);
//                                ViewGroup.LayoutParams lp = holder.mIvMm.getLayoutParams();
//                                lp.height = realHeight;
//                                if(width < screenWidth / 2)
//                                    lp.width = screenWidth / 2;
//                            }
//                            holder.mIvMm.setImageBitmap(resource);
//                        }
//                    }
//                });
        //直接使用xml的图片设置
        Glide.with(mContext).load(url).into(holder.mIvMm0);

        if(mListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    mListener.onItemClick(holder.itemView,position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
         if (mData == null)
            return 0;
        return mData.size();
    }


}
