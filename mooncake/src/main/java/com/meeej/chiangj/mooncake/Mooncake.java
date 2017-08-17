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

public class Mooncake{

    //Duration
    public static final int DURATION_SHORT = Toast.LENGTH_SHORT;
    public static final int DURATION_LONG = Toast.LENGTH_LONG;

    //Preset colors
    public static final String LOTUS = "#FFFFFF";
    public static final String GREEN_TEA = "#43BD8D";
    public static final String PINEAPPLE = "#F7C43D";
    public static final String RED_BEAN = "#FF6F69";

    //Original
    public static Toast original(Context context){
        return original(context, "original mooncake", DURATION_SHORT);
    }
    public static Toast original(Context context, int duration){
        return original(context, "original mooncake", duration);
    }
    public static Toast original(Context context, CharSequence text, int duration){
        return custom(context, LOTUS, null, text, duration);
    }


    //Success
    public static Toast success(Context context){
        return success(context, "success mooncake", DURATION_SHORT);
    }
    public static Toast success(Context context, int duration){
        return success(context, "success mooncake", duration);
    }
    public static Toast success(Context context,CharSequence text, int duration){
        return custom(context, GREEN_TEA, null, text, duration);
    }


    //Warning
    public static Toast warning(Context context){
        return warning(context, "warning mooncake", DURATION_SHORT);
    }
    public static Toast warning(Context context, int duration){
        return warning(context, "warning mooncake", duration);
    }
    public static Toast warning(Context context,CharSequence text, int duration){
        return custom(context, PINEAPPLE, null, text, duration);
    }


    //Error
    public static Toast error(Context context){
        return error(context, "error mooncake", DURATION_SHORT);
    }
    public static Toast error(Context context, int duration){
        return error(context, "error mooncake", duration);
    }
    public static Toast error(Context context,CharSequence text, int duration){
        return custom(context, RED_BEAN, null, text, duration);
    }


    //Custom
    public static Toast custom(Context context, String backgroundColor){
        return custom(context, backgroundColor, null, DURATION_SHORT);
    }
    public static Toast custom(Context context, String backgroundColor, int duration){
        return custom(context, backgroundColor, null, duration);
    }
    public static Toast custom(Context context, String backgroundColor, int duration, CharSequence text){
        return custom(context, backgroundColor, null, text, duration);
    }
    public static Toast custom(Context context, String backgroundColor, String tint){
        return custom(context, backgroundColor, tint, DURATION_SHORT);
    }
    public static Toast custom(Context context, String backgroundColor, String tint, int duration){
        return custom(context, backgroundColor, tint, "custom mooncake", duration);
    }
    public static Toast custom(Context context, String backgroundColor, String tint, CharSequence text){
        return custom(context, backgroundColor, tint, text, DURATION_SHORT);
    }
    public static Toast custom(Context context, String backgroundColor, String tint, CharSequence text, int duration){
        Toast customToast = new Toast(context);
        customToast.setDuration(duration);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mooncakeLayout = inflater.inflate(R.layout.mooncake_layout, null);
        ImageView mooncakeIcon = mooncakeLayout.findViewById(R.id.mooncake_icon);
        LottieAnimationView mooncakeLottie = mooncakeLayout.findViewById(R.id.mooncake_lottie);
        TextView mooncakeText = mooncakeLayout.findViewById(R.id.mooncake_text);

        mooncakeText.setText(text);
        mooncakeLayout.setBackgroundColor(Color.parseColor(backgroundColor));
        customToast.setView(mooncakeLayout);


        return customToast;
    }

    //Customize your own Mooncake



}

