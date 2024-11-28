package com.example.sekos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class KosAdapter extends RecyclerView.Adapter<KosAdapter.KosViewHolder> {

    private Context context;
    private List<Kos> kosList;

    public KosAdapter(Context context, List<Kos> kosList) {
        this.context = context;
        this.kosList = kosList;
    }

    @Override
    public KosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_kos, parent, false);
        return new KosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(KosViewHolder holder, int position) {
        Kos kos = kosList.get(position);
        holder.kosName.setText(kos.getName());
        holder.kosLocation.setText(kos.getLocation());
        holder.kosPrice.setText("Rp " + kos.getPrice());
        holder.kosImage.setImageResource(kos.getImageResId());
    }

    @Override
    public int getItemCount() {
        return kosList.size();
    }

    public static class KosViewHolder extends RecyclerView.ViewHolder {
        public TextView kosName, kosLocation, kosPrice;
        public ImageView kosImage;

        public KosViewHolder(View itemView) {
            super(itemView);
            kosName = itemView.findViewById(R.id.kosName);
            kosLocation = itemView.findViewById(R.id.kosLocation);
            kosPrice = itemView.findViewById(R.id.kosPrice);
            kosImage = itemView.findViewById(R.id.imageKos);
        }
    }
}

