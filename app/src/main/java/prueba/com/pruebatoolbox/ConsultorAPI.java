package prueba.com.pruebatoolbox;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConsultorAPI {

    /**
     * Metodo que simula una API de consulta
     *
     * @return objeto json con los datos a mostrar
     */
    public static JSONArray obtenerDatos() {

        JSONObject item1 = new JSONObject();
        try {
            item1.put("title", "La Playa");
            item1.put("url", "http://placeimg.com/320/480/any");
            item1.put("video", "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject item2 = new JSONObject();
        try {
            item2.put("title", "Peligro En Bangkok");
            item2.put("url", "http://placeimg.com/320/480/any");
            item2.put("video", "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject item3 = new JSONObject();
        try {
            item3.put("title", "Todas Contra John");
            item3.put("url", "http://placeimg.com/320/480/any");
            item3.put("video", "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject item4 = new JSONObject();
        try {
            item4.put("title", "Quisiera Ser Millonario");
            item4.put("url", "http://placeimg.com/320/480/any");
            item4.put("video", "http://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_320x180.mp4");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        JSONArray listaItems = new JSONArray();
        listaItems.put(item1);
        listaItems.put(item2);
        listaItems.put(item3);
        listaItems.put(item4);


        JSONObject carouselThumb = new JSONObject();
        try {
            carouselThumb.put("title","Carousel Thumb");
            carouselThumb.put("type","thumb");
            carouselThumb.put("items",listaItems);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject carouselPosters = new JSONObject();
        try {
            carouselPosters.put("title","Carousel Poster");
            carouselPosters.put("type","poster");
            carouselPosters.put("items",listaItems);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        JSONArray json = new JSONArray();
        json.put(carouselThumb);
        json.put(carouselPosters);

        return json;
    }
}
