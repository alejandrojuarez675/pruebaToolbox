package prueba.com.pruebatoolbox;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorThumb extends RecyclerView.Adapter<AdaptadorThumb.ViewHolderThumb> {
    @NonNull
    @Override
    public ViewHolderThumb onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_thumb, null, false);
        return new ViewHolderThumb(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderThumb viewHolderThumb, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderThumb extends RecyclerView.ViewHolder {

        ImageView iv_img;
        TextView tv_text;

        public ViewHolderThumb(@NonNull View itemView) {
            super(itemView);
            iv_img  = itemView.findViewById(R.id.iv_img_thumb);
            tv_text = itemView.findViewById(R.id.tv_text_thumb);
        }
    }
}
