package com.example.ctick;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Konser<T>{

	@SerializedName("konser")
	private List<KonserItem> konser;

	public void setKonser(List<KonserItem> konser){
		this.konser = konser;
	}

	public List<KonserItem> getKonser(){
		return konser;
	}

	@SerializedName("success")
	private int success;

	@SerializedName("message")
	private String message;
	private T data;

	public int getSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public T getData(){
		return data;
	}
}