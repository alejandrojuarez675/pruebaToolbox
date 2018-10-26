package prueba.com.pruebatoolbox;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolderRecycler> {

    private ArrayList<Carousel> listCarouseles;

    AdaptadorRecycler(ArrayList<Carousel> listCarouseles) {
        this.listCarouseles = listCarouseles;
    }

    @NonNull
    @Override
    public ViewHolderRecycler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_recycler, null, false);
        return new ViewHolderRecycler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderRecycler viewHolderRecycler, int i) {
        viewHolderRecycler.tv_titulo.setText(listCarouseles.get(i).getTitle());
        switch (listCarouseles.get(i).getType()){
            case "thumb":
                AdaptadorThumb adaptadorThumb = new AdaptadorThumb(listCarouseles.get(i).getItems());
                viewHolderRecycler.rv_recycler.setAdapter(adaptadorThumb);
                break;
            case "poster":
                AdaptadorPoster adaptadorPoster = new AdaptadorPoster(listCarouseles.get(i).getItems());
                viewHolderRecycler.rv_recycler.setAdapter(adaptadorPoster);
                break;
            default:
                    break;
        }
    }

    @Override
    public int getItemCount() {
        return listCarouseles.size();
    }

    class ViewHolderRecycler extends RecyclerView.ViewHolder {

        TextView tv_titulo;
        RecyclerView rv_recycler;

        ViewHolderRecycler(@NonNull View itemView) {
            super(itemView);
            tv_titulo   = itemView.findViewById(R.id.tv_recycler);
            rv_recycler = itemView.findViewById(R.id.rv_recycler);
            rv_recycler.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL,false));

        }
    }
}
