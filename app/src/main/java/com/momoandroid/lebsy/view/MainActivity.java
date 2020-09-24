package com.momoandroid.lebsy.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.momoandroid.lebsy.R;
import com.momoandroid.lebsy.databinding.ActivityMainBinding;
import com.momoandroid.lebsy.view.main.SignUpFragment;

import java.util.Observable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private static final String TAG = "MainActivity";
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
        startActivity(new Intent(MainActivity.this, CategoriesActivity.class));
    }

}