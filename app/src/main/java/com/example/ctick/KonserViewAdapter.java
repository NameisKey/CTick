package com.example.ctick;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ctick.databinding.ItemKonserBinding;

import java.util.ArrayList;
import java.util.List;

public class KonserViewAdapter extends RecyclerView.Adapter<KonserViewAdapter.ViewHolder>{
    private OnItemClickCallback onItemClickCallback;

    private List<KonserItem> data = new ArrayList<>();
    private OnItemLongClickListener onItemLongClickListener;

    public void setData(List<KonserItem> data){
        this.data = data;
        notifyDataSetChanged();
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener){
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public KonserViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemKonserBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull KonserViewAdapter.ViewHolder holder, int position) {
        int pos = holder.getAdapterPosition();
        KonserItem item = data.get(pos);
        Glide.with(holder.itemKonserBinding.ivFoto).load(item.getGambarKonser()).into(holder.itemKonserBinding.ivFoto);
        holder.itemKonserBinding.tvJudul.setText(item.getNamaKonser());
        holder.itemKonserBinding.tvTanggal.setText(item.getTanggalKonser());
        holder.itemKonserBinding.tvTempat.setText(item.getLokasiKonser());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemLongClickListener.onItemLongClick(v,item,pos);
                return false;
            }
        });
        holder.itemView.setOnClickListener(v ->
                onItemClickCallback.onItemClicked(item)
        );
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemKonserBinding itemKonserBinding;


        public ViewHolder(@NonNull ItemKonserBinding itemView) {
            super(itemView.getRoot());
            itemKonserBinding = itemView;
        }
    }
    public interface OnItemLongClickListener {
        void onItemLongClick(View v, KonserItem item, int position);
    }

    public interface OnItemClickCallback {
        void onItemClicked(KonserItem item);
    }
}

