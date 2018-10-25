package prueba.com.pruebatoolbox;

import java.util.ArrayList;

public class Carousel {

    private String title;
    private String type;
    private ArrayList<Item> items;

    public Carousel(String title, String type) {
        this.title = title;
        this.type = type;
        items = new ArrayList<>();
    }

    public void addItem(Item it){
        items.add(it);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
