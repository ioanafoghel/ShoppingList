package com.example.ioana.productlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Ioana on 04/03/2016.
 */
public class ActivityShop extends AppCompatActivity {
    private Service service= new Service();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.home_icon);

        final ListView listView = (ListView) findViewById(R.id.shopslistView);
        ShopAdapter shopArrayAdapter
                = new ShopAdapter(this, 0, service.getShops());
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
