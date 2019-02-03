package com.example.adamalbarisyi.batik;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BatikAdapter extends RecyclerView.Adapter<BatikAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Batik> listBatik;


    public ArrayList<Batik> getListBatik() {
        return listBatik;
    }

    public BatikAdapter(Context context) {
        this.context = context;
    }

    public void setListBatik(ArrayList<Batik> listBatik) {
        this.listBatik = listBatik;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_batik, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Batik batik = getListBatik().get(position);
        Glide.with(context)
                .load(batik.getPhoto())
                .override(350, 350)
                .into(holder.imgPhoto);

        holder.tvName.setText(batik.getName());
        holder.tvRemarks.setText(batik.getRemaks());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Batik batik1= getListBatik().get(position);
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra(DetailActivity.BATIK_IMGPHOTO,batik1.getPhoto());
                intent.putExtra(DetailActivity.BATIK_TITLE,batik1.getName());
                intent.putExtra(DetailActivity.BATIK_DESCRIPTION,batik1.getDescription());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return getListBatik().size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;
        RelativeLayout relativeLayout;

        ViewHolder(View view) {
            super(view);
            tvName = (TextView) itemView.findViewById(R.id.tv_item_name);
            tvRemarks = (TextView) itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = (ImageView) itemView.findViewById(R.id.img_item_photo);
            relativeLayout = itemView.findViewById(R.id.rl_batik);
        }
    }
}
