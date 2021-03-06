package com.momoandroid.lebsy.view.mainAuth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.momoandroid.lebsy.R;
import com.momoandroid.lebsy.databinding.FragmentLogInBinding;
import com.momoandroid.lebsy.models.Users;
import com.momoandroid.lebsy.view.uiBottomNavigation.CategoriesActivity;

import static android.content.Context.MODE_PRIVATE;

public class LogInFragment extends Fragment {
    private FragmentLogInBinding binding;
    private Users users;
    private FirebaseAuth mAuth;
    private HandlerLogIn handlerLogIn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_log_in,container,false);
        View root = binding.getRoot();
        // keep log in
        SharedPreferences preferences = getActivity().getSharedPreferences("keep", MODE_PRIVATE);
        String check = preferences.getString("remember", "");
        if (check.equals("true")) {
            startActivity(new Intent(getActivity(), CategoriesActivity.class));
        } else if (check.equals("false")) {
        }
        mAuth = FirebaseAuth.getInstance();
        users = new Users();
        binding.setUser(users);
        handlerLogIn = new HandlerLogIn(binding.editTextLogInEmail,binding.editTextLogInPass,binding.checkBox);
        binding.setOnClick(handlerLogIn);
        handlerLogIn.keepLogIn();
        return root;
    }
    public class HandlerLogIn {
        private EditText editTextEmail, editTextPassword;
        private CheckBox checkBox;

        public HandlerLogIn(EditText editTextEmail, EditText editTextPassword,CheckBox checkBox) {
            this.editTextEmail = editTextEmail;
            this.editTextPassword = editTextPassword;
            this.checkBox = checkBox;
        }
        public void signUp(View view) {
            final String email = editTextEmail.getText().toString();
            final String password = editTextPassword.getText().toString();
            if (email.isEmpty()) {
                binding.textInputLayoutEmail.setError(getString(R.string.enterEmail));
                return;
            } else {
                binding.textInputLayoutEmail.setError(null);
            }
            if (password.isEmpty()) {
                binding.textInputLayoutPass.setError(getString(R.string.enterPass));
                binding.logInProgressBar.setVisibility(View.GONE);
            }
            else {
                binding.textInputLayoutPass.setError(null);
            } if (password.length() < 6) {
                binding.textInputLayoutPass.setError(getString(R.string.passMore6));
            }
            else {
                binding.logInProgressBar.setVisibility(View.VISIBLE);
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(getActivity(), "Authentication success.",
                                            Toast.LENGTH_SHORT).show();
                                    binding.logInProgressBar.setVisibility(View.GONE);
                                    getActivity().startActivity(new Intent(getActivity(), CategoriesActivity.class));
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(getActivity(), "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    binding.logInProgressBar.setVisibility(View.GONE);
                                }

                            }
                        });
            }

        }

        public void keepLogIn(){
            // To keep log in
            checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (buttonView.isChecked()) {
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("keep", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                } else if (!buttonView.isChecked()) {
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("keep", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();
                }
            });
        }
    }
}