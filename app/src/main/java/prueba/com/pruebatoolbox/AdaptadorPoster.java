package prueba.com.pruebatoolbox;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorPoster extends RecyclerView.Adapter<AdaptadorPoster.ViewHolderPoster> {

    AdaptadorPoster(ArrayList<Item> items) {
        this.items = items;
    }

    private ArrayList<Item> items;
    private Context mContex;

    @NonNull
    @Override
    public ViewHolderPoster onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_poster,null,false);
        mContex = viewGroup.getContext();
        return new ViewHolderPoster(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPoster viewHolderPoster, @SuppressLint("RecyclerView") final int i) {
        viewHolderPoster.tv_text.setText(items.get(i).getTitle());
        new DescargaDeImagen((ImageView) viewHolderPoster.iv_img.findViewById(R.id.iv_img_poster))
                .execute(items.get(i).getUrl());
        viewHolderPoster.iv_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("com.pruebaToolbox.video");
                intent.putExtra("video", items.get(i).getVideo());
                mContex.sendBroadcast(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolderPoster extends RecyclerView.ViewHolder {

        ImageView iv_img;
        TextView tv_text;

        ViewHolderPoster(@NonNull View itemView) {
            super(itemView);
            iv_img  = itemView.findViewById(R.id.iv_img_poster);
            tv_text = itemView.findViewById(R.id.tv_text_poster);
        }
    }
}
