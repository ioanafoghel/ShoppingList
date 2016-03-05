package com.example.ioana.productlist.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ioana.productlist.ProductListAdapter;
import com.example.ioana.productlist.R;
import com.example.ioana.productlist.service.Service;

/**
 * Created by Ioana on 05/03/2016.
 */
public class ProductListsActivity extends AppCompatActivity {
    @Override
   protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productlist);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.home_icon);

        final ListView listView = (ListView) findViewById(R.id.listslistView);
        ProductListAdapter productListAdapter
                = new ProductListAdapter(this, 0, Service.getProductLists());
        listView.setAdapter(productListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {

                Intent shopInfo = new Intent(context, ProductsInListActivity.class);
                startActivity(shopInfo);
            }
        });
    }
}



