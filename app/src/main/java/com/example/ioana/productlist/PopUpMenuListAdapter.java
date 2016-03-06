package com.example.ioana.productlist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ioana.productlist.activities.ProductsInListActivity;
import com.example.ioana.productlist.model.ProductList;
import com.example.ioana.productlist.service.Service;

import java.util.List;

/**
 * Created by Ioana on 06/03/2016.
 */
public class PopUpMenuListAdapter extends ArrayAdapter<ProductList> {
    LayoutInflater inflater;
    Context c;

    public PopUpMenuListAdapter(Context context, int resource, List<ProductList> lists) {
        super(context, resource, lists);
        this.c = context;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listlabel, null);
        }
        TextView buttonName = (TextView) convertView.findViewById(R.id.textView);

        final ProductList list = (ProductList) getItem(position);

        buttonName.setText(list.getName());

    return convertView;
    }

}
