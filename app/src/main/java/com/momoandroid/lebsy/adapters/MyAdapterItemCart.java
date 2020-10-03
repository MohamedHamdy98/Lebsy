package com.momoandroid.lebsy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.momoandroid.lebsy.R;
import com.momoandroid.lebsy.databinding.RecyclerViewItemCartBinding;
import com.momoandroid.lebsy.models.ItemCart;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterItemCart extends RecyclerView.Adapter<MyAdapterItemCart.ViewHolder> {
    private List<ItemCart> modelArrayList = new ArrayList<>();
    Context context;

    public MyAdapterItemCart(List<ItemCart> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewItemCartBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.recycler_view_item_cart, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemCart itemCart = modelArrayList.get(position);
        HandlerItemCart handlerItemCart = new HandlerItemCart(holder.binding.numberItemButtonCart);
        int price = ((Integer.parseInt(itemCart.getPriceItem()))) * ((Integer.parseInt(itemCart.getNumberItem())));
        holder.binding.textViewPriceItemCart.setText(String.valueOf(price));
        holder.binding.setOnClick(handlerItemCart);
        holder.binding.setItem(itemCart);
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public void setList(List<ItemCart> models) {
        this.modelArrayList = models;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerViewItemCartBinding binding;

        public ViewHolder(@NonNull RecyclerViewItemCartBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

        }
    }

    public class HandlerItemCart {
        TextView textViewNumber;

        public HandlerItemCart(TextView textViewNumber) {
            this.textViewNumber = textViewNumber;
        }

        public void addNumber(View view) {
            int number = Integer.parseInt(textViewNumber.getText().toString());
            textViewNumber.setText(String.valueOf(number + 1));

        }

        public void deleteNumber(View view) {
            int number = Integer.parseInt(textViewNumber.getText().toString());
            if (number == 0) {
            } else {
                textViewNumber.setText(String.valueOf(number - 1));
            }

        }
        // To calculate total price and set it in database..
        public void setTotalPrice() {
            ArrayList<ItemCart> itemCarts = new ArrayList<>();
            String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = database.getReference("Cart").child(uid).child("Order");
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    itemCarts.clear();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String priceItem = dataSnapshot.child("priceItem").getValue(String.class);
                        String numberItem = dataSnapshot.child("numberItem").getValue(String.class);
                        DatabaseReference myRef = database.getReference("Cart").child(uid).child("TotalPrice");
                        int oneType;
                        int overTotal = 0;
                        oneType = ((Integer.parseInt(String.valueOf(priceItem)))) * ((Integer.parseInt(String.valueOf(numberItem))));
                        overTotal = overTotal + oneType;
                        myRef.setValue(String.valueOf(overTotal));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }
    }
}






