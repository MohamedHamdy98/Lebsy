package com.momoandroid.lebsy.view.uiBottomNavigation.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.momoandroid.lebsy.R;
import com.momoandroid.lebsy.adapters.MyAdapterItemCart;
import com.momoandroid.lebsy.databinding.FragmentCartBinding;
import com.momoandroid.lebsy.models.ItemCart;

import java.util.List;


public class CartFragment extends Fragment {

    private FragmentCartBinding binding;
    private CartViewModel cartViewModel;
    private MyAdapterItemCart myAdapterItemCart;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cartViewModel =
                ViewModelProviders.of(this).get(CartViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false);
        View root = binding.getRoot();

        cartViewModel.getDataByRxJava();
        binding.recyclerViewItemCart.setNestedScrollingEnabled(true);
        binding.recyclerViewItemCart.setHasFixedSize(true);
        binding.recyclerViewItemCart.setLayoutManager(new LinearLayoutManager(getActivity()));
        myAdapterItemCart = new MyAdapterItemCart();
        binding.recyclerViewItemCart.setAdapter(myAdapterItemCart);
        cartViewModel.mutableLiveData.observe(getActivity(), itemCarts -> myAdapterItemCart.setList(itemCarts));
        return root;
    }
}