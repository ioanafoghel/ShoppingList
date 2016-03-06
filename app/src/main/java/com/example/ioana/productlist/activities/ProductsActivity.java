package com.example.ioana.productlist.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ioana.productlist.ProductAdapter;
import com.example.ioana.productlist.R;
import com.example.ioana.productlist.model.Product;
import com.example.ioana.productlist.service.Service;

import java.io.Serializable;

public class ProductsActivity extends AppCompatActivity implements Serializable {
    ImageButton SelectBtn;
    final Context context = this;
    int shopIndex ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.home_icon);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            shopIndex = extras.getInt("shopIndex");
        }



        final ListView listView = (ListView) findViewById(R.id.listView);
        final ProductAdapter productArrayAdapter
                = new ProductAdapter(this, 0, Service.getProducts());
        listView.setAdapter(productArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                int selectedProduct= position;
                Intent intent= new Intent(context, PopUpMenuActivity.class);
                intent.putExtra("productObject", selectedProduct);
                intent.putExtra("shopIndex",shopIndex);
                startActivity(intent);
            }
        });
    }
    public void addListenerOnButton() {
        SelectBtn = (ImageButton) findViewById(R.id.imageButton);
        SelectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PopUpMenuActivity.class);
                startActivity(intent);
                finish();
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

