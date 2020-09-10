package com.momoandroid.lebsy.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.momoandroid.lebsy.R;
import com.momoandroid.lebsy.databinding.FragmentSignUpBinding;
import com.momoandroid.lebsy.models.Users;

public class SignUpFragment extends Fragment {
    private Users users;
    private FragmentSignUpBinding binding;
    private FirebaseAuth mAuth;
    private HandlerSignUp handlerSignUp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_sign_up, container, false);
        View root = binding.getRoot();
        mAuth = FirebaseAuth.getInstance();
        users = new Users();
        binding.setUser(users);
        handlerSignUp = new HandlerSignUp(binding.editTextSignUpEmail, binding.editTextSignUpPass);
        binding.setOnClick(handlerSignUp);
        return root;
    }

    public class HandlerSignUp {
        private EditText editTextEmail, editTextPassword;

        public HandlerSignUp(EditText editTextEmail, EditText editTextPassword) {
            this.editTextEmail = editTextEmail;
            this.editTextPassword = editTextPassword;
        }

        public void signUp(View view) {
            final String email = editTextEmail.getText().toString();
            final String password = editTextPassword.getText().toString();
            binding.signUpProgressBar.setVisibility(View.VISIBLE);
            if (email.isEmpty()) {
                Toast.makeText(getActivity(), "Please! Enter your email!", Toast.LENGTH_SHORT).show();
                binding.signUpProgressBar.setVisibility(View.GONE);
            }
            if (password.isEmpty()) {
                Toast.makeText(getActivity(), "Please! Enter your password!", Toast.LENGTH_SHORT).show();
                binding.signUpProgressBar.setVisibility(View.GONE);
            }
            if (email.isEmpty()) {
                Toast.makeText(getActivity(), "Please! Enter your email!", Toast.LENGTH_SHORT).show();
                binding.signUpProgressBar.setVisibility(View.GONE);
            } else {
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    binding.signUpProgressBar.setVisibility(View.GONE);
                                    Toast.makeText(getActivity(), "Authentication success.",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(getActivity(), "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    binding.signUpProgressBar.setVisibility(View.GONE);
                                }
                            }
                        });
            }

        }
    }
}