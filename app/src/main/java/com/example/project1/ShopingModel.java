package com.example.project1;

public class ShopingModel {

    int img;
    String Img;

    public void setImg(String img) {
        Img = img;
    }

    String tittle,id;

    public ShopingModel(int img, String id, String tittle) {
        this.img = img;
        this.id = id;
        this.tittle = tittle;
    }
    public ShopingModel(String Img, String id, String tittle) {
        this.Img = Img;
        this.id = id;
        this.tittle = tittle;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
