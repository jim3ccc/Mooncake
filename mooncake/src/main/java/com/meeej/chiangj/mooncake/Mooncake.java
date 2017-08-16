package com.meeej.chiangj.mooncake;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Toast;

public class Mooncake{

    //Preset colors
    public static final int COLOR_DEFAULT = Color.parseColor("#FFFFFF");
    public static final int COLOR_SUCCESS = Color.parseColor("#FFFFFF");
    public static final int COLOR_WARNING = Color.parseColor("#FFFFFF");
    public static final int COLOR_ERROR = Color.parseColor("#FFFFFF");

    //required
    private final Context mContext;
    private final CharSequence mText;
    private final int mDuration;

    //optional
    private Drawable mIcon;
    private int mBackgroundColor;
    private int mFont;
    private int mFontColor;
    private int mBorderWidth;
    private int mBorderColor;
    private View.OnClickListener mOnClickListener;

    private Mooncake(CustomBuilder builder){
        this.mContext = builder.context;
        this.mText = builder.text;
        this.mDuration = builder.duration;
        this.mIcon = builder.icon;
        this.mBackgroundColor = builder.backgroundColor;
        this.mFont = builder.font;
        this.mFontColor = builder.fontColor;
        this.mBorderWidth = builder.borderWidth;
        this.mBorderColor = builder.borderColor;
        this.mOnClickListener = builder.onClickListener;
    }

    //Default
    public static Toast original(Context context, CharSequence text, int duration){
        return null;
    }
    public static Toast original(Context context, CharSequence text, int duration, Drawable icon){
        return null;
    }

    //Success
    public static Toast success(Context context,CharSequence text, int duration){
        return null;
    }
    public static Toast success(Context context,CharSequence text, int duration, Drawable icon){
        return null;
    }

    //Warning
    public static Toast warning(Context context,CharSequence text, int duration){
        return null;
    }
    public static Toast warning(Context context,CharSequence text, int duration, Drawable icon){
        return null;
    }

    //Error
    public static Toast error(Context context,CharSequence text, int duration){
        return null;
    }
    public static Toast error(Context context,CharSequence text, int duration, Drawable icon){
        return null;
    }

    //Custom
    public static Toast custom(Context context, CharSequence text, int duration,
                               Drawable icon,
                               int backgroundcolor,
                               int font,
                               int fontColor,
                               int borderWidth,
                               int borderColor,
                               View.OnClickListener onClickListener){

        //TODO create a new Toast with customizations and return it so that other methods above can use it
        return null;
    }

    //Builder for custom Mooncake
    private static class CustomBuilder{

        //required
        private final Context context;
        private final CharSequence text;
        private final int duration;

        //optional
        private Drawable icon;
        private int backgroundColor;
        private int font;
        private int fontColor;
        private int borderWidth;
        private int borderColor;
        private View.OnClickListener onClickListener;

        public CustomBuilder(Context context, CharSequence text, int duration){
            this.context = context;
            this.text = text;
            this.duration = duration;
        }

        public CustomBuilder icon(Drawable icon){
            this.icon = icon;
            return this;
        }
        public CustomBuilder backgroundColor(int backgroundColor){
            this.backgroundColor = backgroundColor;
            return this;
        }
        public CustomBuilder font(int font){
            this.font = font;
            return this;
        }
        public CustomBuilder fontColor(int fontColor){
            this.fontColor = fontColor;
            return this;
        }
        public CustomBuilder borderWidth(int borderWidth){
            this.borderWidth = borderWidth;
            return this;
        }
        public CustomBuilder borderColor(int borderColor){
            this.borderColor = borderColor;
            return this;
        }
        public CustomBuilder onClickListener(View.OnClickListener onClickListener){
            this.onClickListener = onClickListener;
            return this;
        }

        public Mooncake build(){
            return new Mooncake(this);
        }
    }

}

