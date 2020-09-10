package com.momoandroid.lebsy.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import com.momoandroid.lebsy.R;
import com.momoandroid.lebsy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        splashScreen();
    }
    private void splashScreen(){
        AnimationDrawable animation = new AnimationDrawable();
        animation.addFrame(getResources().getDrawable(R.drawable.splash2), 1000);
        animation.addFrame(getResources().getDrawable(R.drawable.splash3), 1000);
        animation.addFrame(getResources().getDrawable(R.drawable.splash4), 1000);
        animation.setOneShot(false);
        binding.imageSplash.setImageDrawable(animation);
        animation.start();
        startActivity(new Intent(MainActivity.this, AuthenticationActivity.class));
    }
}