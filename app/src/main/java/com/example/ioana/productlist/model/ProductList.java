package com.example.ioana.productlist.model;

import java.util.ArrayList;

/**
 * Created by Ioana on 04/03/2016.
 */
public class ProductList {
    private String name;
    private ArrayList<Product> productsInList = new ArrayList<Product>();

    public ProductList() {
    }

    public ProductList(String name) {
        this.name = name;
    }

    public void update(ProductList productList) {
        name = productList.name;
    }

    public ProductList copy() {
        ProductList productList = new ProductList();
        productList.name = name;
        return productList;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void addProductInList(Product product) {
        productsInList.add(product);
    }
    public void removeProductFromList(Product product) {
        productsInList.remove(product);
    }
    public ArrayList<Product> getProductsInList() {
        return new ArrayList<Product>(productsInList);
    }

    @Override
    public String toString() {
        return  name + "\t ";
    }
}
