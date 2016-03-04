package com.example.ioana.productlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ioana.productlist.model.Shop;

import java.util.List;

/**
 * Created by Ioana on 04/03/2016.
 */
public class ShopAdapter extends ArrayAdapter<Shop> {
    LayoutInflater inflater;
    Context c;

    public ShopAdapter(Context context,int resource, List<Shop> shops) {
        super(context,resource,shops);
        this.c=context;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView == null) {
            inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.shop, null);
        }

        ImageView textView1 = (ImageView) convertView.findViewById(R.id.shopImage);
        TextView textView2 = (TextView) convertView.findViewById(R.id.shopName);
        TextView textView3 = (TextView) convertView.findViewById(R.id.shopAddress);
        final Shop shop = (Shop) getItem(position);

        textView1.setImageResource(shop.getShopImg());
        textView2.setText(shop.getName());
        textView3.setText(shop.getAddress());

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), shop.getName() + " " +
                                getContext().getText(R.string.clicked),
                        Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
