package com.example.ctick;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.ctick.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private KonserViewAdapter konserViewAdapter;
    private List<Input> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getAllInput();
        Log.e("MainActivity", "Main OnCreate()");

        konserViewAdapter = new KonserViewAdapter();
        binding.rvKonser.setLayoutManager(new LinearLayoutManager(this));
        binding.rvKonser.setAdapter(konserViewAdapter);
        konserViewAdapter.setOnItemLongClickListener(new KonserViewAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(View v, KonserItem input, int position) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
                popupMenu.inflate(R.menu.menu_popup);
                popupMenu.setGravity(Gravity.RIGHT);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int idMenu = item.getItemId();
                        if (idMenu == R.id.action_edit){
                            Intent intent = new Intent(MainActivity.this, UpdateKonserActivity.class);
                            intent.putExtra("EXTRA_DATA", input);
                            startActivity(intent);
                            return true;
                        }else if (idMenu == R.id.action_delete){
                            String id = input.getId();
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("Konfirmasi");
                            builder.setMessage("Yakin ingin Menghapus Konser'" + data.get(position).getNama_konser() + "' ?");
                            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    deleteInput(id);
                                }
                            });
                            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                            return true;
                        }else {
                            return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });


        binding.fabInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputActivity.class);
                startActivity(intent);

            }
        });
    }

    private void deleteInput(String id) {
        APIService api = Util.getRetrofit().create(APIService.class);
        Call<KonserItem> call = api.deleteKonser(id);
        call.enqueue(new Callback<KonserItem>() {
            @Override
            public void onResponse(Call<KonserItem> call, Response<KonserItem> response) {
                if(response.code()==200){
                    int success = response.body().getSuccess();
                    String message = response.body().getMessage();

                    if (success==1){
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                        getAllInput();
                    }else{
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Response " + response.code(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<KonserItem> call, Throwable t) {
                System.out.println("Retrofit Error : " + t.getMessage());
                Toast.makeText(MainActivity.this,"Retrofit Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getAllInput();
    }

    private void getAllInput() {
        Log.e("MainActivity", "Main GetAllInput()");
        binding.progressbar.setVisibility(View.VISIBLE);
        APIService api = Util.getRetrofit().create(APIService.class);
        Call<Konser> call = api.getKonser();
        call.enqueue(new Callback<Konser>() {
            @Override
            public void onResponse(Call<Konser> call, Response<Konser> response) {
                binding.progressbar.setVisibility(View.GONE);
                Log.e("MainActivity", "Response: " + response.code());
                if(response.code()==200){
                    int success = response.body().getSuccess();
                    String message = response.body().getMessage();

                    if (success == 1){
                        List<KonserItem> dataKonser = response.body().getKonser();

                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                        konserViewAdapter.setData(dataKonser);

                    }
                }
            }

            @Override
            public void onFailure(Call<Konser> call, Throwable t) {
                binding.progressbar.setVisibility(View.GONE);
                System.out.println("Retrofit Error : " + t.getMessage());
                Toast.makeText(MainActivity.this, "Retrofit Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}