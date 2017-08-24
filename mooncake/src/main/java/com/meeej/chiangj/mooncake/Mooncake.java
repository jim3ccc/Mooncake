package com.meeej.chiangj.mooncake;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class Mooncake extends Toast{

    //Additional Mooncake attributes
    protected static Drawable icon;
    protected static String font;
    protected static String fontColor;
    protected static int borderWidth = -1;
    protected static int borderColor = -1;
    protected static View.OnClickListener onClickListener;
    protected static int lottieView = -1;
    protected static int gravity = -1;
    protected static int xOffset = -1;
    protected static int yOffset = -1;

    //Duration
    public static final int DURATION_SHORT = Toast.LENGTH_SHORT;
    public static final int DURATION_LONG = Toast.LENGTH_LONG;

    //Preset colors
    public static final String LOTUS = "#f4a5b1";
    public static final String GREEN_TEA = "#43BD8D";
    public static final String PINEAPPLE = "#F7C43D";
    public static final String RED_BEAN = "#FF6F69";

    public static enum ImageType{
        ICON,
        LOTTIE
    }

    private Mooncake(Context context){
        super(context);
    }

    //Original
    public static Mooncake original(Context context, ImageType iconOrLottie, boolean hasIconOrAnim){
        return original(context, iconOrLottie, DURATION_SHORT, "original mooncake", hasIconOrAnim);
    }
    public static Mooncake original(Context context, ImageType iconOrLottie, int duration, boolean hasIconOrAnim){
        return original(context, iconOrLottie, duration, "original mooncake", hasIconOrAnim);
    }
    public static Mooncake original(Context context, ImageType iconOrLottie, int duration, CharSequence text, boolean hasIconOrAnim){
        return custom(context, LOTUS, R.drawable.ic_original, iconOrLottie, hasIconOrAnim, text, duration);
    }


    //Success
    public static Mooncake success(Context context, ImageType iconOrLottie, boolean hasIconOrAnim){
        return success(context, iconOrLottie, DURATION_SHORT, "success mooncake", hasIconOrAnim);
    }
    public static Mooncake success(Context context, ImageType iconOrLottie, int duration, boolean hasIconOrAnim){
        return success(context, iconOrLottie, duration, "success mooncake", hasIconOrAnim);
    }
    public static Mooncake success(Context context, ImageType iconOrLottie, int duration, CharSequence text, boolean hasIconOrAnim){
        return custom(context, GREEN_TEA, R.drawable.ic_success, iconOrLottie, hasIconOrAnim, text, duration);
    }


    //Warning
    public static Mooncake warning(Context context, ImageType iconOrLottie, boolean hasIconOrAnim){
        return warning(context, iconOrLottie, DURATION_SHORT, "warning mooncake", hasIconOrAnim);
    }
    public static Mooncake warning(Context context, ImageType iconOrLottie, int duration, boolean hasIconOrAnim){
        return warning(context, iconOrLottie, duration, "warning mooncake", hasIconOrAnim);
    }
    public static Mooncake warning(Context context, ImageType iconOrLottie, int duration, CharSequence text, boolean hasIconOrAnim){
        return custom(context, PINEAPPLE, R.drawable.ic_warning, iconOrLottie, hasIconOrAnim, text, duration);
    }


    //Error
    public static Mooncake error(Context context, ImageType iconOrLottie, boolean hasIconOrAnim){
        return error(context, iconOrLottie, DURATION_SHORT, "error mooncake", hasIconOrAnim);
    }
    public static Mooncake error(Context context, ImageType iconOrLottie, int duration, boolean hasIconOrAnim){
        return error(context, iconOrLottie, duration, "error mooncake", hasIconOrAnim);
    }
    public static Mooncake error(Context context, ImageType iconOrLottie, int duration, CharSequence text, boolean hasIconOrAnim){
        return custom(context, RED_BEAN, R.drawable.ic_error, iconOrLottie, hasIconOrAnim, text, duration);
    }


    //Custom
    public static Mooncake custom(Context context, String backgroundColor, Object viewIdOrJson, ImageType iconOrLottie, boolean hasIconOrAnim){
        return custom(context, backgroundColor,viewIdOrJson, iconOrLottie, hasIconOrAnim, "custom mooncake", DURATION_SHORT);
    }
    public static Mooncake custom(Context context, String backgroundColor, Object viewIdOrJson, ImageType iconOrLottie, boolean hasIconOrAnim, int duration){
        return custom(context, backgroundColor, viewIdOrJson, iconOrLottie, hasIconOrAnim, "custom mooncake", duration);
    }
    public static Mooncake custom(Context context, String backgroundColor, Object viewIdOrJson, ImageType iconOrLottie, boolean hasIconOrAnim, CharSequence text){
        return custom(context, backgroundColor, viewIdOrJson, iconOrLottie, hasIconOrAnim, text, DURATION_SHORT);
    }
    public static Mooncake custom(Context context, String backgroundColor, Object viewIdOrJson, ImageType iconOrLottie, boolean hasIconOrAnim, int duration, CharSequence text){
        return custom(context, backgroundColor, viewIdOrJson, iconOrLottie, hasIconOrAnim, text, duration);
    }
    public static Mooncake custom(Context context, String backgroundColor,
                                  Object viewIdOrJson, ImageType iconOrLottie,
                                  boolean hasIconOrAnim,
                                      CharSequence text, int duration){


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mooncakeLayout = inflater.inflate(R.layout.mooncake_layout, null);
        TextView mooncakeText = mooncakeLayout.findViewById(R.id.mooncake_text);
        LottieAnimationView mooncakeLottieAnimationView = mooncakeLayout.findViewById(R.id.mooncake_lottie);
        ImageView mooncakeIcon = mooncakeLayout.findViewById(R.id.mooncake_icon);

        ViewManager viewManager = ((ViewManager)(mooncakeLayout.findViewById(R.id.mooncake_root).getRootView()));
        Drawable frame;
        NinePatchDrawable ninePatchDrawable;

        //instance
        final Mooncake mooncake = new Mooncake(context);

        //background
        frame = MooncakeMoulder.colorDrawableFrame(context, Color.parseColor(backgroundColor));
        MooncakeMoulder.setBackground(mooncakeLayout, frame);

        //icon / anim
        if(hasIconOrAnim){
            if(iconOrLottie.equals(ImageType.ICON)){
                //icon
                MooncakeMoulder.removeView(mooncakeLottieAnimationView);
                mooncakeIcon.setBackgroundResource((int)viewIdOrJson);

            }else if(iconOrLottie.equals(ImageType.LOTTIE)){
                //lottie
                MooncakeMoulder.removeView(mooncakeIcon);
                mooncakeLottieAnimationView.setAnimation((String)viewIdOrJson);
                mooncakeLottieAnimationView.playAnimation();
                mooncakeLottieAnimationView.setScale(2.0f);
            }
        }else {
            MooncakeMoulder.removeView(mooncakeLottieAnimationView);
            MooncakeMoulder.removeView(mooncakeIcon);
        }

        //text
        mooncakeText.setText(text);


        /*====================Below are attributes that need to be set using setters====================*/

        //textColor
        if(Mooncake.fontColor != null){
            mooncakeText.setTextColor(Color.parseColor(Mooncake.fontColor));
        }

        //text size

        //gravity
        if(Mooncake.gravity != -1) {
            mooncake.setGravity(Mooncake.gravity, Mooncake.xOffset, Mooncake.yOffset);
        }

        //view
        mooncake.setView(mooncakeLayout);

        //duration
        mooncake.setDuration(duration);

        return mooncake;
    }


}

