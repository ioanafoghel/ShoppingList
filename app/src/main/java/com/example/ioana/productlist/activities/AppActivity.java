package com.example.ioana.productlist.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.ioana.productlist.R;

/**
 * Created by Ioana on 02/03/2016.
 */
public class AppActivity extends AppCompatActivity {
    Button button;
    Button buttonShop;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        final Context context = this;
        button = (Button) findViewById(R.id.createButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PopUpActivity.class);
                startActivity(intent);
            }
        });
        buttonShop = (Button) findViewById(R.id.shopsButton);
        buttonShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityShop.class);
                startActivity(intent);
            }
        });
    }
}