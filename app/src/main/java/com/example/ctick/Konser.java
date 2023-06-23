package com.example.ctick;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Konser implements Parcelable {

	@SerializedName("konser")
	private List<KonserItem> konser;

	@SerializedName("success")
	private int success;

	@SerializedName("message")
	private String message;

	protected Konser(Parcel in) {
		success = in.readInt();
		message = in.readString();
	}

	public static final Creator<Konser> CREATOR = new Creator<Konser>() {
		@Override
		public Konser createFromParcel(Parcel in) {
			return new Konser(in);
		}

		@Override
		public Konser[] newArray(int size) {
			return new Konser[size];
		}
	};

	public List<KonserItem> getKonser(){
		return konser;
	}

	public int getSuccess(){
		return success;
	}

	public String getMessage(){
		return message;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(@NonNull Parcel dest, int flags) {
		dest.writeInt(success);
		dest.writeString(message);
	}
}