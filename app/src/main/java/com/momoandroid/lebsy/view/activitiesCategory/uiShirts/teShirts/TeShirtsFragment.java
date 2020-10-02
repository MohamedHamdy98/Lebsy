package com.momoandroid.lebsy.view.activitiesCategory.uiShirts.teShirts;

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
import com.momoandroid.lebsy.databinding.TeShirtsFragmentBinding;
import com.momoandroid.lebsy.models.ItemCategories;

public class TeShirtsFragment extends Fragment {

    private MyAdapterItemCategories myAdapterItemCategories;
    private TeShirtsFragmentBinding binding;
    private TeShirtsViewModel mViewModel;

    public static TeShirtsFragment newInstance() {
        return new TeShirtsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.te_shirts_fragment, container, false);
        View root = binding.getRoot();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Apparel").child("TeShirts");
        ItemCategories teShirts = new ItemCategories("TeShirts", "default", "80$");
        myRef.child("teShirts").setValue(teShirts);
        return root;    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TeShirtsViewModel.class);
        // TODO: Use the ViewModel
        mViewModel.getDataByRxJava();
        binding.recyclerViewTeShirts.setNestedScrollingEnabled(true);
        binding.recyclerViewTeShirts.setHasFixedSize(true);
        binding.recyclerViewTeShirts.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        myAdapterItemCategories = new MyAdapterItemCategories();
        binding.recyclerViewTeShirts.setAdapter(myAdapterItemCategories);
        mViewModel.mutableLiveData.observe(getActivity(),
                itemCategories -> myAdapterItemCategories.setList(itemCategories));
    }

}