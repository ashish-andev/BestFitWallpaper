package com.example.myapplication.model;

public class Wallpaper {

    private int height;
    private int width;
    private String imageUrl;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Wallpaper(int width, int height, String imageUrl) {
        this.width = width;
        this.height = height;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Wallpaper{" +
                "width=" + width +
                ", height=" + height +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
