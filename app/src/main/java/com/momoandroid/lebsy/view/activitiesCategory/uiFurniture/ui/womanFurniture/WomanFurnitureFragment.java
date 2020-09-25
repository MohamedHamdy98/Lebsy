package com.momoandroid.lebsy.view.activitiesCategory.uiFurniture.ui.womanFurniture;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.momoandroid.lebsy.R;

public class WomanFurnitureFragment extends Fragment {

    private WomanFurnitureViewModel mViewModel;

    public static WomanFurnitureFragment newInstance() {
        return new WomanFurnitureFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.woman_furniture_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(WomanFurnitureViewModel.class);
        // TODO: Use the ViewModel
    }

}