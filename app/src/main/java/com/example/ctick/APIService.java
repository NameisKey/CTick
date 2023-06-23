package com.example.ctick;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {

    @GET("get")
    Call<Konser> getKonser();

    @FormUrlEncoded
    @POST("add")
    Call<KonserItem>
    addKonser(
        @Field("nama_konser") String namaKonser,
        @Field("tanggal_konser") String tanggalKonser,
        @Field("lokasi_konser") String lokasiKonser,
        @Field("harga_tiket") Integer hargaTiket,
        @Field("tentang_konser") String tentangKonser,
        @Field("waktu_konser") String waktuKonser,
        @Field("gambar_konser") String gambarKonser
    );

    @FormUrlEncoded
    @PUT("update/{id}")
    Call<KonserItem>
    updateKonser(
            @Path("id") String id,
            @Field("nama_konser") String namaKonser,
            @Field("tanggal_konser") String tanggalKonser,
            @Field("lokasi_konser") String lokasiKonser,
            @Field("harga_tiket") Integer hargaTiket,
            @Field("tentang_konser") String tentangKonser,
            @Field("waktu_konser") String waktuKonser,
            @Field("gambar_konser") String gambarKonser
    );

    @DELETE("delete/{id}")
    Call<KonserItem>
    deleteKonser(
            @Path("id") String id
    );

}