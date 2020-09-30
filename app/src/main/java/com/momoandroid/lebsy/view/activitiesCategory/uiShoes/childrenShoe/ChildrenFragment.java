package com.momoandroid.lebsy.view.activitiesCategory.uiShoes.childrenShoe;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.momoandroid.lebsy.R;
import com.momoandroid.lebsy.adapters.MyAdapterItemCategories;
import com.momoandroid.lebsy.databinding.ChildrenFragmentBinding;
import com.momoandroid.lebsy.models.ItemCategories;

public class ChildrenFragment extends Fragment {
    private ChildrenFragmentBinding binding;
    private ChildrenViewModel mViewModel;
    private MyAdapterItemCategories myAdapterItemCategories;
    public static ChildrenFragment newInstance() {
        return new ChildrenFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.children_fragment, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ChildrenViewModel.class);
        mViewModel.getDataByRxJava();
        binding.recyclerViewShoesChildren.setNestedScrollingEnabled(true);
        binding.recyclerViewShoesChildren.setHasFixedSize(true);
        binding.recyclerViewShoesChildren.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        myAdapterItemCategories = new MyAdapterItemCategories();
        binding.recyclerViewShoesChildren.setAdapter(myAdapterItemCategories);
        mViewModel.mutableLiveData.observe(getActivity(),
                itemCategories -> myAdapterItemCategories.setList(itemCategories));
    }

}