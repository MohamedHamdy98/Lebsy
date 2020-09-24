package com.momoandroid.lebsy.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.momoandroid.lebsy.R;
import com.momoandroid.lebsy.databinding.RecyclerviewItemCategoriesBinding;
import com.momoandroid.lebsy.models.ItemCategories;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterItemCategories extends RecyclerView.Adapter<MyAdapterItemCategories.ViewHolder> {
    private List<ItemCategories> modelArrayList = new ArrayList<>();

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




