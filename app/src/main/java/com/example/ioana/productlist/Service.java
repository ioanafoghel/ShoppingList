package com.example.ioana.productlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ioana on 24/02/2016.
 */
public class Service {
        private List<Product> products = new ArrayList<Product>();

        public Service() {
            String[] productNames={"Kinder Bueno","Kinder Chocolate 4", "Kinder Chocolate 8", "Kinder Country","Kinder Delice","Kinder Pinguin","Kinder Schoko-Bons","Kinder Surprise"};
            String[] productDescriptions={"23g","100g","200g","30g","50g","100g","230g","12g"};
            double[] productPrice={15,30,40,20,23.9,50,50,35};
            double[] offers={12,25,38,18,20.9,30,30,32};
            int[] imgs={R.drawable.kinder_bueno,R.drawable.kinder_chocolate4,R.drawable.kinder_chocolate8,R.drawable.kinder_country,R.drawable.kinder_delice,R.drawable.kinder_pinguin,R.drawable.kinder_schoko_bons,R.drawable.kinder_surprise};
            for (int i = 1; i < productNames.length; i++) {
               Product product= new Product(imgs[i]," "+productNames[i]," "+productDescriptions[i], productPrice[i],offers[i]);
                products.add(product);
            }
        }

        public List<Product> getProducts() {
            return products;
        }

        public void addProduct(Product product) {
            products.add(product);
        }

        public void removeProduct(Product product) {
            products.remove(product);
        }
    }

