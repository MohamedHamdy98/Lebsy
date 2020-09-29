package com.momoandroid.lebsy.models;

import android.graphics.drawable.Drawable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.momoandroid.lebsy.BR;

public class ItemCategories extends BaseObservable {
    private String nameItem;
    private String imageItem;
    private String priceItem;
    private String sizeItem;
    private String numberItem;

    public ItemCategories() {
    }


    public ItemCategories(String nameItem, String imageItem, String priceItem, String sizeItem, String numberItem) {
        this.nameItem = nameItem;
        this.imageItem = imageItem;
        this.priceItem = priceItem;
        this.sizeItem = sizeItem;
        this.numberItem = numberItem;
    }

    public ItemCategories(String nameItem, String imageItem, String priceItem) {
        this.nameItem = nameItem;
        this.imageItem = imageItem;
        this.priceItem = priceItem;
    }
    @Bindable
    public String getNumberItem() {
        return numberItem;
    }

    public void setNumberItem(String numberItem) {
        this.numberItem = numberItem;
        notifyPropertyChanged(BR.numberItem);
    }

    @Bindable
    public String getSizeItem() {
        return sizeItem;
    }

    public void setSizeItem(String sizeItem) {
        this.sizeItem = sizeItem;
        notifyPropertyChanged(BR.sizeItem);
    }

    @Bindable
    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
        notifyPropertyChanged(BR.nameItem);
    }
    @Bindable
    public String getImageItem() {
        return imageItem;
    }

    public void setImageItem(String imageItem) {
        this.imageItem = imageItem;
        notifyPropertyChanged(BR.imageItem);
    }
    @Bindable
    public String getPriceItem() {
        return priceItem;
    }

    public void setPriceItem(String priceItem) {
        this.priceItem = priceItem;
        notifyPropertyChanged(BR.priceItem);
    }
}
