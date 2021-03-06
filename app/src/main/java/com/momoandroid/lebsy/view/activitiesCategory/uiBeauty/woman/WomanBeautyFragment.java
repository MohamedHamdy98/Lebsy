package com.momoandroid.lebsy.view.activitiesCategory.uiBeauty.woman;

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
import com.momoandroid.lebsy.databinding.WomanBeautyFragmentBinding;
import com.momoandroid.lebsy.models.ItemCategories;

public class WomanBeautyFragment extends Fragment {
    private WomanBeautyFragmentBinding binding;
    private WomanBeautyViewModel mViewModel;
    private MyAdapterItemCategories myAdapterItemCategories;
    public static WomanBeautyFragment newInstance() {
        return new WomanBeautyFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.woman_beauty_fragment, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(WomanBeautyViewModel.class);
        mViewModel.getDataByRxJava();
        binding.recyclerViewBeautyWoman.setNestedScrollingEnabled(true);
        binding.recyclerViewBeautyWoman.setHasFixedSize(true);
        binding.recyclerViewBeautyWoman.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        myAdapterItemCategories = new MyAdapterItemCategories();
        binding.recyclerViewBeautyWoman.setAdapter(myAdapterItemCategories);
        mViewModel.mutableLiveData.observe(getActivity(),
                itemCategories -> myAdapterItemCategories.setList(itemCategories));
    }

}