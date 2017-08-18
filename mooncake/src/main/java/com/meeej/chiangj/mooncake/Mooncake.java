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
        return custom(context, GREEN_TEA, R.drawable.ic_original, iconOrLottie, hasIconOrAnim, text, duration);
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

        customMooncake = new Mooncake(context);
        customMooncake.setDuration(duration);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mooncakeLayout = inflater.inflate(R.layout.mooncake_layout, null);
        TextView mooncakeText = mooncakeLayout.findViewById(R.id.mooncake_text);
        LottieAnimationView mooncakeLottieAnimationView = mooncakeLayout.findViewById(R.id.mooncake_lottie);
        ImageView mooncakeIcon = mooncakeLayout.findViewById(R.id.mooncake_icon);

        ViewManager viewManager = ((ViewManager)(mooncakeLayout.findViewById(R.id.mooncake_root).getRootView()));
        Drawable frame;
        NinePatchDrawable ninePatchDrawable;

        //background
        frame = colorDrawableFrame(context, Color.parseColor(backgroundColor));
        setBackground(mooncakeLayout, frame);

        //icon / anim
        if(hasIconOrAnim){
            if(iconOrLottie.equals(ImageType.ICON)){
                //icon
                mooncakeLottieAnimationView.setVisibility(View.GONE);
                mooncakeIcon.setBackgroundResource((int)viewIdOrJson);

            }else if(iconOrLottie.equals(ImageType.LOTTIE)){
                //lottie
                mooncakeLottieAnimationView.setAnimation((String)viewIdOrJson);
                mooncakeLottieAnimationView.playAnimation();
                mooncakeIcon.setVisibility(View.GONE);
            }
        }else {
            mooncakeLottieAnimationView.setVisibility(View.GONE);
            mooncakeIcon.setVisibility(View.GONE);
        }

        //textColor
        if(Mooncake.fontColor != null){
            mooncakeText.setTextColor(Color.parseColor(Mooncake.fontColor));
        }

        //text
        mooncakeText.setText(text);

        //text size

        //gravity
        if(Mooncake.gravity != -1) {
            customMooncake.setGravity(Mooncake.gravity, Mooncake.xOffset, Mooncake.yOffset);
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

