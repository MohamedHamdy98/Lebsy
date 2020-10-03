package com.momoandroid.lebsy.view.uiBottomNavigation.cart;

import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.momoandroid.lebsy.models.ItemCart;
import com.momoandroid.lebsy.models.ItemCategories;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static android.content.ContentValues.TAG;
import static androidx.databinding.library.baseAdapters.BR.numberItem;
import static androidx.databinding.library.baseAdapters.BR.priceItem;

public class CartViewModel extends ViewModel {
    public MutableLiveData<List<ItemCart>> mutableLiveData = new MutableLiveData<>();
    private List<ItemCart> itemCarts = new ArrayList<>();

    public void getDataByRxJava() {
        Observable<List<ItemCart>> observable = Observable.fromArray(itemCarts)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Observer<List<ItemCart>> observer = new Observer<List<ItemCart>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<ItemCart> itemCarts) {
                getDataFromFirebase().setValue(itemCarts);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);
    }

    public MutableLiveData<List<ItemCart>> getDataFromFirebase() {
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Cart").child(uid).child("Order");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    itemCarts.clear();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        ItemCart itemCart = dataSnapshot.getValue(ItemCart.class);
                        itemCarts.add(itemCart);
                        mutableLiveData.setValue(itemCarts);

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return mutableLiveData;
    }

    // To calculate total price and set it in database..
    public void setTotalPrice() {
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference("Cart").child(uid).child("Order");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                 int sum = 0;
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ItemCart itemCart = dataSnapshot.getValue(ItemCart.class);
                    DatabaseReference myRef = FirebaseDatabase.getInstance()
                            .getReference("Cart").child(uid).child("TotalPrice");
                    int total = Integer.parseInt(itemCart.getPriceItem());
                    sum += total;
                    myRef.setValue(String.valueOf(sum));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    public void getTotalPrice(TextView textView){
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference("Cart").child(uid);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String totalPrice = snapshot.child("TotalPrice").getValue(String.class);
                textView.setText(totalPrice);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}