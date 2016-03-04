package com.example.ioana.productlist.model;

import java.util.ArrayList;

/**
 * Created by Ioana on 04/03/2016.
 */
public class Shop {
    private int img;
    private String name;
    private String address;
    private ArrayList<Product> productsInShop = new ArrayList<Product>();

    public Shop() {
    }

    public Shop(int img, String name, String address) {
        this.img=img;
        this.name = name;
        this.address = address;
    }

    public void update(Shop shop) {
        img=shop.img;
        name = shop.name;
        address = shop.address;
    }

    public Shop copy() {
        Shop shop = new Shop();
        shop.img=img;
        shop.name = name;
        shop.address = address;
        return shop;
    }

    public int getShopImg(){
        return  img;
    }
    public void setShopImg(int img){
        this.img=img;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void addProductInShop(Product product) {
        productsInShop.add(product);
    }
    public void removeProductFromShop(Product product) {
        productsInShop.remove(product);
    }
    public ArrayList<Product> getProductsInShop() {
        return new ArrayList<Product>(productsInShop);
    }

    @Override
    public String toString() {
        return  name + "\t " + address;
    }
}
