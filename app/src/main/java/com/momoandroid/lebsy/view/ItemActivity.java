package com.momoandroid.lebsy.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.momoandroid.lebsy.R;
import com.momoandroid.lebsy.databinding.ActivityItemBinding;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityItemBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_item);
        binding.t.setText(getIntent().getExtras().getString("name"));
    }
}