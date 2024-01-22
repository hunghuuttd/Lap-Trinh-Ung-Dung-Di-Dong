package com.Final_Project_MAP.phongbt193051;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.Final_Project_MAP.phongbt193051.databinding.ActivityStartBinding;
import com.Final_Project_MAP.phongbt193051.ui.login.LoginActivity;

public class StartActivity extends AppCompatActivity {

    FirebaseUser firebaseUser;

    @Override
    protected void onStart() {
        super.onStart();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.Final_Project_MAP.phongbt193051.databinding.ActivityStartBinding binding = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.login.setOnClickListener(view -> startActivity(new Intent(StartActivity.this, LoginActivity.class)));

        binding.register.setOnClickListener(view -> startActivity(new Intent(StartActivity.this, RegisterActivity.class)));

        binding.buttonAdmin.setOnClickListener(view -> startActivity(new Intent(StartActivity.this, AdminActivity.class)));

    }

}