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
import com.momoandroid.lebsy.view.activitiesCategory.uiBeauty.ui.mainBeauty.SectionsPagerAdapter;

import java.util.HashMap;

public class ItemActivity extends AppCompatActivity {
    private ActivityItemBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = DataBindingUtil.setContentView(this, R.layout.activity_item);
       binding.textViewNameItemCategories.setText(getIntent().getExtras().getString("name"));
       binding.textViewPriceItemCategories.setText(getIntent().getExtras().getString("price"));
    }
    public class HandlerItemActivity{
        private EditText editText_size, editText_number;

        public HandlerItemActivity(EditText editText_size, EditText editText_number) {
            this.editText_size = editText_size;
            this.editText_number = editText_number;
        }

        public void addToCart(View view){
            String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
            String size = editText_size.getText().toString();
            String number = editText_number.getText().toString();
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Cart");
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("SizeOfItem",size);
            hashMap.put("NumberOfItem",number);
            databaseReference.child(uid).setValue(hashMap);
        }
    }
}