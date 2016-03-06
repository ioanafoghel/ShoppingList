package com.example.ioana.productlist.model;

/**
 * Created by Ioana on 24/02/2016.
 */
public class Product {

        private String name;
        private String description;
        private double price;
        private double offerPrice;
        private int unit;
        private int img;
        private Shop shop;
        private ProductList productList;

        public Product() {
        }

        public Product(int img, String name, String description, Double price, Double offerPrice, int unit) {
            this.img=img;
            this.name = name;
            this.description = description;
            this.price = price;
            this.offerPrice=offerPrice;
            this.unit=unit;
        }

        public void update(Product product) {
            img=product.img;
            name = product.name;
            description = product.description;
            price = product.price;
            offerPrice=product.offerPrice;
            unit=product.unit;
        }

        public Product copy() {
            Product product = new Product();
            product.img=img;
            product.name = name;
            product.description = description;
            product.price=price;
            product.offerPrice=offerPrice;
            product.unit=unit;
            return product;
        }

        public int getImg(){
            return  img;
        }
        public void setImg(int img){
            this.img=img;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public Double getPrice(){
        return price;
        }
        public void setPrice(Double price) {
            this.price = price;
        }
        public Double getOfferPrice(){
        return offerPrice;
    }
        public void setOfferPrice(Double offerPrice){
            this.offerPrice=offerPrice;
        }
    public int getUnit(){return unit;}
    public void setUnit(int unit){this.unit=unit;}

        public void setShop(Shop shop) {
        this.shop = shop;
    }
        public Shop getShop() {
        return this.shop;
    }

        public void setProductList(ProductList productList) {
        this.productList = productList;
    }
        public ProductList getProductList() {
        return this.productList;
    }

        @Override
        public String toString() {
            return  name + "\t " + price + "\n" + description +"\t";
        }
}
