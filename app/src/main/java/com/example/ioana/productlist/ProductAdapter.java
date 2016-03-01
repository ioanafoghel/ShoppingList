package com.example.ioana.productlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.StringBufferInputStream;
import java.util.List;

/**
 * Created by Ioana on 24/02/2016.
 */

    public class ProductAdapter extends ArrayAdapter<Product> {
   public ProductAdapter(Context context,int resource, List<Product> products) {
        super(context,resource, products);
       this.c=context;
    }
    LayoutInflater inflater;
    Context c;


   public View getView(int position, View convertView, ViewGroup parent){
      if (convertView == null) {
            inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.model, null);

        }

        ImageView textView1 = (ImageView) convertView.findViewById(R.id.imageView1);
        TextView textView2 = (TextView) convertView.findViewById(R.id.productName);
        TextView textView3 = (TextView) convertView.findViewById(R.id.productDescription);
        TextView textView4 = (TextView) convertView.findViewById(R.id.productPrice);
        TextView textView5 = (TextView) convertView.findViewById(R.id.offerPrice);
        final Product product = (Product) getItem(position);

        textView1.setImageResource(product.getImg());
        textView2.setText(product.getName());
        textView3.setText(product.getDescription());
        textView4.setText("Price: "+product.getPrice());
        textView5.setText("Offer: "+product.getOfferPrice());

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), product.getName() + " " +
                                getContext().getText(R.string.clicked),
                        Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}