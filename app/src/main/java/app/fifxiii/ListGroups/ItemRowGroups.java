package app.fifxiii.ListGroups;

import android.graphics.drawable.Drawable;

public class ItemRowGroups {

    String name, contry;
    Drawable img;

    public String getContrGroupy() {
        return contry;
    }

    public void setContryGroup(String contry) {
        this.contry = contry;
    }

    public  ItemRowGroups(){}

    public String getNameListGroup() {
        return name;
    }

    public void setNameListGroup(String name) {
        this.name = name;
    }

    public Drawable getImgListGroup() {
        return img;
    }

    public void setImgListGroup(Drawable img) {
        this.img = img;
    }
}
