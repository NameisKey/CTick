package com.example.ctick;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("tentang_konser")
	private String tentangKonser;

	@SerializedName("lokasi_konser")
	private String lokasiKonser;

	@SerializedName("harga_tiket")
	private int hargaTiket;

	@SerializedName("waktu_konser")
	private String waktuKonser;

	@SerializedName("tanggal_konser")
	private String tanggalKonser;

	@SerializedName("nama_konser")
	private String namaKonser;

	@SerializedName("gambar_konser")
	private String gambarKonser;

	@SerializedName("_id")
	private String id;

	public void setTentangKonser(String tentangKonser){
		this.tentangKonser = tentangKonser;
	}

	public String getTentangKonser(){
		return tentangKonser;
	}

	public void setLokasiKonser(String lokasiKonser){
		this.lokasiKonser = lokasiKonser;
	}

	public String getLokasiKonser(){
		return lokasiKonser;
	}

	public void setHargaTiket(int hargaTiket){
		this.hargaTiket = hargaTiket;
	}

	public int getHargaTiket(){
		return hargaTiket;
	}

	public void setWaktuKonser(String waktuKonser){
		this.waktuKonser = waktuKonser;
	}

	public String getWaktuKonser(){
		return waktuKonser;
	}

	public void setTanggalKonser(String tanggalKonser){
		this.tanggalKonser = tanggalKonser;
	}

	public String getTanggalKonser(){
		return tanggalKonser;
	}

	public void setNamaKonser(String namaKonser){
		this.namaKonser = namaKonser;
	}

	public String getNamaKonser(){
		return namaKonser;
	}

	public void setGambarKonser(String gambarKonser){
		this.gambarKonser = gambarKonser;
	}

	public String getGambarKonser(){
		return gambarKonser;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}
}