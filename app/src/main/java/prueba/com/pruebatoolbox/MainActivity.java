package prueba.com.pruebatoolbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Carousel> listaCaroucel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv_recycler = findViewById(R.id.rv_lista_main);
        rv_recycler.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL,false));

        cargarDatos();

        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(listaCaroucel);
        rv_recycler.setAdapter(adaptadorRecycler);
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

        listaCaroucel.add(new Carousel("Carousel Thumb", "thumb"));
        listaCaroucel.get(2).addItem(
                new Item("La playa",
                        "http://placeimg.com/320/480/any",
                        "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4"));
        listaCaroucel.get(2).addItem(
                new Item("Peligro en Bangkok",
                        "http://placeimg.com/320/480/any",
                        "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4"));
        listaCaroucel.get(2).addItem(
                new Item("Todas contra John",
                        "http://placeimg.com/320/480/any",
                        "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4"));
        listaCaroucel.get(2).addItem(
                new Item("Quisiera ser millonario",
                        "http://placeimg.com/320/480/any",
                        "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4"));

        listaCaroucel.add(new Carousel("Carousel Poster", "poster"));
        listaCaroucel.get(3).addItem(
                new Item("La playa",
                        "http://placeimg.com/640/480/any",
                        "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4"));
        listaCaroucel.get(3).addItem(
                new Item("Peligro en Bangkok",
                        "http://placeimg.com/640/480/any",
                        "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4"));
        listaCaroucel.get(3).addItem(
                new Item("Todas contra John",
                        "http://placeimg.com/640/480/any",
                        "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4"));
        listaCaroucel.get(3).addItem(
                new Item("Quisiera ser millonario",
                        "http://placeimg.com/640/480/any",
                        "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4"));
    }
}
