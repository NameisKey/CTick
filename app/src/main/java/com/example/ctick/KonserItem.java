package com.example.ctick;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class KonserItem implements Parcelable {

	@SerializedName("success")
	private int success;

	@SerializedName("message")
	private String message;

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

	protected KonserItem(Parcel in) {
		tentangKonser = in.readString();
		lokasiKonser = in.readString();
		hargaTiket = in.readInt();
		waktuKonser = in.readString();
		tanggalKonser = in.readString();
		namaKonser = in.readString();
		gambarKonser = in.readString();
		id = in.readString();
	}

	public static final Creator<KonserItem> CREATOR = new Creator<KonserItem>() {
		@Override
		public KonserItem createFromParcel(Parcel in) {
			return new KonserItem(in);
		}

		@Override
		public KonserItem[] newArray(int size) {
			return new KonserItem[size];
		}
	};

	public String getTentangKonser(){
		return tentangKonser;
	}

	public String getLokasiKonser(){
		return lokasiKonser;
	}

	public int getHargaTiket(){
		return hargaTiket;
	}

	public String getWaktuKonser(){
		return waktuKonser;
	}

	public String getTanggalKonser(){
		return tanggalKonser;
	}

	public String getNamaKonser(){
		return namaKonser;
	}

	public String getGambarKonser(){
		return gambarKonser;
	}

	public String getId(){
		return id;
	}

	public int getSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(@NonNull Parcel dest, int flags) {
		dest.writeString(tentangKonser);
		dest.writeString(lokasiKonser);
		dest.writeInt(hargaTiket);
		dest.writeString(waktuKonser);
		dest.writeString(tanggalKonser);
		dest.writeString(namaKonser);
		dest.writeString(gambarKonser);
		dest.writeString(id);
	}
}