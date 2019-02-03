package com.example.adamalbarisyi.batik;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Batik> listBatik;

    public DetailAdapter(Context context) {
        this.context = context;
    }

    ArrayList<Batik> getListBatik() {
        return listBatik;
    }

    public void setListBatik(ArrayList<Batik> listBatik) {
        this.listBatik = listBatik;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Batik batik = getListBatik().get(position);
        Glide.with(context)
                .load(batik.getPhoto())
                .override(350, 350)
                .into(holder.imgPhoto);

        holder.tvName.setText(batik.getName());
        holder.descripion.setText(batik.getDescription());
    }

    @Override
    public int getItemCount() {
        return getListBatik().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView imgPhoto;
        TextView descripion;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name_item);
            imgPhoto = (ImageView) itemView.findViewById(R.id.img_backdrop_item);
            descripion = itemView.findViewById(R.id.tv_description_item);
        }
    }
}
