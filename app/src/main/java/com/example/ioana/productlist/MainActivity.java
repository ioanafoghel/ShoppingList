package com.example.ioana.productlist;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

   ListView lv;
    String[] productNames={"Kinder Bueno","Kinder Chocolate 4", "Kinder Chocolate 8", "Kinder Country","Kinder Delice","Kinder Pinguin","Kinder Schoko-Bons","Kinder Surprise"};
    String[] productDescriptions={"23g","100g","200g","30g","50g","100g","230g","12g"};
    double[] productPrice={15,30,40,20,23.9,50,50,35};
    double[] offers={12,25,38,18,20.9,30,30,32};
    int[] imgs={R.drawable.kinder_bueno,R.drawable.kinder_chocolate4,R.drawable.kinder_chocolate8,R.drawable.kinder_country,R.drawable.kinder_delice,R.drawable.kinder_pinguin,R.drawable.kinder_schoko_bons,R.drawable.kinder_surprise};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView) findViewById(R.id.listView);
        ProductAdapter productAdapter=new ProductAdapter(this, productNames, productDescriptions, productPrice, offers, imgs);
        lv.setAdapter(productAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),productNames[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
  /*  final ListView listView = (ListView) findViewById(R.id.listView);
    ProductAdapter productArrayAdapter
            = new ProductAdapter(this, -1, service.getProducts());
    listView.setAdapter(productArrayAdapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent,
                View view, int position, long id) {
            Toast.makeText(MainActivity.this,
                    listView.getItemAtPosition(position) + " " +
                            getText(R.string.clicked), Toast.LENGTH_SHORT).show();
        }
    });*/
}

