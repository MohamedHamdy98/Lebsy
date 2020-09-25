package com.momoandroid.lebsy.view.activitiesCategory.uiFurniture.ui.manFurniture;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.momoandroid.lebsy.R;

public class ManFurnitureFragment extends Fragment {

    private ManFurnitureViewModel mViewModel;

    public static ManFurnitureFragment newInstance() {
        return new ManFurnitureFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.man_furniture_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ManFurnitureViewModel.class);
        // TODO: Use the ViewModel
    }

}