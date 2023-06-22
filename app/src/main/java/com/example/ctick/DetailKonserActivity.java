package com.example.ctick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ctick.databinding.ActivityDetailKonserBinding;

public class DetailKonserActivity extends AppCompatActivity {
    private ActivityDetailKonserBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetailKonserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}