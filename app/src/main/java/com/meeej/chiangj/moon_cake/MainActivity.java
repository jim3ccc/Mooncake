package com.meeej.chiangj.moon_cake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

import com.meeej.chiangj.mooncake.Mooncake;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Mooncake.Ingredients.ingredients().setFontColor("#ecb939");


        Mooncake.Ingredients.ingredients().setFontColor("#a200ff").prepare();
        Mooncake.custom(this, "#D7A3D1").show();

        Mooncake.Ingredients.ingredients().setFontColor("#FFFFFF").setGravity(Gravity.TOP, 0, 0).prepare();
        Mooncake.custom(this, "#ffd4e5").show();

        Mooncake.Ingredients.ingredients().setGravity(Gravity.BOTTOM, 10, 20).prepare();*/
        Mooncake.success(this, false).show();
        Mooncake.warning(this, true).show();


    }
}
