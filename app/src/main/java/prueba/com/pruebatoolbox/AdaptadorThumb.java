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

public class AdaptadorThumb extends RecyclerView.Adapter<AdaptadorThumb.ViewHolderThumb> {

    AdaptadorThumb(ArrayList<Item> items) {
        this.items = items;
    }

    private ArrayList<Item> items;
    private Context mContex;

    @NonNull
    @Override
    public ViewHolderThumb onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_thumb, null, false);
        mContex = viewGroup.getContext();
        return new ViewHolderThumb(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderThumb viewHolderThumb, @SuppressLint("RecyclerView") final int i) {
        viewHolderThumb.tv_text.setText(items.get(i).getTitle());
        new DescargaDeImagen((ImageView) viewHolderThumb.iv_img.findViewById(R.id.iv_img_thumb))
                .execute(items.get(i).getUrl());
        viewHolderThumb.iv_img.setOnClickListener(new View.OnClickListener() {
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

    class ViewHolderThumb extends RecyclerView.ViewHolder {

        ImageView iv_img;
        TextView tv_text;

        ViewHolderThumb(@NonNull View itemView) {
            super(itemView);
            iv_img  = itemView.findViewById(R.id.iv_img_thumb);
            tv_text = itemView.findViewById(R.id.tv_text_thumb);
        }
    }
}
