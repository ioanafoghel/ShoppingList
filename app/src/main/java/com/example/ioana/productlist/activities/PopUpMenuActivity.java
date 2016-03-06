package com.example.ioana.productlist.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.ioana.productlist.ProductListAdapter;
import com.example.ioana.productlist.R;
import com.example.ioana.productlist.ShopAdapter;
import com.example.ioana.productlist.service.Service;

/**
 * Created by Ioana on 06/03/2016.
 */
public class PopUpMenuActivity extends AppCompatActivity {
    int productIndex;
    int shopIndex;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productlist);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            shopIndex = extras.getInt("shopIndex");
        }

        final ListView listView = (ListView) findViewById(R.id.listslistView);
        final ProductListAdapter productListAdapter
                = new ProductListAdapter(this, 0, Service.getProductLists());
        listView.setAdapter(productListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                parent.getItemAtPosition(position);
                Intent shopInfo = new Intent(PopUpMenuActivity.this, ProductListsActivity.class);
                Service.addProductToList(position,shopIndex,productIndex);
                startActivity(shopInfo);
            }
        });
    }
}
