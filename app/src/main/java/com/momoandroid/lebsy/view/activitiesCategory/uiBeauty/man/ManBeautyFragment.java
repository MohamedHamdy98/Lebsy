package com.momoandroid.lebsy.view.activitiesCategory.uiBeauty.man;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.momoandroid.lebsy.R;
import com.momoandroid.lebsy.adapters.MyAdapterItemCategories;
import com.momoandroid.lebsy.databinding.ManBeautyFragmentBinding;
import com.momoandroid.lebsy.models.ItemCategories;

public class ManBeautyFragment extends Fragment {
    private ManBeautyFragmentBinding binding;
    private ManBeautyViewModel mViewModel;
    private MyAdapterItemCategories myAdapterItemCategories;

    public static ManBeautyFragment newInstance() {
        return new ManBeautyFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.man_beauty_fragment, container, false);
        View root = binding.getRoot();
        mViewModel = ViewModelProviders.of(this).get(ManBeautyViewModel.class);



//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("Beauty");
//        ItemCategories Gym = new ItemCategories("Gym Shoes","default" ,"80$");
//        ItemCategories Boot = new ItemCategories("Boot", "default" ,"100$");
//        ItemCategories Chair = new ItemCategories("Chair", "default" ,"400$");
//        ItemCategories Shirt1 = new ItemCategories("T-Shirt", "default" ,"85$");
//        ItemCategories Shirt2 = new ItemCategories("T-Shirt", "default" ,"85$");
//        ItemCategories Shirt3 = new ItemCategories("T-Shirt", "default" ,"85$");
//        myRef.child("Gym Shoes").setValue(Gym);
//        myRef.child("Boot").setValue(Boot);
//        myRef.child("Chair").setValue(Chair);
//        myRef.child("T-Shirt1").setValue(Shirt1);
//        myRef.child("T-Shirt2").setValue(Shirt2);
//        myRef.child("T-Shirt3").setValue(Shirt3);


        mViewModel.getDataByRxJava();
        binding.recyclerViewBeautyMan.setNestedScrollingEnabled(true);
        binding.recyclerViewBeautyMan.setHasFixedSize(true);
        binding.recyclerViewBeautyMan.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        myAdapterItemCategories = new MyAdapterItemCategories();
        binding.recyclerViewBeautyMan.setAdapter(myAdapterItemCategories);
        mViewModel.mutableLiveData.observe(getActivity(),
                itemCategories -> myAdapterItemCategories.setList(itemCategories));
        return root;
    }
}