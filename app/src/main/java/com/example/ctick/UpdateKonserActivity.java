package com.example.ctick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.ctick.databinding.ActivityUpdateKonserBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateKonserActivity extends AppCompatActivity {
    private ActivityUpdateKonserBinding binding;
    private Input input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateKonserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        input = getIntent().getParcelableExtra("EXTRA_DATA");
        String id = input.getId();

        binding.btnUbah.setOnClickListener(new View.OnClickListener() {
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

                boolean bolehUpdateNamaKonser = Util.inputError(nama_konser,binding.etNamaKonser, "nama konser");
                boolean bolehUpdateTanggalKonser = Util.inputError(tanggal_konser,binding.etTanggalKonser, "tanggal konser");
                boolean bolehUpdateLokasiKonser = Util.inputError(lokasi_konser,binding.etLokasiKonser, "lokasi konser");
                boolean bolehUpdateHargaTiket = Util.inputError(harga_tiket,binding.etHargaKonser, "harga tiket");
                boolean bolehUpdateTentangKonser = Util.inputError(tentang_konser,binding.etTentangKonser, "tentang konser");
                boolean bolehUpdateWaktuKonser = Util.inputError(waktu_konser,binding.etWaktuKonser, "waktu konser");
                boolean bolehUpdateGambarKonser = Util.inputError(gambar_konser,binding.etGambarKonser, "Gambar Konser");

                if (bolehUpdateNamaKonser && bolehUpdateTanggalKonser && bolehUpdateLokasiKonser && bolehUpdateHargaTiket && bolehUpdateTentangKonser && bolehUpdateWaktuKonser && bolehUpdateGambarKonser){
                    saveKonserToAPI(nama_konser, tanggal_konser,lokasi_konser,harga,tentang_konser,waktu_konser,gambar_konser);
                }

            }
        });


    }

    private void saveKonserToAPI(String namakonser, String tanggalkonser, String lokasikonser, Integer hargaTiket, String tentangkonser, String waktukonser, String gambarkonser) {
        binding.progressbar.setVisibility(View.VISIBLE);
        APIService api = Util.getRetrofit().create(APIService.class);
        Call<KonserItem> call = api.updateKonser(namakonser,tanggalkonser,lokasikonser,hargaTiket, tentangkonser,waktukonser,gambarkonser);
        call.enqueue(new Callback<KonserItem>() {
            @Override
            public void onResponse(Call<KonserItem> call, Response<KonserItem> response) {
                binding.progressbar.setVisibility(View.VISIBLE);
                if (response.code()==200){
                    int success = response.body().getSuccess();
                    String message = response.body().getMessage();

                    if (success == 1){
                        Toast.makeText(UpdateKonserActivity.this,message,Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(UpdateKonserActivity.this,message, Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }else {
                    Toast.makeText(UpdateKonserActivity.this,"Response" + response.code(), Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<KonserItem> call, Throwable t) {
                binding.progressbar.setVisibility(View.VISIBLE);
                System.out.println("Retrofit Error : " + t.getMessage());
                Toast.makeText(UpdateKonserActivity.this,"Retrofit Error :" + t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }


}