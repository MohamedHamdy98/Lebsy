package com.momoandroid.lebsy.view.activitiesCategory.uiFurniture.smallSpace;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.momoandroid.lebsy.R;

public class SmallSpaceFragment extends Fragment {

    private SmallSpaceViewModel mViewModel;

    public static SmallSpaceFragment newInstance() {
        return new SmallSpaceFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.small_space_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SmallSpaceViewModel.class);
        // TODO: Use the ViewModel
    }

}