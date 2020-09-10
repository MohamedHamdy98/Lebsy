package com.momoandroid.lebsy.view.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.momoandroid.lebsy.models.ItemCategories;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends ViewModel {
    public MutableLiveData<List<ItemCategories>> mutableLiveData = new MutableLiveData<>();
    private List<ItemCategories> itemCategories;
    public void getDataItemCategories(){
        Single<List<ItemCategories>> single = Single.just(itemCategories);
        single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<ItemCategories>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<ItemCategories> itemCategories) {
                        mutableLiveData.setValue(itemCategories);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}