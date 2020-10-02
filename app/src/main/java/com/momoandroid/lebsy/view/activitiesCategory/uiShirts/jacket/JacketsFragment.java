package com.momoandroid.lebsy.view.activitiesCategory.uiShirts.jacket;

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
import com.momoandroid.lebsy.databinding.JacketsFragmentBinding;
import com.momoandroid.lebsy.models.ItemCategories;

public class JacketsFragment extends Fragment {

    private JacketsFragmentBinding binding;
    private MyAdapterItemCategories myAdapterItemCategories;
    private JacketsViewModel mViewModel;

    public static JacketsFragment newInstance() {
        return new JacketsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.jackets_fragment, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(JacketsViewModel.class);
        // TODO: Use the ViewModel
        mViewModel.getDataByRxJava();
        binding.recyclerViewShirtsJackets.setNestedScrollingEnabled(true);
        binding.recyclerViewShirtsJackets.setHasFixedSize(true);
        binding.recyclerViewShirtsJackets.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        myAdapterItemCategories = new MyAdapterItemCategories();
        binding.recyclerViewShirtsJackets.setAdapter(myAdapterItemCategories);
        mViewModel.mutableLiveData.observe(getActivity(),
                itemCategories -> myAdapterItemCategories.setList(itemCategories));
    }

}