package com.momoandroid.lebsy.view.activitiesCategory.uiShirts.pants;

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
import com.momoandroid.lebsy.models.ItemCategories;

public class PantsFragment extends Fragment {

    private PantsViewModel mViewModel;
    private MyAdapterItemCategories myAdapterItemCategories;
    private PantsFragmentBinding binding;

    public static PantsFragment newInstance() {
        return new PantsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.pants_fragment, container, false);
        View root = binding.getRoot();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Apparel").child("Pants");
        ItemCategories pants = new ItemCategories("Pants", "default", "80$");
        myRef.child("pants").setValue(pants);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PantsViewModel.class);
        // TODO: Use the ViewModel
        mViewModel.getDataByRxJava();
        binding.recyclerViewShirtsPants.setNestedScrollingEnabled(true);
        binding.recyclerViewShirtsPants.setHasFixedSize(true);
        binding.recyclerViewShirtsPants.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        myAdapterItemCategories = new MyAdapterItemCategories();
        binding.recyclerViewShirtsPants.setAdapter(myAdapterItemCategories);
        mViewModel.mutableLiveData.observe(getActivity(),
                itemCategories -> myAdapterItemCategories.setList(itemCategories));
    }

}