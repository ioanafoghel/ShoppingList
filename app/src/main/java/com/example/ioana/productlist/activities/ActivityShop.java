package com.example.ioana.productlist.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ioana.productlist.R;
import com.example.ioana.productlist.ShopAdapter;
import com.example.ioana.productlist.service.Service;

/**
 * Created by Ioana on 04/03/2016.
 */
public class ActivityShop extends AppCompatActivity {

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
                Toast.makeText(ActivityShop.this,
                        listView.getItemAtPosition(position) + " " +
                                getText(R.string.clicked), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
