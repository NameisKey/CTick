package com.example.ctick;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ctick.databinding.ItemKonserBinding;

import java.util.ArrayList;
import java.util.List;

public class InputViewAdapter extends RecyclerView.Adapter<InputViewAdapter.ViewHolder>{

    private List<Input> data = new ArrayList<>();
    private OnItemLongClickListener onItemLongClickListener;

    public void setData(List<Input> data){
        this.data = data;
        notifyDataSetChanged();
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener){
        this.onItemLongClickListener = onItemLongClickListener;
    }
    @NonNull
    @Override
    public InputViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemKonserBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull InputViewAdapter.ViewHolder holder, int position) {
        int pos = holder.getAdapterPosition();
        Input input = data.get(pos);
        holder.itemKonserBinding.tvJudul.setText(input.getNama_konser());
        holder.itemKonserBinding.tvTanggal.setText(input.getTanggal_konser());
        holder.itemKonserBinding.tvTempat.setText(input.getLokasi_konser());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemLongClickListener.onItemLongClick(v,input,pos);
                return false;
            }
        });
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
        void onItemLongClick(View v, Input input, int position);
    }
}

