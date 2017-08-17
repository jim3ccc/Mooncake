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

        Toast toast = new Mooncake.MooncakeBuilder(this, "hello", Toast.LENGTH_SHORT).backgroundColor(0xFFD7A3D1).build();
        toast.show();

        Mooncake.success(this, "hello2", Toast.LENGTH_SHORT).show();
    }
}
