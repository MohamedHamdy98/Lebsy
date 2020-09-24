package com.momoandroid.lebsy.view.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.momoandroid.lebsy.models.ItemCategories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeViewModel extends ViewModel {

    public MutableLiveData<List<ItemCategories>> mutableLiveData = new MutableLiveData<>();
    private static HomeViewModel instance;
    private List<ItemCategories> categoriesArrayList = new ArrayList<>();

   public static HomeViewModel getInstance(){
       if (instance == null){
           synchronized (HomeViewModel.class){
               if (instance == null){
                   instance = new HomeViewModel();
               }
           }
       }
       return instance;
   }

    public MutableLiveData<List<ItemCategories>> getDataFromFirebase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("clothes");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    categoriesArrayList.clear();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        ItemCategories itemCategories = dataSnapshot.getValue(ItemCategories.class);
                        categoriesArrayList.add(itemCategories);
                        mutableLiveData.setValue(categoriesArrayList);
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return mutableLiveData;
    }
}