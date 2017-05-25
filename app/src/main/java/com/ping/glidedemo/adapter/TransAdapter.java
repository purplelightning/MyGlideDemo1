package com.ping.glidedemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.ping.glidedemo.R;
import com.ping.glidedemo.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.ColorFilterTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;
import jp.wasabeef.glide.transformations.CropTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.MaskTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.InvertFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.PixelationFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SwirlFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation;

/**
 * Created by Mr.sorrow on 2017/5/2.
 */

public class TransAdapter extends RecyclerView.Adapter<TransAdapter.TransViewHolder> {

    private Context mContext;
    private List<String> mList = new ArrayList<>();

    public TransAdapter(Context context) {
        mContext = context;
        for (int i = 1; i < 22; i++) {
            mList.add(i + "");
        }
    }

    @Override
    public TransViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_tran, null);
        return new TransViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TransViewHolder holder, int position) {
        int integer = Integer.parseInt(mList.get(position));
        holder.mTvTran.setText("样式"+(position+1));
        switch (integer) {
            //五角星形的外框Mask
            case 1: {
                int width = UIUtils.dip2px(mContext, 133.33f);
                int height = UIUtils.dip2px(mContext, 126.33f);
                Glide.with(mContext)
                        .load(R.drawable.demo)
                        .override(width, height)
                        .bitmapTransform(new CenterCrop(mContext),
                                new MaskTransformation(mContext, R.drawable.mask_starfish))
                        .into(holder.mIvTran);
                break;
            }
            //点9图片的外框Mask
            case 2: {
                int width = UIUtils.dip2px(mContext, 150.0f);
                int height = UIUtils.dip2px(mContext, 100.0f);
                Glide.with(mContext)
                        .load(R.drawable.demo)
                        .override(width, height)
                        .bitmapTransform(new CenterCrop(mContext),
                                new MaskTransformation(mContext, R.drawable.mask_chat_right))
                        .into(holder.mIvTran);
                break;
            }
            //裁剪图片的上方部分区域
            case 3:
                Glide.with(mContext)
                        .load(R.drawable.demo)
                        .bitmapTransform(
                                new CropTransformation(mContext, 300, 100, CropTransformation.CropType.TOP))
                        .into(holder.mIvTran);
                break;
            //裁剪图片的上方100-300区域
            case 4:
                Glide.with(mContext)
                        .load(R.drawable.demo)
                        .bitmapTransform(new CropTransformation(mContext, 300, 100))
                        .into(holder.mIvTran);
                break;
            //裁剪图片的下方部分区域
            case 5:
                Glide.with(mContext)
                        .load(R.drawable.demo)
                        .bitmapTransform(
                                new CropTransformation(mContext, 300, 100, CropTransformation.CropType.BOTTOM))
                        .into(holder.mIvTran);

                break;
            //显示方形图
            case 6:
                Glide.with(mContext)
                        .load(R.drawable.demo)
                        .bitmapTransform(new CropSquareTransformation(mContext))
                        .into(holder.mIvTran);
                break;
            //显示圆形图
            case 7:
                Glide.with(mContext)
                        .load(R.drawable.demo)
                        .bitmapTransform(new CropCircleTransformation(mContext))
                        .into(holder.mIvTran);
                break;
            //彩色滤镜样式
            case 8:
                Glide.with(mContext)
                        .load(R.drawable.demo)
                        .bitmapTransform(new ColorFilterTransformation(mContext, Color.argb(80, 255, 0, 0)))
                        .into(holder.mIvTran);
                break;
            //灰度图
            case 9:
                Glide.with(mContext)
                        .load(R.drawable.demo)
                        .bitmapTransform(new GrayscaleTransformation(mContext))
                        .into(holder.mIvTran);
                break;
            //边框圆角化图片
            case 10:
                Glide.with(mContext)
                        .load(R.drawable.demo)
                        .bitmapTransform(new RoundedCornersTransformation(mContext, 30, 0,
                                RoundedCornersTransformation.CornerType.BOTTOM))
                        .into(holder.mIvTran);
                break;
            //毛玻璃效果
            case 11:
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .bitmapTransform(new BlurTransformation(mContext, 25))
                        .into(holder.mIvTran);
                break;

            case 12:
                Glide.with(mContext)
                        .load(R.drawable.demo)
                        .bitmapTransform(new ToonFilterTransformation(mContext))
                        .into(holder.mIvTran);
                break;
            case 13:
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .bitmapTransform(new SepiaFilterTransformation(mContext))
                        .into(holder.mIvTran);
                break;
            case 14:
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .bitmapTransform(new ContrastFilterTransformation(mContext, 2.0f))
                        .into(holder.mIvTran);
                break;
            case 15:
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .bitmapTransform(new InvertFilterTransformation(mContext))
                        .into(holder.mIvTran);
                break;
            case 16:
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .bitmapTransform(new PixelationFilterTransformation(mContext, 20))
                        .into(holder.mIvTran);
                break;
            case 17:
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .bitmapTransform(new SketchFilterTransformation(mContext))
                        .into(holder.mIvTran);
                break;
            case 18:
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .bitmapTransform(
                                new SwirlFilterTransformation(mContext, 0.5f, 1.0f, new PointF(0.5f, 0.5f)))
                        .into(holder.mIvTran);
                break;
            case 19:
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .bitmapTransform(new BrightnessFilterTransformation(mContext, 0.5f))
                        .into(holder.mIvTran);
                break;
            case 20:
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .bitmapTransform(new KuwaharaFilterTransformation(mContext, 25))
                        .into(holder.mIvTran);
                break;
            case 21:
                Glide.with(mContext)
                        .load(R.drawable.check)
                        .bitmapTransform(new VignetteFilterTransformation(mContext, new PointF(0.5f, 0.5f),
                                new float[] { 0.0f, 0.0f, 0.0f }, 0f, 0.75f))
                        .into(holder.mIvTran);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class TransViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_tran)
        TextView mTvTran;
        @BindView(R.id.iv_tran)
        ImageView mIvTran;

        public TransViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
