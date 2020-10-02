package com.momoandroid.lebsy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.momoandroid.lebsy.R;
import com.momoandroid.lebsy.databinding.RecyclerViewItemCartBinding;
import com.momoandroid.lebsy.models.ItemCart;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterItemCart extends RecyclerView.Adapter<MyAdapterItemCart.ViewHolder> {
    private List<ItemCart> modelArrayList = new ArrayList<>();

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
        public void addNumber(View view){
            int number = Integer.parseInt(textViewNumber.getText().toString());
            textViewNumber.setText(number+1);

        }
        public void deleteNumber(View view){
            int number = Integer.parseInt(textViewNumber.getText().toString());
            textViewNumber.setText(number-1);
        }


    }
}






