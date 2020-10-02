package com.momoandroid.lebsy.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
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
import com.momoandroid.lebsy.view.uiBottomNavigation.cart.CartFragment;

import java.util.HashMap;
import java.util.Objects;

public class ItemActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityItemBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_item);
        binding.textViewNameItemCategories.setText(Objects.requireNonNull(getIntent().getExtras()).getString("name"));
        binding.textViewPriceItemCategories.setText(getIntent().getExtras().getString("price"));
        ItemCategories itemCategories = new ItemCategories();
        binding.setItem(itemCategories);
        HandlerItemActivity handlerItemActivity = new HandlerItemActivity(binding.editTextSizeItemActivity,
                binding.editTextNumberItemActivity);
        binding.setOnClick(handlerItemActivity);
        binding.imageViewBlackColor.setOnClickListener(this);
        binding.imageViewUseblackColor.setOnClickListener(this);
        binding.imageViewGrayColor.setOnClickListener(this);
        binding.imageViewUsegrayColor.setOnClickListener(this);
        binding.imageViewWhiteColor.setOnClickListener(this);
        binding.imageViewUsewhiteColor.setOnClickListener(this);
        binding.imageViewPinkColor.setOnClickListener(this);
        binding.imageViewUsepinkColor.setOnClickListener(this);
        binding.imageViewOrangeColor.setOnClickListener(this);
        binding.imageViewUseorangeColor.setOnClickListener(this);
        gotoBack();
    }

    private void gotoBack() {
        binding.iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onClick(View v) {
        String name = Objects.requireNonNull(getIntent().getExtras()).getString("name");
        String uid = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                .getReference("Cart").child(uid).child("Order").child(name);
        HashMap<String, Object> hashMap = new HashMap<>();
        switch (v.getId()) {
            case R.id.imageView_black_color:
                binding.imageViewBlackColor.setVisibility(View.GONE);
                binding.imageViewUseblackColor.setVisibility(View.VISIBLE);
                binding.imageViewUseorangeColor.setVisibility(View.GONE);
                binding.imageViewUsepinkColor.setVisibility(View.GONE);
                binding.imageViewUsewhiteColor.setVisibility(View.GONE);
                binding.imageViewUsegrayColor.setVisibility(View.GONE);
                binding.imageViewOrangeColor.setVisibility(View.VISIBLE);
                binding.imageViewPinkColor.setVisibility(View.VISIBLE);
                binding.imageViewWhiteColor.setVisibility(View.VISIBLE);
                binding.imageViewGrayColor.setVisibility(View.VISIBLE);
                String black = "black";
                hashMap.put("colorItem", black);
                databaseReference.updateChildren(hashMap);
                break;
            case R.id.imageView_useblack_color:
                binding.imageViewBlackColor.setVisibility(View.VISIBLE);
                binding.imageViewUseblackColor.setVisibility(View.GONE);
                databaseReference.child("colorItem").removeValue();
                break;
            case R.id.imageView_orange_color:
                binding.imageViewOrangeColor.setVisibility(View.GONE);
                binding.imageViewUseorangeColor.setVisibility(View.VISIBLE);
                binding.imageViewUseblackColor.setVisibility(View.GONE);
                binding.imageViewUsepinkColor.setVisibility(View.GONE);
                binding.imageViewUsewhiteColor.setVisibility(View.GONE);
                binding.imageViewUsegrayColor.setVisibility(View.GONE);
                binding.imageViewBlackColor.setVisibility(View.VISIBLE);
                binding.imageViewPinkColor.setVisibility(View.VISIBLE);
                binding.imageViewWhiteColor.setVisibility(View.VISIBLE);
                binding.imageViewGrayColor.setVisibility(View.VISIBLE);
                String orange = "orange";
                hashMap.put("colorItem", orange);
                databaseReference.updateChildren(hashMap);
                break;
            case R.id.imageView_useorange_color:
                binding.imageViewOrangeColor.setVisibility(View.VISIBLE);
                binding.imageViewUseorangeColor.setVisibility(View.GONE);
                databaseReference.child("colorItem").removeValue();
                break;
            case R.id.imageView_white_color:
                binding.imageViewWhiteColor.setVisibility(View.GONE);
                binding.imageViewUsewhiteColor.setVisibility(View.VISIBLE);
                binding.imageViewUseblackColor.setVisibility(View.GONE);
                binding.imageViewUsepinkColor.setVisibility(View.GONE);
                binding.imageViewUseorangeColor.setVisibility(View.GONE);
                binding.imageViewUsegrayColor.setVisibility(View.GONE);
                binding.imageViewBlackColor.setVisibility(View.VISIBLE);
                binding.imageViewPinkColor.setVisibility(View.VISIBLE);
                binding.imageViewOrangeColor.setVisibility(View.VISIBLE);
                binding.imageViewGrayColor.setVisibility(View.VISIBLE);
                String white = "white";
                hashMap.put("colorItem", white);
                databaseReference.updateChildren(hashMap);
                break;
            case R.id.imageView_usewhite_color:
                binding.imageViewWhiteColor.setVisibility(View.VISIBLE);
                binding.imageViewUsewhiteColor.setVisibility(View.GONE);
                databaseReference.child("colorItem").removeValue();
                break;
            case R.id.imageView_pink_color:
                binding.imageViewPinkColor.setVisibility(View.GONE);
                binding.imageViewUsepinkColor.setVisibility(View.VISIBLE);
                binding.imageViewUseblackColor.setVisibility(View.GONE);
                binding.imageViewUsewhiteColor.setVisibility(View.GONE);
                binding.imageViewUseorangeColor.setVisibility(View.GONE);
                binding.imageViewUsegrayColor.setVisibility(View.GONE);
                binding.imageViewBlackColor.setVisibility(View.VISIBLE);
                binding.imageViewWhiteColor.setVisibility(View.VISIBLE);
                binding.imageViewOrangeColor.setVisibility(View.VISIBLE);
                binding.imageViewGrayColor.setVisibility(View.VISIBLE);
                String pink = "pink";
                hashMap.put("colorItem", pink);
                databaseReference.updateChildren(hashMap);
                break;
            case R.id.imageView_usepink_color:
                binding.imageViewPinkColor.setVisibility(View.VISIBLE);
                binding.imageViewUsepinkColor.setVisibility(View.GONE);
                databaseReference.child("colorItem").removeValue();
                break;
            case R.id.imageView_gray_color:
                binding.imageViewGrayColor.setVisibility(View.GONE);
                binding.imageViewUsegrayColor.setVisibility(View.VISIBLE);
                binding.imageViewUseblackColor.setVisibility(View.GONE);
                binding.imageViewUsewhiteColor.setVisibility(View.GONE);
                binding.imageViewUseorangeColor.setVisibility(View.GONE);
                binding.imageViewUsepinkColor.setVisibility(View.GONE);
                binding.imageViewBlackColor.setVisibility(View.VISIBLE);
                binding.imageViewWhiteColor.setVisibility(View.VISIBLE);
                binding.imageViewOrangeColor.setVisibility(View.VISIBLE);
                binding.imageViewPinkColor.setVisibility(View.VISIBLE);
                String gray = "gray";
                hashMap.put("colorItem", gray);
                databaseReference.updateChildren(hashMap);
                break;
            case R.id.imageView_usegray_color:
                binding.imageViewGrayColor.setVisibility(View.VISIBLE);
                binding.imageViewUsegrayColor.setVisibility(View.GONE);
                databaseReference.child("colorItem").removeValue();
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
            DatabaseReference databaseReference = FirebaseDatabase.
                    getInstance().getReference("Cart").child(uid).child("Order").child(name);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("sizeItem", size);
            hashMap.put("numberItem", number);
            hashMap.put("nameItem", name);
            hashMap.put("priceItem", price);
            databaseReference.updateChildren(hashMap);
        }
    }
}