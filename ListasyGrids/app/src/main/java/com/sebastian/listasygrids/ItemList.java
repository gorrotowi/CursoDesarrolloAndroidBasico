package com.sebastian.listasygrids;

/**
 * Created by Gorro on 21/10/16.
 */

public class ItemList {

    private String title, subtitle;
    private int img;

    public ItemList(String title, String subtitle, int img) {
        this.title = title;
        this.subtitle = subtitle;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
