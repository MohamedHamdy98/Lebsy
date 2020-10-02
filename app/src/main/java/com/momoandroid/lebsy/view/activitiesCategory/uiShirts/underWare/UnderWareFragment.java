package com.momoandroid.lebsy.view.activitiesCategory.uiShirts.underWare;

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
import com.momoandroid.lebsy.databinding.UnderWareFragmentBinding;
import com.momoandroid.lebsy.models.ItemCategories;

public class UnderWareFragment extends Fragment {

    private MyAdapterItemCategories myAdapterItemCategories;
    private UnderWareFragmentBinding binding;
    private UnderWareViewModel mViewModel;

    public static UnderWareFragment newInstance() {
        return new UnderWareFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.under_ware_fragment, container, false);
        View root = binding.getRoot();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Apparel").child("UnderWare");
        ItemCategories underWare = new ItemCategories("UnderWare", "default", "80$");
        myRef.child("underWare").setValue(underWare);
        return root;    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(UnderWareViewModel.class);
        // TODO: Use the ViewModel
        mViewModel.getDataByRxJava();
        binding.recyclerViewShirtsUnderWare.setNestedScrollingEnabled(true);
        binding.recyclerViewShirtsUnderWare.setHasFixedSize(true);
        binding.recyclerViewShirtsUnderWare.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        myAdapterItemCategories = new MyAdapterItemCategories();
        binding.recyclerViewShirtsUnderWare.setAdapter(myAdapterItemCategories);
        mViewModel.mutableLiveData.observe(getActivity(),
                itemCategories -> myAdapterItemCategories.setList(itemCategories));
    }

}