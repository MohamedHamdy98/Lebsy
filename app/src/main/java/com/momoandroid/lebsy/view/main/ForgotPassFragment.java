package com.momoandroid.lebsy.view.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.momoandroid.lebsy.R;
import com.momoandroid.lebsy.databinding.FragmentForgotPassBinding;
import com.momoandroid.lebsy.models.Users;

public class ForgotPassFragment extends Fragment {
    private FragmentForgotPassBinding binding;
    private Users users;
    private HandlerForgotPass handlerForgotPass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_forgot_pass, container, false);
        View root = binding.getRoot();
        users = new Users();
        binding.setUser(users);
        handlerForgotPass = new HandlerForgotPass(binding.editTextForgotPassEmail);
        binding.setOnClick(handlerForgotPass);
        return root;
    }

    public class HandlerForgotPass {
        private EditText editTextEmail;

        public HandlerForgotPass(EditText editTextEmail) {
            this.editTextEmail = editTextEmail;
        }

        public void resetPass(View view) {
            final String email = editTextEmail.getText().toString();
            if (email.isEmpty()) {
                binding.textInputLayoutEmail.setError(getString(R.string.enterEmail));
                return;
            } else {
                binding.textInputLayoutEmail.setError(null);
                binding.forgotPassProgressBar.setVisibility(View.VISIBLE);
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(getActivity(), R.string.EmailSent, Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getActivity(), "Error!", Toast.LENGTH_LONG).show();
                            }
                            binding.forgotPassProgressBar.setVisibility(View.GONE);
                        });
            }
        }
    }
}