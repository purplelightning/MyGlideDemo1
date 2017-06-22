package com.ping.glidedemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ping.glidedemo.R;

import java.util.List;

/**
 * Created by Mr.sorrow on 2017/5/2.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mData;
    private LayoutInflater mInflater;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public ImageAdapter(Context context, List<String> data) {
        mContext = context;
        mData = data;
        mInflater = LayoutInflater.from(context);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //        @BindView(R.id.iv_mm)
        ImageView mIvMm0;
        Context context1;

        public ViewHolder(View view) {
            super(view);
            mIvMm0 = (ImageView) view.findViewById(R.id.iv_mm0);

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
        View view = mInflater.inflate(R.layout.item_image, parent, false);
        ViewHolder holder = new ViewHolder(view);

        holder.context1 = parent.getContext();


        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        //存在记录的高度时先Layout再异步加载图片
//        if (mData.get(holder.getAdapterPosition()).getHeight() > 0) {
//            ViewGroup.LayoutParams layoutParams = holder.mIvMm.getLayoutParams();
//            layoutParams.height = mData.get(holder.getAdapterPosition()).getHeight();
//        }

        WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        final int screenWidth = dm.widthPixels;
        String url = mData.get(position);
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

        if (mListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(holder.itemView, position);
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
