package com.meeej.chiangj.moon_cake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.meeej.chiangj.mooncake.Mooncake;


public class MainActivity extends AppCompatActivity {

    private Button mShowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowButton = (Button)findViewById(R.id.button_show);
        mShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mooncake.custom(MainActivity.this, "#EE82EE", "birthday-gift.json", Mooncake.ImageType.LOTTIE, true, Mooncake.DURATION_SHORT).show();
            }
        });
    }
}
