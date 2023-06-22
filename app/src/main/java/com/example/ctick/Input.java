package com.example.ctick;

import android.os.Parcel;
import android.os.Parcelable;

public class Input {
    private String id;
    private String nama_konser;
    private String tanggal_konser;
    private String lokasi_konser;
    private String harga_tiket;
    private String tentang_konser;
    private String waktu_konser;

    private String gambar_konser;

    protected Input(Parcel in) {
        id = in.readString();
        nama_konser = in.readString();
        tanggal_konser = in.readString();
        lokasi_konser = in.readString();
        harga_tiket = in.readString();
        tentang_konser = in.readString();
        waktu_konser = in.readString();
        gambar_konser = in.readString();
    }

    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(id);
        dest.writeString(nama_konser);
        dest.writeString(tanggal_konser);
        dest.writeString(lokasi_konser);
        dest.writeString(harga_tiket);
        dest.writeString(tentang_konser);
        dest.writeString(waktu_konser);
        dest.writeString(gambar_konser);
    }

    public int describeContents(){return 0;}


    public String getGambar_konser() {
        return gambar_konser;
    }

    public void setGambar_konser(String gambar_konser) {
        this.gambar_konser = gambar_konser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama_konser() {
        return nama_konser;
    }

    public void setNama_konser(String nama_konser) {
        this.nama_konser = nama_konser;
    }

    public String getTanggal_konser() {
        return tanggal_konser;
    }

    public void setTanggal_konser(String tanggal_konser) {
        this.tanggal_konser = tanggal_konser;
    }

    public String getLokasi_konser() {
        return lokasi_konser;
    }

    public void setLokasi_konser(String lokasi_konser) {
        this.lokasi_konser = lokasi_konser;
    }

    public String getHarga_tiket() {
        return harga_tiket;
    }

    public void setHarga_tiket(String harga_tiket) {
        this.harga_tiket = harga_tiket;
    }

    public String getTentang_konser() {
        return tentang_konser;
    }

    public void setTentang_konser(String tentang_konser) {
        this.tentang_konser = tentang_konser;
    }

    public String getWaktu_konser() {
        return waktu_konser;
    }

    public void setWaktu_konser(String waktu_konser) {
        this.waktu_konser = waktu_konser;
    }
}
