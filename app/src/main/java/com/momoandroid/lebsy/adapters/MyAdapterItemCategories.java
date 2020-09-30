package com.momoandroid.lebsy.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.momoandroid.lebsy.R;
import com.momoandroid.lebsy.databinding.RecyclerviewItemCategoriesBinding;
import com.momoandroid.lebsy.models.ItemCategories;
import com.momoandroid.lebsy.view.ItemActivity;
import com.momoandroid.lebsy.view.mainAuth.AuthenticationActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterItemCategories extends RecyclerView.Adapter<MyAdapterItemCategories.ViewHolder> {
    private List<ItemCategories> modelArrayList = new ArrayList<>();
    private Context context;
    int index = -1;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerviewItemCategoriesBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.recyclerview_item_categories, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemCategories itemCategories = modelArrayList.get(position);
        if (itemCategories.getImageItem().equals("default")) {
            holder.binding.imageViewShoesItemCategories.setImageResource(R.drawable.mee);
        } else {
            Picasso.get().load(itemCategories.getImageItem()).into(holder.binding.imageViewShoesItemCategories);
        }
        holder.itemView.setOnClickListener(v -> {
            index = position;
            notifyDataSetChanged();
            Intent intent = new Intent(v.getContext(), ItemActivity.class);
            intent.putExtra("name",modelArrayList.get(position).getNameItem());
            intent.putExtra("price",modelArrayList.get(position).getPriceItem());
            intent.putExtra("image",modelArrayList.get(position).getImageItem());
            v.getContext().startActivity(intent);
        });
        holder.binding.setItem(itemCategories);
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public void setList(List<ItemCategories> models) {
        this.modelArrayList = models;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerviewItemCategoriesBinding binding;

        public ViewHolder(@NonNull RecyclerviewItemCategoriesBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}




