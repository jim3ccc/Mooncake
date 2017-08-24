package com.meeej.chiangj.mooncake;

import android.graphics.drawable.Drawable;
import android.view.View;

public class Ingredients {
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

    public static Ingredients getIngredients(){
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
