package com.example.ioana.productlist.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ioana.productlist.R;
import com.example.ioana.productlist.service.Service;

/**
 * Created by Ioana on 02/03/2016.
 */
public class PopUpActivity extends Activity {
    Button SaveBtn;
    Button CancelBtn;
    EditText inputName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        final Context context = this;
        inputName = (EditText) findViewById(R.id.editText);
        SaveBtn = (Button) findViewById(R.id.saveButton);
        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!inputName.getText().toString().equals(""))
                {
                Service.createProductList(inputName.getText().toString());
                }
                Intent intent = new Intent(context, ShopsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        CancelBtn = (Button) findViewById(R.id.cancelButton);
        CancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
