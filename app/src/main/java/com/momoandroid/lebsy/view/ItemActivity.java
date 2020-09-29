package com.momoandroid.lebsy.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.momoandroid.lebsy.R;
import com.momoandroid.lebsy.databinding.ActivityItemBinding;
import com.momoandroid.lebsy.models.ItemCategories;
import com.momoandroid.lebsy.view.activitiesCategory.uiBeauty.ui.mainBeauty.SectionsPagerAdapter;

import java.util.HashMap;

public class ItemActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityItemBinding binding;
    private HandlerItemActivity handlerItemActivity;
    private ItemCategories itemCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item);
        binding.textViewNameItemCategories.setText(getIntent().getExtras().getString("name"));
        binding.textViewPriceItemCategories.setText(getIntent().getExtras().getString("price"));
        itemCategories = new ItemCategories();
        binding.setItem(itemCategories);
        handlerItemActivity = new HandlerItemActivity(binding.editTextSizeItemActivity, binding.editTextNumberItemActivity);
        binding.setOnClick(handlerItemActivity);
        binding.imageViewBlackColor.setOnClickListener(this::onClick);
        binding.imageViewUseblackColor.setOnClickListener(this::onClick);
        binding.imageViewGrayColor.setOnClickListener(this::onClick);
        binding.imageViewUsegrayColor.setOnClickListener(this::onClick);
        binding.imageViewWhiteColor.setOnClickListener(this::onClick);
        binding.imageViewUsewhiteColor.setOnClickListener(this::onClick);
        binding.imageViewPinkColor.setOnClickListener(this::onClick);
        binding.imageViewUsepinkColor.setOnClickListener(this::onClick);
        binding.imageViewOrangeColor.setOnClickListener(this::onClick);
        binding.imageViewUseorangeColor.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView_black_color:
                binding.imageViewBlackColor.setVisibility(View.GONE);
                binding.imageViewUseblackColor.setVisibility(View.VISIBLE);
                binding.imageViewUseorangeColor.setVisibility(View.GONE);
                break;
            case R.id.imageView_useblack_color:
                binding.imageViewBlackColor.setVisibility(View.VISIBLE);
                binding.imageViewUseblackColor.setVisibility(View.GONE);
                binding.imageViewUseorangeColor.setVisibility(View.GONE);
                break;
            case R.id.imageView_orange_color:
                binding.imageViewOrangeColor.setVisibility(View.GONE);
                binding.imageViewUseorangeColor.setVisibility(View.VISIBLE);
                binding.imageViewUseblackColor.setVisibility(View.GONE);
                break;
            case R.id.imageView_useorange_color:
                binding.imageViewOrangeColor.setVisibility(View.VISIBLE);
                binding.imageViewUseorangeColor.setVisibility(View.GONE);
                binding.imageViewUseblackColor.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }

    public class HandlerItemActivity {
        private EditText editText_size, editText_number;

        public HandlerItemActivity(EditText editText_size, EditText editText_number) {
            this.editText_size = editText_size;
            this.editText_number = editText_number;
        }

        public void addToCart(View view) {
            String name = getIntent().getExtras().getString("name");
            String price = getIntent().getExtras().getString("price");
            String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
            String size = editText_size.getText().toString();
            String number = editText_number.getText().toString();
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Cart");
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("SizeOfItem", size);
            hashMap.put("NumberOfItem", number);
            hashMap.put("NameOfItem", name);
            hashMap.put("PriceOfItem", price);
            databaseReference.child(uid).child(name).setValue(hashMap);
        }
    }
}