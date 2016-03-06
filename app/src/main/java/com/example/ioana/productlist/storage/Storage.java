package com.example.ioana.productlist.storage;

import com.example.ioana.productlist.R;
import com.example.ioana.productlist.model.Product;
import com.example.ioana.productlist.model.ProductList;
import com.example.ioana.productlist.model.Shop;
import com.example.ioana.productlist.service.Service;

import java.util.ArrayList;

/**
 * Created by Ioana on 04/03/2016.
 */
public class Storage {
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Shop> shops = new ArrayList<>();
    private ArrayList<ProductList> productLists = new ArrayList<>();
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
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }
    public void removeProduct(int productIndex) {
        products.remove(productIndex);
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

    public ArrayList<ProductList> getProductLists() {
        return productLists;
    }

    public void addProductList(ProductList productList) {
        productLists.add(productList);
    }

    public void removeProductList(ProductList productList) {
        productLists.remove(productList);
    }
    public void removeProductList(int productIndex) {
        productLists.remove(productIndex);
    }
    public  ProductList createProductList(String name)
    {
        ProductList productList = new ProductList(name);
        uniqueInstance.addProductList(productList);
        return productList;
    }
    public  void updateProductList(ProductList productList, String name)
    {
        productList.setName(name);
    }
    public ArrayList<Shop> getShops() {
        return shops;
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
        String[] productListNames= {"Saturday snack", "Halloween  candy", "Kids rewards"};
        ArrayList<Product> products = new ArrayList<Product>();
      /*  for (int i = 0; i < productNames.length; i++) {
            Product product = uniqueInstance.createProduct(imgs[i], " " + productNames[i], " " + productDescriptions[i], productPrice[i], offers[i]);
            products.add(product);
        }
        ArrayList<Shop> shops = new ArrayList<Shop>();
        for (int i = 0; i < shopNames.length; i++) {
            Shop shop = uniqueInstance.createShop(shopsImgs[i], " " + shopNames[i], " " + shopsAddresses[i]);
            for (int j=0; j<productNames.length; j++){
                Product product = uniqueInstance.createProduct(imgs[j], " " + productNames[j], " " + productDescriptions[j], productPrice[j], offers[j]);
                shop.addProductInShop(product);
            }
            shops.add(shop);
        }
        ArrayList<ProductList> productLists = new ArrayList<ProductList>();
        for (int i = 0; i < productListNames.length; i++) {
            ProductList productList = uniqueInstance.createProductList(productListNames[i]);
            for (int j=0; j<productNames.length; j++){
                Product product = uniqueInstance.createProduct(imgs[j], " " + productNames[j], " " + productDescriptions[j], productPrice[j], offers[j]);
                productList.addProductInList(product);
            }
            productLists.add(productList);
        }

        Shop s1 = Service.createShop(R.drawable.bilka_icon, "Bilka", "BBbb");
        Product p1=Service.createProduct(R.drawable.kinder_bueno,"Kinder Bueno","23g",12.3,10.0);
        s1.addProductInShop(p1);
        ProductList l1=Service.createProductList("Christmas Shopping");
        l1.addProductInList(p1);
    }*/

        Shop s1 = Service.createShop(R.drawable.bilka_icon, "Bilka", "BBbb");
        Product p1=Service.createProduct(R.drawable.kinder_bueno,"Kinder Bueno","23g",12.3,10.0);
        s1.addProductInShop(p1);}
    public void addProductToList(int listIndex, int shopIndex, int productIndex){
        ProductList productList= getProductLists().get(listIndex);
        Shop shop= getShops().get(shopIndex);
        Product product = shop.getProductsInShop().get(productIndex);
        productList.addProductInList(product);
    }

}