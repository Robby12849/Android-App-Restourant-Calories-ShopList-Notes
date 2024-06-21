package debari.roberto.adapter;

public class Città {
    private int imageResource;
    private String text;
    public Città(int imageResource, String text) {
        this.imageResource = imageResource;
        this.text = text;
    }
    public int getImageResource() {
        return imageResource;
    }
    public String getText() {
        return text;
    }
}
