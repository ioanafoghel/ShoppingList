package com.example.ioana.productlist.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ioana.productlist.ProductAdapter;
import com.example.ioana.productlist.ProductListAdapter;
import com.example.ioana.productlist.R;
import com.example.ioana.productlist.service.Service;

/**
 * Created by Ioana on 05/03/2016.
 */
public class ProductsInListActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.home_icon);

        final ListView listView = (ListView) findViewById(R.id.listView);
        ProductAdapter productArrayAdapter
                = new ProductAdapter(this, 0, Service.getProducts());
        listView.setAdapter(productArrayAdapter);
    }
}
