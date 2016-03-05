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
import com.example.ioana.productlist.R;
import com.example.ioana.productlist.service.Service;

public class App2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.home_icon);

        final ListView listView = (ListView) findViewById(R.id.listView);
        ProductAdapter productArrayAdapter
                = new ProductAdapter(this, 0, Service.getProducts());
        listView.setAdapter(productArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                Toast.makeText(App2Activity.this,
                        listView.getItemAtPosition(position) + " " +
                                getText(R.string.clicked), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

     /* SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));*/

        return true;
    }

    @Override
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

        if(id == R.drawable.home_icon){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
    public boolean onSearchRequested() {
        Bundle appData = new Bundle();
        appData.putString("hello", "world");
        startSearch(null, false, appData, false);
        return true;
    }
}

