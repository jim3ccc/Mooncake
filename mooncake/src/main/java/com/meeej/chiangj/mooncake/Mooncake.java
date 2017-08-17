package com.meeej.chiangj.mooncake;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.view.LayoutInflater;
import android.view.View;
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
    private static int borderWidth;
    private static int borderColor;
    private static View.OnClickListener onClickListener;
    private static int lottieView;


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
        return custom(context, LOTUS, null, text, duration);
    }


    //Success
    public static Mooncake success(Context context){
        return success(context, "success mooncake", DURATION_SHORT);
    }
    public static Mooncake success(Context context, int duration){
        return success(context, "success mooncake", duration);
    }
    public static Mooncake success(Context context,CharSequence text, int duration){
        return custom(context, GREEN_TEA, null, text, duration);
    }


    //Warning
    public static Mooncake warning(Context context){
        return warning(context, "warning mooncake", DURATION_SHORT);
    }
    public static Mooncake warning(Context context, int duration){
        return warning(context, "warning mooncake", duration);
    }
    public static Mooncake warning(Context context,CharSequence text, int duration){
        return custom(context, PINEAPPLE, null, text, duration);
    }


    //Error
    public static Mooncake error(Context context){
        return error(context, "error mooncake", DURATION_SHORT);
    }
    public static Mooncake error(Context context, int duration){
        return error(context, "error mooncake", duration);
    }
    public static Mooncake error(Context context,CharSequence text, int duration){
        return custom(context, RED_BEAN, null, text, duration);
    }


    //Custom
    public static Mooncake custom(Context context, String backgroundColor){
        return custom(context, backgroundColor, null, DURATION_SHORT);
    }
    public static Mooncake custom(Context context, String backgroundColor, int duration){
        return custom(context, backgroundColor, null, duration);
    }
    public static Mooncake custom(Context context, String backgroundColor, int duration, CharSequence text){
        return custom(context, backgroundColor, null, text, duration);
    }
    public static Mooncake custom(Context context, String backgroundColor, String tint){
        return custom(context, backgroundColor, tint, DURATION_SHORT);
    }
    public static Mooncake custom(Context context, String backgroundColor, String tint, int duration){
        return custom(context, backgroundColor, tint, "custom mooncake", duration);
    }
    public static Mooncake custom(Context context, String backgroundColor, String tint, CharSequence text){
        return custom(context, backgroundColor, tint, text, DURATION_SHORT);
    }
    public static Mooncake custom(Context context, String backgroundColor, String tint, CharSequence text, int duration){
        customMooncake = new Mooncake(context);
        customMooncake.setDuration(duration);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mooncakeLayout = inflater.inflate(R.layout.mooncake_layout, null);
        TextView mooncakeText = mooncakeLayout.findViewById(R.id.mooncake_text);

        mooncakeText.setTextColor(Color.parseColor(Mooncake.fontColor));
        mooncakeText.setText(text);
        mooncakeLayout.setBackgroundColor(Color.parseColor(backgroundColor));
        customMooncake.setView(mooncakeLayout);

        return customMooncake;
    }

    //Ingredients
    public static class Ingredients{

        private static Drawable icon;
        private static String font;
        private static String fontColor;
        private static int borderWidth;
        private static int borderColor;
        private static View.OnClickListener onClickListener;
        private static int lottieView;


        public static void setIcon(Drawable icon) {
            Mooncake.icon = icon;
        }

        public static void setFont(String font) {
            Mooncake.font = font;
        }

        public static void setFontColor(String fontColor) {
            Mooncake.fontColor = fontColor;
        }

        public static void setBorderWidth(int borderWidth) {
            Mooncake.borderWidth = borderWidth;
        }

        public static void setBorderColor(int borderColor) {
            Mooncake.borderColor = borderColor;
        }

        public static void setOnClickListener(View.OnClickListener onClickListener) {
            Mooncake.onClickListener = onClickListener;
        }

        public static void setLottieView(int lottieView) {
            Mooncake.lottieView = lottieView;
        }

        public static void prepare(){
            Mooncake.icon = Ingredients.icon;
            Mooncake.font = Ingredients.font;
            Mooncake.fontColor = Ingredients.fontColor;
            Mooncake.borderWidth = Ingredients.borderWidth;
            Mooncake.borderColor = Ingredients.borderColor;
            Mooncake.onClickListener = Ingredients.onClickListener;
            Mooncake.lottieView = Ingredients.lottieView;
        }
    }


}

