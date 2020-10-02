package com.momoandroid.lebsy.view.activitiesCategory.uiShirts.sweaters;

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
import com.momoandroid.lebsy.databinding.PantsFragmentBinding;
import com.momoandroid.lebsy.databinding.SweatersFragmentBinding;
import com.momoandroid.lebsy.models.ItemCategories;

public class SweatersFragment extends Fragment {

    private MyAdapterItemCategories myAdapterItemCategories;
    private SweatersFragmentBinding binding;
    private SweatersViewModel mViewModel;

    public static SweatersFragment newInstance() {
        return new SweatersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.sweaters_fragment, container, false);
        View root = binding.getRoot();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Apparel").child("Sweaters");
        ItemCategories sweaters = new ItemCategories("Sweaters", "default", "80$");
        myRef.child("sweaters").setValue(sweaters);
        return root;    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SweatersViewModel.class);
        // TODO: Use the ViewModel
        mViewModel.getDataByRxJava();
        binding.recyclerViewShirtsSweaters.setNestedScrollingEnabled(true);
        binding.recyclerViewShirtsSweaters.setHasFixedSize(true);
        binding.recyclerViewShirtsSweaters.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        myAdapterItemCategories = new MyAdapterItemCategories();
        binding.recyclerViewShirtsSweaters.setAdapter(myAdapterItemCategories);
        mViewModel.mutableLiveData.observe(getActivity(),
                itemCategories -> myAdapterItemCategories.setList(itemCategories));
    }

}