package com.example.ioana.productlist.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.ioana.productlist.R;

/**
 * Created by Ioana on 02/03/2016.
 */
public class PopUpActivity extends Activity {
    Button SaveBtn;
    Button CancelBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        final Context context = this;
        SaveBtn = (Button) findViewById(R.id.saveButton);
        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityShop.class);
                startActivity(intent);
            }
        });

        CancelBtn = (Button) findViewById(R.id.cancelButton);
        CancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AppActivity.class);
                startActivity(intent);
            }
        });
    }
}
