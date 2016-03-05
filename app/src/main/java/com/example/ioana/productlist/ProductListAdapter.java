package com.example.ioana.productlist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.ioana.productlist.activities.ProductsInListActivity;
import com.example.ioana.productlist.model.ProductList;
import com.example.ioana.productlist.service.Service;

import java.util.List;

/**
 * Created by Ioana on 05/03/2016.
 */
public class ProductListAdapter extends ArrayAdapter<ProductList> {
    LayoutInflater inflater;
    Context c;

    public ProductListAdapter(Context context, int resource, List<ProductList> lists) {
        super(context, resource, lists);
        this.c = context;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.productlist, null);
        }

        Button buttonName = (Button) convertView.findViewById(R.id.listButton);

        final ProductList list = (ProductList) getItem(position);

        buttonName.setText(list.getName());

        buttonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), list.getName() + " " +
                                getContext().getText(R.string.clicked),
                        Toast.LENGTH_SHORT).show();
                Intent shopInfo = new Intent(c, ProductsInListActivity.class);
                c.startActivity(shopInfo);

            }
        });
        buttonName.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Service.removeProductList(position);
                notifyDataSetChanged();
                return true;
            }
        });
        return convertView;
    }
}
