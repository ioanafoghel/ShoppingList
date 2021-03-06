package com.example.ioana.productlist.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ioana.productlist.R;
import com.example.ioana.productlist.ShopAdapter;
import com.example.ioana.productlist.service.Service;

/**
 * Created by Ioana on 04/03/2016.
 */
public class ShopsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.home_icon);


        final ListView listView = (ListView) findViewById(R.id.shopslistView);
        ShopAdapter shopArrayAdapter
                = new ShopAdapter(this, 0, Service.getShops());
        listView.setAdapter(shopArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                        Intent shopInfo = new Intent(ShopsActivity.this, ProductsActivity.class);
                        shopInfo.putExtra("shopIndex",position);
                        startActivity(shopInfo);
                    }
                });
    }
}
