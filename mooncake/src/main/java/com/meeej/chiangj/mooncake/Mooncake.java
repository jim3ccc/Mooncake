package com.meeej.chiangj.mooncake;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class Mooncake extends Toast{

    //Global Mooncake
    private static Mooncake customMooncake;

    //Additional Mooncake attributes
    private static Drawable icon;
    private static String font;
    private static String fontColor;
    private static int borderWidth = -1;
    private static int borderColor = -1;
    private static View.OnClickListener onClickListener;
    private static int lottieView = -1;
    private static int gravity = -1;
    private static int xOffset = -1;
    private static int yOffset = -1;


    //Duration
    public static final int DURATION_SHORT = Toast.LENGTH_SHORT;
    public static final int DURATION_LONG = Toast.LENGTH_LONG;

    //Preset colors
    public static final String LOTUS = "#FFFFFF";
    public static final String GREEN_TEA = "#43BD8D";
    public static final String PINEAPPLE = "#F7C43D";
    public static final String RED_BEAN = "#FF6F69";

    private Mooncake(Context context){
        super(context);
    }

    //Original
    public static Mooncake original(Context context){
        return original(context, "original mooncake", DURATION_SHORT);
    }
    public static Mooncake original(Context context, int duration){
        return original(context, "original mooncake", duration);
    }
    public static Mooncake original(Context context, CharSequence text, int duration){
        return custom(context, LOTUS, text, duration);
    }


    //Success
    public static Mooncake success(Context context){
        return success(context, "success mooncake", DURATION_SHORT);
    }
    public static Mooncake success(Context context, int duration){
        return success(context, "success mooncake", duration);
    }
    public static Mooncake success(Context context,CharSequence text, int duration){
        return custom(context, GREEN_TEA, text, duration);
    }


    //Warning
    public static Mooncake warning(Context context){
        return warning(context, "warning mooncake", DURATION_SHORT);
    }
    public static Mooncake warning(Context context, int duration){
        return warning(context, "warning mooncake", duration);
    }
    public static Mooncake warning(Context context,CharSequence text, int duration){
        return custom(context, PINEAPPLE, text, duration);
    }


    //Error
    public static Mooncake error(Context context){
        return error(context, "error mooncake", DURATION_SHORT);
    }
    public static Mooncake error(Context context, int duration){
        return error(context, "error mooncake", duration);
    }
    public static Mooncake error(Context context,CharSequence text, int duration){
        return custom(context, RED_BEAN, text, duration);
    }


    //Custom
    public static Mooncake custom(Context context, String backgroundColor){
        return custom(context, backgroundColor, DURATION_SHORT);
    }
    public static Mooncake custom(Context context, String backgroundColor, int duration){
        return custom(context, backgroundColor, duration, "custom mooncake");
    }
    public static Mooncake custom(Context context, String backgroundColor, CharSequence text){
        return custom(context, backgroundColor, text, DURATION_SHORT);
    }
    public static Mooncake custom(Context context, String backgroundColor, int duration, CharSequence text){
        return custom(context, backgroundColor, text, duration);
    }
    public static Mooncake custom(Context context, String backgroundColor, CharSequence text, int duration){
        customMooncake = new Mooncake(context);
        customMooncake.setDuration(duration);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mooncakeLayout = inflater.inflate(R.layout.mooncake_layout, null);
        TextView mooncakeText = mooncakeLayout.findViewById(R.id.mooncake_text);
        LottieAnimationView mooncakeLottieAnimationView = mooncakeLayout.findViewById(R.id.mooncake_lottie);
        ImageView mooncakeImageView = mooncakeLayout.findViewById(R.id.mooncake_icon);
        ViewManager viewManager = ((ViewManager)(mooncakeLayout.findViewById(R.id.mooncake_root).getRootView()));
        Drawable frame;
        NinePatchDrawable ninePatchDrawable;

        //background
        frame = colorDrawableFrame(context, Color.parseColor(backgroundColor));
        setBackground(mooncakeLayout, frame);

        //TODO set icon, font, fontColor, borderWidth, borderColor, onClickListener, lottieView, gravity

        //textColor
        if(Mooncake.fontColor != null){
            mooncakeText.setTextColor(Color.parseColor(Mooncake.fontColor));
        }

        //text
        mooncakeText.setText(text);

        //text size

        //gravity
        if(Mooncake.gravity != -1){
            customMooncake.setGravity(Mooncake.gravity, Mooncake.xOffset, Mooncake.yOffset);
        }

        //lottie
        if(Mooncake.icon == null){
            viewManager.removeView(mooncakeImageView);
        }

        //icon
        if(Mooncake.lottieView == -1){
            viewManager.removeView(mooncakeLottieAnimationView);
        }

        //view
        customMooncake.setView(mooncakeLayout);

        return customMooncake;
    }

    //Ingredients
    public static class Ingredients{

        private static Ingredients ingredients;

        private Drawable icon = Mooncake.icon;
        private String font = Mooncake.font;
        private String fontColor = Mooncake.fontColor;
        private int borderWidth = Mooncake.borderWidth;
        private int borderColor = Mooncake.borderColor;
        private View.OnClickListener onClickListener = Mooncake.onClickListener;
        private int lottieView = Mooncake.lottieView;
        private int gravity = Mooncake.gravity;
        private int xOffset = Mooncake.xOffset;
        private int yOffset = Mooncake.yOffset;

        private Ingredients(){}

        public static  Ingredients ingredients(){
            if(ingredients == null){
                ingredients = new Ingredients();
            }
            return ingredients;
        }

        public Ingredients setIcon(Drawable icon) {
            this.icon = icon;
            return this;
        }

        public Ingredients setFont(String font) {
            this.font = font;
            return this;
        }

        public Ingredients setFontColor(String fontColor) {
            this.fontColor = fontColor;
            return this;
        }

        public Ingredients setBorderWidth(int borderWidth) {
            this.borderWidth = borderWidth;
            return this;
        }

        public Ingredients setBorderColor(int borderColor) {
            this.borderColor = borderColor;
            return this;
        }

        public Ingredients setOnClickListener(View.OnClickListener onClickListener) {
            this.onClickListener = onClickListener;
            return this;
        }

        public Ingredients setLottieView(int lottieView) {
            this.lottieView = lottieView;
            return this;
        }

        public Ingredients setGravity(int gravity, int xOffset, int yOffset) {
            this.gravity = gravity;
            this.xOffset = xOffset;
            this.yOffset = yOffset;
            return this;
        }

        public void prepare(){
            Mooncake.icon = this.icon;
            Mooncake.font = this.font;
            Mooncake.fontColor = this.fontColor;
            Mooncake.borderWidth = this.borderWidth;
            Mooncake.borderColor = this.borderColor;
            Mooncake.onClickListener = this.onClickListener;
            Mooncake.lottieView = this.lottieView;
            Mooncake.gravity = this.gravity;
            Mooncake.xOffset = this.xOffset;
            Mooncake.yOffset = this.yOffset;
        }
    }

    private static Drawable getDrawable(Context context, @DrawableRes int id){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            return context.getDrawable(R.drawable.toast_frame);
        }else {
            return context.getResources().getDrawable(R.drawable.toast_frame);
        }
    }

    private static void setBackground(View view, Drawable drawable){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
            view.setBackground(drawable);
        }else{
            view.setBackgroundDrawable(drawable);
        }
    }

    private static Drawable colorDrawableFrame(Context context, @ColorInt int tintColor) {
        final NinePatchDrawable toastDrawable = (NinePatchDrawable) getDrawable(context, R.drawable.toast_frame);
        return tint(toastDrawable, tintColor);
    }

    static Drawable tint(Drawable drawable, @ColorInt int tintColor) {
        drawable.setColorFilter(tintColor, PorterDuff.Mode.SRC_IN);
        return drawable;
    }


}

