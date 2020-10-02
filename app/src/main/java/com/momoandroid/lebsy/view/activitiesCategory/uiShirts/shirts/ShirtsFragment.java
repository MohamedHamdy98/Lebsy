package com.momoandroid.lebsy.view.activitiesCategory.uiShirts.shirts;

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
import com.momoandroid.lebsy.databinding.ShirtsFragmentBinding;
import com.momoandroid.lebsy.models.ItemCategories;

public class ShirtsFragment extends Fragment {

    private MyAdapterItemCategories myAdapterItemCategories;
    private ShirtsFragmentBinding binding;
    private ShirtsViewModel mViewModel;

    public static ShirtsFragment newInstance() {
        return new ShirtsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.shirts_fragment, container, false);
        View root = binding.getRoot();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Apparel").child("Shirts");
        ItemCategories shirts = new ItemCategories("Shirts", "default", "80$");
        myRef.child("shirts").setValue(shirts);
        return root;    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ShirtsViewModel.class);
        // TODO: Use the ViewModel
        mViewModel.getDataByRxJava();
        binding.recyclerViewShirts.setNestedScrollingEnabled(true);
        binding.recyclerViewShirts.setHasFixedSize(true);
        binding.recyclerViewShirts.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        myAdapterItemCategories = new MyAdapterItemCategories();
        binding.recyclerViewShirts.setAdapter(myAdapterItemCategories);
        mViewModel.mutableLiveData.observe(getActivity(),
                itemCategories -> myAdapterItemCategories.setList(itemCategories));
    }

}