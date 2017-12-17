package com.example.rajithaperera.mercari;

/**
 * Created by rajithaperera on 12/12/17.
 */

public class Item {
    String id,name,status,photo;
    int num_likes,num_comments,price;

    public Item() {
    }

    //    public Item(String id, String name, String status, String photo, int num_likes, int num_comments, int price) {
//        this.id = id;
//        this.name = name;
//        this.status = status;
//        this.photo = photo;
//        this.num_likes = num_likes;
//        this.num_comments = num_comments;
//        this.price = price;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getNum_likes() {
        return num_likes;
    }

    public void setNum_likes(int num_likes) {
        this.num_likes = num_likes;
    }

    public int getNum_comments() {
        return num_comments;
    }

    public void setNum_comments(int num_comments) {
        this.num_comments = num_comments;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
