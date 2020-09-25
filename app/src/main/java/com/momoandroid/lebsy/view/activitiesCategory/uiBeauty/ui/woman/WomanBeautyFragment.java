package com.momoandroid.lebsy.view.activitiesCategory.uiBeauty.ui.woman;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.momoandroid.lebsy.R;

public class WomanBeautyFragment extends Fragment {

    private WomanBeautyViewModel mViewModel;

    public static WomanBeautyFragment newInstance() {
        return new WomanBeautyFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.woman_beauty_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(WomanBeautyViewModel.class);
        // TODO: Use the ViewModel
    }

}