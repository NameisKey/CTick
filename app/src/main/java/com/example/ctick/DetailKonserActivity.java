package com.example.ctick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.ctick.databinding.ActivityDetailKonserBinding;
import com.example.ctick.databinding.ActivityUpdateKonserBinding;

public class DetailKonserActivity extends AppCompatActivity {
    private ActivityDetailKonserBinding binding;
    private KonserItem input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetailKonserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        input = getIntent().getParcelableExtra("EXTRA_DATA");

        Glide.with(binding.ivPoster)
                .load(input.getGambarKonser())
                .into(binding.ivPoster);

        binding.tvNamaKonser.setText(input.getNamaKonser());
        binding.tvTanggal.setText(input.getTanggalKonser());
        binding.tvLokasi.setText(input.getLokasiKonser());
        //binding.tvHarga.setText(String.valueOf(input.getHargaTiket()));
        binding.tvTentangKonser.setText(input.getTentangKonser());
        binding.tvJam.setText(input.getWaktuKonser());

    }
}