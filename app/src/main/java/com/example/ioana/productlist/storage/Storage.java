package com.example.ioana.productlist.storage;

import com.example.ioana.productlist.model.Product;
import com.example.ioana.productlist.model.Shop;

import java.util.ArrayList;

/**
 * Created by Ioana on 04/03/2016.
 */
public class Storage {
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Shop> shops = new ArrayList<>();
    private static Storage uniqueInstance;

    private Storage() {
    }

    public static Storage getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Storage();
        }
        return uniqueInstance;
    }

    public ArrayList<Product> getProducts() {
        return new ArrayList<Product>(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }


    public ArrayList<Shop> getShops() {
        return new ArrayList<Shop>(shops);
    }

    public void addShop(Shop shop) {
        shops.add(shop);
    }

    public void removeShop(Shop shop) {
        shops.remove(shop);
    }
}
