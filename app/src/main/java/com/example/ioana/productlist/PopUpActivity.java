package com.example.ioana.productlist;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.view.ViewGroup.LayoutParams;

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
                Intent intent = new Intent(context, App2Activity.class);
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
