package com.example.ioana.productlist;

import android.widget.ImageView;

/**
 * Created by Ioana on 24/02/2016.
 */
public class Product {

        private String name;
        private String description;
        private double price;
        private double offerPrice;
        private int img;

        public Product() {
        }

        public Product(int img, String name, String description, Double price, Double offerPrice) {
            this.img=img;
            this.name = name;
            this.description = description;
            this.price = price;
            this.offerPrice=offerPrice;
        }

        public void update(Product product) {
            img=product.img;
            name = product.name;
            description = product.description;
            price = product.price;
            offerPrice=product.offerPrice;
        }

        public Product copy() {
            Product product = new Product();
            product.img=img;
            product.name = name;
            product.description = description;
            product.price=price;
            product.offerPrice=offerPrice;
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


        @Override
        public String toString() {
            return  name + "\t " + price + "\n" + description +"\t";
        }


}
