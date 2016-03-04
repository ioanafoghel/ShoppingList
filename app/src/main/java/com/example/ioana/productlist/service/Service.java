package com.example.ioana.productlist.service;

import com.example.ioana.productlist.R;
import com.example.ioana.productlist.model.Product;
import com.example.ioana.productlist.model.Shop;
import com.example.ioana.productlist.storage.Storage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ioana on 24/02/2016.
 */
public class Service {

    public static ArrayList<Product> getProducts()
    {
        return Storage.getInstance().getProducts();
    }

    public static Product createProduct(int img, String name, String description, Double price, Double offerPrice)
    {
        Product product = new Product(img,name, description, price,offerPrice);
        Storage.getInstance().addProduct(product);
        return product;
    }

    public static void deleteProduct(Product product)
    {
        Storage.getInstance().removeProduct(product);
    }

    public static void updateProduct(Product product, int img, String name, String description, Double price, Double offerPrice)
    {
        product.setImg(img);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setOfferPrice(offerPrice);
    }

    public static ArrayList<Shop> getShops()
    {
        return Storage.getInstance().getShops();
    }

    public static Shop createShop(int img, String name, String address)
    {
        Shop shop = new Shop(img, name, address);
        Storage.getInstance().addShop(shop);
        return shop;
    }

    public static void deleteShop(Shop shop)
    {
        Storage.getInstance().removeShop(shop);
    }

    public static void updateShop(Shop shop, int img, String name, String address)
    {
        shop.setShopImg(img);
        shop.setName(name);
        shop.setAddress(address);
    }



    public static void createSomeObjects() {
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
            Product product = Service.createProduct(imgs[i], " " + productNames[i], " " + productDescriptions[i], productPrice[i], offers[i]);
            products.add(product);
        }
        ArrayList<Shop> shops =new ArrayList<Shop>();
        for (int j = 0; j < shopNames.length; j++) {
            Shop shop = Service.createShop(shopsImgs[j], " " + shopNames[j], " " + shopsAddresses[j]);
            shops.add(shop);



       /*     Product product1= Service.createProduct(R.drawable.kinder_bueno,"Kinder Bueno", "23g",15.7,12.0);
            Product product2= Service.createProduct(R.drawable.kinder_chocolate4,"Kinder Chocolate 4", "100g",30.0,25.0);
            Product product3= Service.createProduct(R.drawable.kinder_chocolate8,"Kinder Chocolate 4", "200g",40.7,38.0);
            Product product4= Service.createProduct(R.drawable.kinder_country, "Kinder Country", "30g",23.7,22.0);
            Product product5= Service.createProduct(R.drawable.kinder_delice,"Kinder Delice", "23g",15.7,12.0);
            Product product6= Service.createProduct(R.drawable.kinder_pinguin,"Kinder Pinguin", "23g",15.7,12.0);
            Product product7= Service.createProduct(R.drawable.kinder_schoko_bons, "Kinder Schoko-Bons", "23g", 15.7, 12.0);
            Product product8= Service.createProduct(R.drawable.kinder_surprise, "Kinder Surprise", "23g", 15.7, 12.0);
            Shop shop1 = Service.createShop(R.drawable.aldi_icon, "Aldi", "asamns");
            Shop shop2 = Service.createShop(R.drawable.bilka_icon,"Bilka","asamnsjnd");
            Shop shop3 = Service.createShop(R.drawable.fotex_icon,"Føtex","afeksamns");
            Shop shop4 = Service.createShop(R.drawable.lidl_icon,"Lidl","asamns");
            Shop shop5 = Service.createShop(R.drawable.rema_icon,"Rema","asamns");
            Shop shop6 = Service.createShop(R.drawable.netto_icon,"Netto","asamns");
            shop1.addProductInList(product1);
            shop1.addProductInList(product2);
            shop1.addProductInList(product3);
            shop1.addProductInList(product4);
            shop1.addProductInList(product5);
            shop1.addProductInList(product6);
            shop1.addProductInList(product7);
            shop1.addProductInList(product8);
            */
        }
    }
}

