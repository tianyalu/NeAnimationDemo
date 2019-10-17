package com.sty.ne.animationdemo;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        ObjectAnimator animator = ObjectAnimator.ofFloat(button, "ScaleX", 1f, 2f, 3f, 1f);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(3000);
        animator.start();
    }
}
