package com.momoandroid.lebsy.view.activitiesCategory.uiShoes.manShoe;

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
import com.momoandroid.lebsy.databinding.ManFragmentBinding;
import com.momoandroid.lebsy.models.ItemCategories;

public class ManShoesFragment extends Fragment {
    private ManFragmentBinding binding;
    private ManShoesViewModel mViewModel;
    private MyAdapterItemCategories myAdapterItemCategories;
    public static ManShoesFragment newInstance() {
        return new ManShoesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.man_fragment, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ManShoesViewModel.class);
        mViewModel.getDataByRxJava();
        binding.recyclerViewShoesMan.setNestedScrollingEnabled(true);
        binding.recyclerViewShoesMan.setHasFixedSize(true);
        binding.recyclerViewShoesMan.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        myAdapterItemCategories = new MyAdapterItemCategories();
        binding.recyclerViewShoesMan.setAdapter(myAdapterItemCategories);
        mViewModel.mutableLiveData.observe(getActivity(),
                itemCategories -> myAdapterItemCategories.setList(itemCategories));
    }

}