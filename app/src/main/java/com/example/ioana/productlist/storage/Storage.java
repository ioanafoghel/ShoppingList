package com.example.ioana.productlist.storage;

import com.example.ioana.productlist.R;
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
            uniqueInstance.createSomeObjects();
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
    public Product createProduct(int img, String name, String description, Double price, Double offerPrice)
    {
        Product product = new Product(img,name, description, price,offerPrice);
        uniqueInstance.addProduct(product);
        return product;
    }
    public void updateProduct(Product product, int img, String name, String description, Double price, Double offerPrice)
    {
        product.setImg(img);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setOfferPrice(offerPrice);
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
    public  Shop createShop(int img, String name, String address)
    {
        Shop shop = new Shop(img, name, address);
        uniqueInstance.addShop(shop);
        return shop;
    }
    public  void updateShop(Shop shop, int img, String name, String address)
    {
        shop.setShopImg(img);
        shop.setName(name);
        shop.setAddress(address);
    }

    public  void createSomeObjects() {
        String[] productNames = {"Kinder Bueno", "Kinder Chocolate 4", "Kinder Chocolate 8", "Kinder Country", "Kinder Delice", "Kinder Pinguin", "Kinder Schoko-Bons", "Kinder Surprise"};
        String[] productDescriptions = {"23g", "100g", "200g", "30g", "50g", "100g", "230g", "12g"};
        double[] productPrice = {15, 30, 40, 20, 23.9, 50, 50, 35};
        double[] offers = {12, 25, 38, 18, 20.9, 30, 30, 32};
        int[] imgs = {R.drawable.kinder_bueno, R.drawable.kinder_chocolate4, R.drawable.kinder_chocolate8, R.drawable.kinder_country, R.drawable.kinder_delice, R.drawable.kinder_pinguin, R.drawable.kinder_schoko_bons, R.drawable.kinder_surprise};
        String[] shopNames = {"Aldi", "Bilka", "FØtex", "Lidl", "Rema 1000", "Netto"};
        String[] shopsAddresses = {"AAaa", "BBb", "Ccc", "Ddd", "Eee", "ffff"};
        int[] shopsImgs = {R.drawable.aldi_icon, R.drawable.bilka_icon, R.drawable.fotex_icon, R.drawable.lidl_icon, R.drawable.rema_icon, R.drawable.netto_icon};
        ArrayList<Product> products = new ArrayList<Product>();
        for (int i = 0; i < productNames.length; i++) {
            Product product = uniqueInstance.createProduct(imgs[i], " " + productNames[i], " " + productDescriptions[i], productPrice[i], offers[i]);
            products.add(product);
        }
        ArrayList<Shop> shops = new ArrayList<Shop>();
        for (int j = 0; j < shopNames.length; j++) {
            Shop shop = uniqueInstance.createShop(shopsImgs[j], " " + shopNames[j], " " + shopsAddresses[j]);
            shops.add(shop);
        }
    }
}