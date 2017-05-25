package com.ping.glidedemo.utils;

import android.content.Context;

/**
 * UI工具类
 * Created by Mr.sorrow on 2017/3/9.
 */

public class UIUtils {

    /**
     * dip ===>> px
     *
     * @param dip
     * @return
     */
    public static int dip2px(Context context, float dip) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dip * density + 0.5f);
    }

    /**
     * px ===>> dip
     *
     * @param px
     * @return
     */
    public static float px2dip(Context context, int px) {
        float density = context.getResources().getDisplayMetrics().density;
        return px / density;
    }
}
