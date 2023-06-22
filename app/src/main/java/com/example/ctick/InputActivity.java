package com.example.ctick;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.ctick.databinding.ActivityInputBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class InputActivity extends AppCompatActivity {
    private ActivityInputBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInputBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama_konser = binding.etNamaKonser.getText().toString();
                String tanggal_konser = binding.etTanggalKonser.getText().toString();
                String lokasi_konser = binding.etLokasiKonser.getText().toString();
                String harga_tiket = binding.etHargaKonser.getText().toString();
                int harga = Integer.parseInt(harga_tiket);
                String tentang_konser = binding.etTentangKonser.getText().toString();
                String waktu_konser = binding.etWaktuKonser.getText().toString();
                String gambar_konser = binding.etGambarKonser.getText().toString();

                boolean bolehInputNamaKonser = Util.inputError(nama_konser,binding.etNamaKonser, "nama konser");
                boolean bolehInputTanggalKonser = Util.inputError(tanggal_konser,binding.etTanggalKonser, "tanggal konser");
                boolean bolehInputLokasiKonser = Util.inputError(lokasi_konser,binding.etLokasiKonser, "lokasi konser");
                boolean bolehInputHargaTiket = Util.inputError(harga_tiket,binding.etHargaKonser, "harga tiket");
                boolean bolehInputTentangKonser = Util.inputError(tentang_konser,binding.etTentangKonser, "tentang konser");
                boolean bolehInputWaktuKonser = Util.inputError(waktu_konser,binding.etWaktuKonser, "waktu konser");
                boolean bolehInputGambarKonser = Util.inputError(gambar_konser,binding.etGambarKonser, "Gambar Konser");

                if (bolehInputNamaKonser && bolehInputTanggalKonser && bolehInputLokasiKonser
                        && bolehInputHargaTiket && bolehInputTentangKonser && bolehInputWaktuKonser && bolehInputGambarKonser){
                    saveKonserToAPI(nama_konser, tanggal_konser, lokasi_konser,harga,tentang_konser,waktu_konser,gambar_konser);
                }

                }


        });
    }

    private void saveKonserToAPI(String namaKonser, String tanggalKonser, String lokasiKonser, Integer hargaTiket, String tentangKonser, String waktuKonser, String gambarKonser ) {
        binding.progressbar.setVisibility(View.VISIBLE);
        APIService api = Util.getRetrofit().create(APIService.class);
        Call<KonserItem> call = api.addKonser(namaKonser, tanggalKonser, lokasiKonser, hargaTiket , tentangKonser, waktuKonser, gambarKonser);
        call.enqueue(new Callback<KonserItem>() {
            @Override
            public void onResponse(Call<KonserItem> call, Response<KonserItem> response) {
                binding.progressbar.setVisibility(View.VISIBLE);
                if (response.code()==200){
                    int success = response.body().getSuccess();
                    String message = response.body().getMessage();

                    if (success == 1){
                        Toast.makeText(InputActivity.this,message, Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(InputActivity.this,message, Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }else {
                    Toast.makeText(InputActivity.this,"Response" + response.code(), Toast.LENGTH_SHORT).show();
                    finish();
                }

            }

            @Override
            public void onFailure(Call<KonserItem> call, Throwable t) {
                binding.progressbar.setVisibility(View.VISIBLE);
                System.out.println("Retrofit Error : " + t.getMessage());
                Toast.makeText(InputActivity.this, "Retrofit Error : " + t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}