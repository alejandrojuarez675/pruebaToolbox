package prueba.com.pruebatoolbox;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private ArrayList<Carousel> listaCaroucel;
    private VideoView vv_video;
    private ProgressBar pb_barra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vv_video = findViewById(R.id.vv_video);
        pb_barra = findViewById(R.id.pb_barra);
        RecyclerView rv_recycler = findViewById(R.id.rv_lista_main);
        rv_recycler.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL,false));
        listaCaroucel = new ArrayList<>();

        cargarDatos();

        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(listaCaroucel);
        rv_recycler.setAdapter(adaptadorRecycler);

        IntentFilter filtro = new IntentFilter("com.pruebaToolbox.video");
        BroadcastReceiver recibidor = new SolicitudDeReproducir();
        registerReceiver(recibidor, filtro);
    }

    private void cargarDatos(){
        listaCaroucel.clear();

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
                        ""));

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
                        ""));
    }

    void reproducirVideo(String urlDelVideo){
        Uri uri = Uri.parse(urlDelVideo);
        vv_video.setVisibility(View.VISIBLE);
        vv_video.setMediaController(new MediaController(this));
        vv_video.setVideoURI(uri);
        vv_video.start();

        pb_barra.setVisibility(View.VISIBLE);
        vv_video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {
                        pb_barra.setVisibility(View.GONE);
                        mediaPlayer.start();
                    }
                });
            }
        });
    }

    private class SolicitudDeReproducir extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String url = intent.getStringExtra("video");
            if (!url.equals("")){
                reproducirVideo(url);
                Toast.makeText(getApplicationContext(), "Cargando video", Toast.LENGTH_LONG).show();
            }
            else {
                vv_video.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "Video no disponible", Toast.LENGTH_LONG).show();
            }
        }
    }
}
