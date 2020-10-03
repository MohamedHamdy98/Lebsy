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
import java.util.HashMap;
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
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        ItemCart itemCart = modelArrayList.get(position);
        holder.binding.setItem(itemCart);

        holder.binding.addItemButtonCart.setOnClickListener(v -> {
            int number = Integer.parseInt(holder.binding.numberItemButtonCart.getText().toString());
            holder.binding.numberItemButtonCart.setText(String.valueOf(number + 1));
        });
        holder.binding.addItemCart.setOnClickListener(v -> {
            DatabaseReference databaseReference = FirebaseDatabase.
                    getInstance().getReference("Cart").child(uid).child("Order").child(itemCart.getNameItem());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("numberItem", holder.binding.numberItemButtonCart.getText().toString());
            databaseReference.updateChildren(hashMap);
        });
        holder.binding.deleteItemButtonCart.setOnClickListener(v -> {
            int number = Integer.parseInt(holder.binding.numberItemButtonCart.getText().toString());
            if (number == 0) {
            } else {
                holder.binding.numberItemButtonCart.setText(String.valueOf(number - 1));
//                DatabaseReference databaseReference = FirebaseDatabase.
//                        getInstance().getReference("Cart").child(uid).child("Order").child(itemCart.getNameItem());
//                HashMap<String, Object> hashMap = new HashMap<>();
//                hashMap.put("numberItem", number);
////                databaseReference.updateChildren(hashMap);
            }
        });
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

}






