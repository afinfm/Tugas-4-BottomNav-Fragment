package com.example.tugas4bottomnavfragment.rv;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tugas4bottomnavfragment.R;

import java.util.ArrayList;

public class pahlawanAdapter extends RecyclerView.Adapter<pahlawanAdapter.ViewHolder> {
    private Context context;
    private ArrayList<pahlawanModel> pahlawanModels = new ArrayList<>();

    public pahlawanAdapter(ArrayList<pahlawanModel> heroList, Context context) {
        this.context = context;
    }

    public ArrayList<pahlawanModel> getPahlawanModels() {
        return pahlawanModels;
    }

    public void setPahlawanModels(ArrayList<pahlawanModel> pahlawanModels) {
        this.pahlawanModels = pahlawanModels;
    }

    @NonNull
    @Override
    public pahlawanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from((parent.getContext())).inflate(R.layout.item_detail, parent, false);
        return new ViewHolder((itemRow));
    }

    @Override
    public void onBindViewHolder(@NonNull pahlawanAdapter.ViewHolder holder, final int position) {
        Glide.with(context).load(getPahlawanModels().get(position).getHeroImage()).into(holder.imageHero);
        holder.tvNama.setText(getPahlawanModels().get(position).getHeroName());
        holder.btShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String heroName = "Your Hero is " + getPahlawanModels().get(position).getHeroName();
                intent.putExtra(Intent.EXTRA_TEXT, heroName);
                context.startActivity(Intent.createChooser(intent, "Share Using"));
            }
        });
        holder.btLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailPahlawan.class);
                intent.putExtra("img_url", getPahlawanModels().get(position).getHeroImage());
                intent.putExtra("title", getPahlawanModels().get(position).getHeroName());
                intent.putExtra("detail", getPahlawanModels().get(position).getHeroDetail());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getPahlawanModels().size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageHero;
        private TextView tvNama;
        private Button btLihat, btShare;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageHero = itemView.findViewById(R.id.itemDetail_image);
            tvNama = itemView.findViewById(R.id.itemDetail_tvNama);
            btLihat = itemView.findViewById(R.id.itemBtLihat);
            btShare = itemView.findViewById(R.id.itemBtShare);

        }
    }
}
