package com.meeej.chiangj.mooncake;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.view.ViewGroup;

public class MooncakeMolder {
    protected static Drawable getDrawable(Context context, @DrawableRes int id){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            return context.getDrawable(R.drawable.toast_frame);
        }else {
            return context.getResources().getDrawable(R.drawable.toast_frame);
        }
    }

    protected static void setBackground(View view, Drawable drawable){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
            view.setBackground(drawable);
        }else{
            view.setBackgroundDrawable(drawable);
        }
    }

    protected static Drawable colorDrawableFrame(Context context, @ColorInt int tintColor) {
        final NinePatchDrawable toastDrawable = (NinePatchDrawable) getDrawable(context, R.drawable.toast_frame);
        return tint(toastDrawable, tintColor);
    }

    protected static Drawable tint(Drawable drawable, @ColorInt int tintColor) {
        drawable.setColorFilter(tintColor, PorterDuff.Mode.SRC_IN);
        return drawable;
    }

    protected static void removeView(View view){
        ((ViewGroup)view.getParent()).removeView(view);
    }
}
