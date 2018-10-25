package prueba.com.pruebatoolbox;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorPoster extends RecyclerView.Adapter<AdaptadorPoster.ViewHolderPoster> {
    @NonNull
    @Override
    public ViewHolderPoster onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_poster,null,false);
        return new ViewHolderPoster(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPoster viewHolderPoster, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderPoster extends RecyclerView.ViewHolder {

        ImageView iv_img;
        TextView tv_text;

        public ViewHolderPoster(@NonNull View itemView) {
            super(itemView);
            iv_img  = itemView.findViewById(R.id.iv_img_poster);
            tv_text = itemView.findViewById(R.id.tv_text_poster);
        }
    }
}
