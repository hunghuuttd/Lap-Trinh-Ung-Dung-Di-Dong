package com.Final_Project_MAP.phongbt193051.ui.grade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.Final_Project_MAP.phongbt193051.QRScanActivity;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.Final_Project_MAP.phongbt193051.Adapter.GradeListAdapter;
import com.Final_Project_MAP.phongbt193051.Insert_Grade_Activity;
import com.Final_Project_MAP.phongbt193051.ui.verification.UsersVerification;
import com.Final_Project_MAP.phongbt193051.common.Common;
import com.Final_Project_MAP.phongbt193051.databinding.ActivityHomeBinding;


public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    BottomAppBar bottomAppBar;
    FloatingActionButton fab_main;
    RecyclerView recyclerView;
    TextView verify_btn;
    GradeListAdapter gradeListNewAdapter;
    FirebaseUser firebaseUser;
    ImageButton attendanceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        HomeViewModel homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        bottomAppBar = binding.bottomAppBar;
        verify_btn = binding.verifyBtn;
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        fab_main = binding.fabMain;
        attendanceButton = binding.attendanceButton;

        //QR
        attendanceButton.setOnClickListener(view -> {
            Intent qrScanIntent = new Intent(HomeActivity.this, QRScanActivity.class);
            startActivity(qrScanIntent);
        });
        //

        fab_main.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, Insert_Grade_Activity.class);
            startActivity(intent);
        });

        verify_btn.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, UsersVerification.class);
            startActivity(intent);
        });

        recyclerView = binding.recyclerViewMain;
        recyclerView.setHasFixedSize(true);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);


        if (Common.currentUserType.equals("admin")) {
            verify_btn.setVisibility(View.VISIBLE);
            homeViewModel.getGradeNamesForAdmin().observe(this, gradeNames ->{
                gradeListNewAdapter = new GradeListAdapter(HomeActivity.this, gradeNames);
                recyclerView.setAdapter(gradeListNewAdapter);
            });
        } else {
            fab_main.setVisibility(View.INVISIBLE);
            homeViewModel.getGradeNamesForUser().observe(this, gradeNames ->{
                gradeListNewAdapter = new GradeListAdapter(HomeActivity.this, gradeNames);
                recyclerView.setAdapter(gradeListNewAdapter);
            });
        }
    }





}