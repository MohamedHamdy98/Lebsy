package com.momoandroid.lebsy.view.activitiesCategory.uiShoes.womanShoe;

import android.util.Log;

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
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

public class WomanShoesViewModel extends ViewModel {
    public MutableLiveData<List<ItemCategories>> mutableLiveData = new MutableLiveData<>();
    private List<ItemCategories> categoriesArrayList = new ArrayList<>();

    public void getDataByRxJava() {
        Observable<List<ItemCategories>> observable = Observable.fromArray(categoriesArrayList)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
        Observer<List<ItemCategories>> observer = new Observer<List<ItemCategories>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<ItemCategories> itemCategories) {
                getDataFromFirebase().setValue(itemCategories);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Beauty Error: " + e);
            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);
    }

    public MutableLiveData<List<ItemCategories>> getDataFromFirebase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Shoes").child("Woman");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
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