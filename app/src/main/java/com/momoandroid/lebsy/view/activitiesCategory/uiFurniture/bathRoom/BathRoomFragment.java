package com.momoandroid.lebsy.view.activitiesCategory.uiFurniture.bathRoom;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.momoandroid.lebsy.R;

public class BathRoomFragment extends Fragment {

    private BathRoomViewModel mViewModel;

    public static BathRoomFragment newInstance() {
        return new BathRoomFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bath_room_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(BathRoomViewModel.class);
        // TODO: Use the ViewModel
    }

}