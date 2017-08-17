package com.meeej.chiangj.moon_cake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.meeej.chiangj.mooncake.Mooncake;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mooncake.custom(this, "#D7A3D1").show();

        Mooncake.success(this, "hello2", Toast.LENGTH_SHORT).show();
    }
}
