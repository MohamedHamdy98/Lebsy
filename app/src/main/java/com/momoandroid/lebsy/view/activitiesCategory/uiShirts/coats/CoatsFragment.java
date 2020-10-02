package com.momoandroid.lebsy.view.activitiesCategory.uiShirts.coats;

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
import com.momoandroid.lebsy.databinding.CoatsFragmentBinding;
import com.momoandroid.lebsy.databinding.ManBeautyFragmentBinding;
import com.momoandroid.lebsy.models.ItemCategories;
import com.momoandroid.lebsy.view.activitiesCategory.uiBeauty.man.ManBeautyViewModel;

public class CoatsFragment extends Fragment {

    private CoatsFragmentBinding binding;
    private MyAdapterItemCategories myAdapterItemCategories;
    private CoatsViewModel mViewModel;

    public static CoatsFragment newInstance() {
        return new CoatsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.coats_fragment, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CoatsViewModel.class);
        mViewModel.getDataByRxJava();
        binding.recyclerViewShirtsCoats.setNestedScrollingEnabled(true);
        binding.recyclerViewShirtsCoats.setHasFixedSize(true);
        binding.recyclerViewShirtsCoats.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        myAdapterItemCategories = new MyAdapterItemCategories();
        binding.recyclerViewShirtsCoats.setAdapter(myAdapterItemCategories);
        mViewModel.mutableLiveData.observe(getActivity(),
                itemCategories -> myAdapterItemCategories.setList(itemCategories));
    }

}