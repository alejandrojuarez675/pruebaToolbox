package prueba.com.pruebatoolbox;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class InterpretadorConsultaApi {

    public static ArrayList<Carousel> jsonToListaCarouseles(JSONArray jsonArray){
        JSONObject jsonCarousel;
        ArrayList<Carousel> lista = new ArrayList<>();
        for (int i=0;i<jsonArray.length();i++){
            try {
                jsonCarousel = new JSONObject(jsonArray.get(i).toString());
                lista.add(new Carousel(
                        jsonCarousel.getString("title"),
                        jsonCarousel.getString("type")));
                JSONObject jsonItem;
                JSONArray jsonArrayItems = jsonCarousel.getJSONArray("items");
                for (int j=0; j<jsonArrayItems.length();j++){
                    jsonItem = new JSONObject(jsonArrayItems.get(j).toString());
                    lista.get(i).addItem(new Item(
                            jsonItem.getString("title"),
                            jsonItem.getString("url"),
                            jsonItem.getString("video")));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }
}
