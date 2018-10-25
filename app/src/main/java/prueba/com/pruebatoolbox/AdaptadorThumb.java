package prueba.com.pruebatoolbox;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorThumb extends RecyclerView.Adapter<AdaptadorThumb.ViewHolderThumb> {

    public AdaptadorThumb(ArrayList<Item> items) {
        this.items = items;
    }

    private ArrayList<Item> items;

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolderThumb onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_thumb, null, false);
        return new ViewHolderThumb(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderThumb viewHolderThumb, int i) {
        viewHolderThumb.tv_text.setText(items.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
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
