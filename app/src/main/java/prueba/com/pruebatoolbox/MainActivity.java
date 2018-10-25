package prueba.com.pruebatoolbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Carousel> listaCaroucel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv_thumb = findViewById(R.id.rv_recycler_thumb);
        RecyclerView rv_poster = findViewById(R.id.rv_recycler_poster);
        TextView tv_titulo_thumb = findViewById(R.id.tv_titulo_thumb);
        TextView tv_titulo_poster = findViewById(R.id.tv_titulo_poster);

        rv_thumb.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.HORIZONTAL, false));
        rv_poster.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.HORIZONTAL, false));

        cargarDatos();

        AdaptadorThumb adaptadorThumb;
        AdaptadorPoster adaptadorPoster;
        for (int i=0; i<listaCaroucel.size();i++){
            switch (listaCaroucel.get(i).getType()){
                case "thumb":
                    adaptadorThumb = new AdaptadorThumb(listaCaroucel.get(i).getItems());
                    rv_thumb.setAdapter(adaptadorThumb);
                    tv_titulo_thumb.setText(listaCaroucel.get(i).getTitle());
                    break;

                case "poster":
                    adaptadorPoster = new AdaptadorPoster(listaCaroucel.get(i).getItems());
                    rv_poster.setAdapter(adaptadorPoster);
                    tv_titulo_poster.setText(listaCaroucel.get(i).getTitle());
                    break;
            }
        }

    }

    private void cargarDatos(){
        listaCaroucel = new ArrayList<>();
        listaCaroucel.add(new Carousel("Carousel Thumb", "thumb"));
        listaCaroucel.get(0).addItem(
                new Item("La playa",
                        "http://placeimg.com/320/480/any",
                        "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4"));
        listaCaroucel.get(0).addItem(
                new Item("Peligro en Bangkok",
                        "http://placeimg.com/320/480/any",
                        "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4"));
        listaCaroucel.get(0).addItem(
                new Item("Todas contra John",
                        "http://placeimg.com/320/480/any",
                        "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4"));
        listaCaroucel.get(0).addItem(
                new Item("Quisiera ser millonario",
                        "http://placeimg.com/320/480/any",
                        "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4"));

        listaCaroucel.add(new Carousel("Carousel Poster", "poster"));
        listaCaroucel.get(1).addItem(
                new Item("La playa",
                        "http://placeimg.com/640/480/any",
                "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4"));
        listaCaroucel.get(1).addItem(
                new Item("Peligro en Bangkok",
                        "http://placeimg.com/640/480/any",
                        "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4"));
        listaCaroucel.get(1).addItem(
                new Item("Todas contra John",
                        "http://placeimg.com/640/480/any",
                        "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4"));
        listaCaroucel.get(1).addItem(
                new Item("Quisiera ser millonario",
                        "http://placeimg.com/640/480/any",
                        "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4"));
    }
}
