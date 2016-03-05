package com.example.ioana.productlist.service;

import com.example.ioana.productlist.R;
import com.example.ioana.productlist.model.Product;
import com.example.ioana.productlist.model.ProductList;
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

    public static void removeProduct(Product product)
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

    public static void removeShop(Shop shop)
    {
        Storage.getInstance().removeShop(shop);
    }

    public static void updateShop(Shop shop, int img, String name, String address)
    {
        shop.setShopImg(img);
        shop.setName(name);
        shop.setAddress(address);
    }
    public static ArrayList<ProductList> getProductLists()
    {
        return Storage.getInstance().getProductLists();
    }

    public static ProductList createProductList(String name)
    {
        ProductList productList = new ProductList(name);
        Storage.getInstance().addProductList(productList);
        return productList;
    }

    public static void removeProductList(ProductList productList)
    {
        Storage.getInstance().removeProductList(productList);
    }

    public static void updateProductList(ProductList productList, String name)
    {
        productList.setName(name);
    }

}


