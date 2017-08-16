package com.meeej.chiangj.mooncake;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class Mooncake{

    //Preset colors
    public static final int COLOR_DEFAULT = Color.parseColor("#FFFFFF");
    public static final int COLOR_SUCCESS = Color.parseColor("#43BD8D");
    public static final int COLOR_WARNING = Color.parseColor("#F7C43D");
    public static final int COLOR_ERROR = Color.parseColor("#FF6F69");

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
    private int mLottieView;

    private Mooncake(MooncakeBuilder builder){
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
        this.mLottieView = builder.lottieView;
    }

    //Original
    public static Toast original(Context context, CharSequence text, int duration){
        return original(context, text, duration, (Drawable)null);
    }
    public static Toast original(Context context, CharSequence text, int duration, Drawable icon){
        return custom(new MooncakeBuilder(context, text, duration).backgroundColor(COLOR_DEFAULT).icon(icon));
    }
    public static Toast original(Context context, CharSequence text, int duration, int lottieView){
        return custom(new MooncakeBuilder(context, text, duration).backgroundColor(COLOR_DEFAULT).lottieView(lottieView));
    }

    //Success
    public static Toast success(Context context,CharSequence text, int duration){
        return success(context, text, duration, (Drawable)null);
    }
    public static Toast success(Context context,CharSequence text, int duration, Drawable icon){
        return custom(new MooncakeBuilder(context, text, duration).backgroundColor(COLOR_SUCCESS).icon(icon));
    }
    public static Toast success(Context context, CharSequence text, int duration, int lottieView){
        return custom(new MooncakeBuilder(context, text, duration).backgroundColor(COLOR_DEFAULT).lottieView(lottieView));
    }

    //Warning
    public static Toast warning(Context context,CharSequence text, int duration){
        return warning(context, text, duration, (Drawable)null);
    }
    public static Toast warning(Context context,CharSequence text, int duration, Drawable icon){
        return custom(new MooncakeBuilder(context, text, duration).backgroundColor(COLOR_WARNING).icon(icon));
    }
    public static Toast warning(Context context, CharSequence text, int duration, int lottieView){
        return custom(new MooncakeBuilder(context, text, duration).backgroundColor(COLOR_DEFAULT).lottieView(lottieView));
    }

    //Error
    public static Toast error(Context context,CharSequence text, int duration){
        return error(context, text, duration, (Drawable)null);
    }
    public static Toast error(Context context,CharSequence text, int duration, Drawable icon){
        return custom(new MooncakeBuilder(context, text, duration).backgroundColor(COLOR_ERROR).icon(icon));
    }
    public static Toast error(Context context, CharSequence text, int duration, int lottieView){
        return custom(new MooncakeBuilder(context, text, duration).backgroundColor(COLOR_DEFAULT).lottieView(lottieView));
    }

    //Custom
    public static Toast custom(MooncakeBuilder builder){
        //TODO create a new Toast with customizations and return it so that other methods above can use it
        Toast customToast = new Toast(builder.context);
        customToast.setDuration(builder.duration);
        customToast.setText(builder.text);

        LayoutInflater inflater = (LayoutInflater) builder.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mooncakeLayout = inflater.inflate(R.layout.mooncake_layout, null);
        ImageView mooncakeIcon = mooncakeLayout.findViewById(R.id.mooncake_icon);
        LottieAnimationView mooncakeLottie = mooncakeLayout.findViewById(R.id.mooncake_lottie);
        TextView mooncakeText = mooncakeLayout.findViewById(R.id.mooncake_text);

        mooncakeLayout.setBackgroundColor(builder.backgroundColor);

        return customToast;
    }

    //Builder for custom Mooncake
    private static class MooncakeBuilder {

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
        private int lottieView;

        public MooncakeBuilder(Context context, CharSequence text, int duration){
            this.context = context;
            this.text = text;
            this.duration = duration;
        }

        public MooncakeBuilder icon(Drawable icon){
            this.icon = icon;
            return this;
        }
        public MooncakeBuilder backgroundColor(int backgroundColor){
            this.backgroundColor = backgroundColor;
            return this;
        }
        public MooncakeBuilder font(int font){
            this.font = font;
            return this;
        }
        public MooncakeBuilder fontColor(int fontColor){
            this.fontColor = fontColor;
            return this;
        }
        public MooncakeBuilder borderWidth(int borderWidth){
            this.borderWidth = borderWidth;
            return this;
        }
        public MooncakeBuilder borderColor(int borderColor){
            this.borderColor = borderColor;
            return this;
        }
        public MooncakeBuilder onClickListener(View.OnClickListener onClickListener){
            this.onClickListener = onClickListener;
            return this;
        }
        public MooncakeBuilder lottieView(int lottieView){
            this.lottieView = lottieView;
            return this;
        }

        public Toast build(){
            return Mooncake.custom(this);
        }
    }

}

