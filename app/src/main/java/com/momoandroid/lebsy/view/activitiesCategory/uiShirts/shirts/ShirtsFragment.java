package com.momoandroid.lebsy.view.activitiesCategory.uiShirts.shirts;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.momoandroid.lebsy.R;

public class ShirtsFragment extends Fragment {

    private ShirtsViewModel mViewModel;

    public static ShirtsFragment newInstance() {
        return new ShirtsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.shirts_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ShirtsViewModel.class);
        // TODO: Use the ViewModel
    }

}