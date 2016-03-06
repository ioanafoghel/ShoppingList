package com.example.ioana.productlist.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ioana.productlist.ProductAdapter;
import com.example.ioana.productlist.ProductListAdapter;
import com.example.ioana.productlist.R;
import com.example.ioana.productlist.service.Service;

/**
 * Created by Ioana on 05/03/2016.
 */
public class ProductsInListActivity extends AppCompatActivity {
int listIndex;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.home_icon);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            listIndex = extras.getInt("listIndex");
        }

        final ListView listView = (ListView) findViewById(R.id.listView);
        ProductAdapter productArrayAdapter
                = new ProductAdapter(this, 0, Service.getProductsForList(listIndex).getProductsInList());
        listView.setAdapter(productArrayAdapter);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

     /* SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));*/

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            onSearchRequested();
            return true;
        }

        if (id == R.id.menu_Save) {
            Toast.makeText(getApplicationContext(),
                    "List saved", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
