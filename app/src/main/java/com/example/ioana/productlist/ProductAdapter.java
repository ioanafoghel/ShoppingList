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

    public class ProductAdapter extends ArrayAdapter<String> {
  /*  public ProductAdapter(Context context,int resource, List<Product> products) {
        super(context,resource, products);
    }*/


    int[] imgs={};
    String[] productNames={};
    String[] productDescription ={};
    double[] productPrice={};
    double[] offers ={};
    Context c;
    LayoutInflater inflater;

    public class ViewHolder{
        TextView productName;
        TextView productDescription;
        TextView productPrice;
        TextView offer;
        ImageView img;
    }
    public ProductAdapter(Context context, String [] productNames, String [] productDescription, double[] productPrice, double[] offers, int[] imgs) {
            super(context, R.layout.model, productNames);
            this.c=context;
            this.productNames=productNames;
            this.productDescription=productDescription;
            this.productPrice=productPrice;
            this.offers=offers;
            this.imgs=imgs;
        }
   public View getView(int position, View convertView, ViewGroup parent){
   /*    if (convertView == null) {
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
    }*/

       if(convertView==null)
        {
            inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.model, null);

        }

        final ViewHolder holder=new ViewHolder();
        holder.productName=(TextView) convertView.findViewById(R.id.productName);
        holder.productDescription=(TextView) convertView.findViewById(R.id.productDescription);
        holder.productPrice=(TextView) convertView.findViewById(R.id.productPrice);
        holder.offer=(TextView) convertView.findViewById(R.id.offerPrice);
        holder.img=(ImageView) convertView.findViewById(R.id.imageView1);

        holder.productName.setText(productNames[position]);
        holder.productDescription.setText(productDescription[position]);
        holder.productPrice.setText("Price: "+productPrice[position]);
        holder.offer.setText("Offer: "+offers[position]);
        holder.img.setImageResource(imgs[position]);

        return convertView;
    }
}