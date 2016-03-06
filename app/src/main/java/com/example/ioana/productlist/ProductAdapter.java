package com.example.ioana.productlist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ioana.productlist.activities.PopUpMenuActivity;
import com.example.ioana.productlist.model.*;
import com.example.ioana.productlist.service.Service;

import java.util.List;

/**
 * Created by Ioana on 24/02/2016.
 */

public class ProductAdapter extends ArrayAdapter<Product> {
    LayoutInflater inflater;
    Context c;
    public ProductAdapter(Context context,int resource, List<Product> products) {
       super(context,resource, products);
       this.c=context;
    }

    public View getView(int position, View convertView, ViewGroup parent){
      if (convertView == null) {
            inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.product, null);
        }

        final ImageView textView1 = (ImageView) convertView.findViewById(R.id.imageView1);
        final TextView textView2 = (TextView) convertView.findViewById(R.id.productName);
        final TextView textView3 = (TextView) convertView.findViewById(R.id.productDescription);
        final TextView textView4 = (TextView) convertView.findViewById(R.id.productPrice);
        final TextView textView5 = (TextView) convertView.findViewById(R.id.offerPrice);
        final TextView textView6 = (TextView) convertView.findViewById(R.id.numberTextId);
        final Product product = (Product) getItem(position);
        ImageButton imgBtn= (ImageButton) convertView.findViewById(R.id.imageButton);
        Button btnPlus= (Button) convertView.findViewById(R.id.plusButton);
        Button btnMinus= (Button) convertView.findViewById(R.id.minusButton);


        textView1.setImageResource(product.getImg());
        textView2.setText(product.getName());
        textView3.setText(product.getDescription());
        textView4.setText("Price: "+product.getPrice());
        textView5.setText("Offer: "+product.getOfferPrice());

        imgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, PopUpMenuActivity.class);
                c.startActivity(intent);

            }
        });

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setEnabled(false);
                v.setBackgroundColor(Color.GRAY);
                Toast.makeText(getContext(), product.getName() + " " +
                                getContext().getText(R.string.clicked),
                        Toast.LENGTH_SHORT).show();
            }
        });
        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.setEnabled(false);
                v.setBackgroundColor(Color.BLUE);
                notifyDataSetChanged();
                return true;
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String[] standardVolume = product.getDescription().split(" ");
                String[] selectedVolume = ((String) textView3.getText()).split(" ");
                double standard = Double.parseDouble(standardVolume[0]);
                double selected = Double.parseDouble(selectedVolume[0]) + standard;
                textView3.setText(selected + " " + standardVolume[1]);
                //updates offer and normal prices displayed
                textView4.setText("Price: " + Math.round((selected / standard * product.getPrice()) * 100d) / 100d);
                textView5.setText("Offer: " + Math.round((selected / standard * product.getOfferPrice()) * 100d) / 100d);
                textView6.setText("" + (Integer.parseInt((String) textView6.getText()) + 1));
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String[] standardVolume=product.getDescription().split(" ");
                String[] selectedVolume=((String)textView3.getText()).split(" ");
                double standard=Double.parseDouble(standardVolume[0]);
                double selected=Double.parseDouble(selectedVolume[0]);
                if (standard<selected) {
                    selected = selected - standard;
                    textView3.setText(selected + " " + standardVolume[1]);
                    //updates offer and normal prices displayed
                    textView4.setText("Price: "+Math.round((selected/standard*product.getPrice())* 100d)/100d);
                    textView5.setText("Offer: "+Math.round((selected / standard * product.getOfferPrice())* 100d)/100d);
                    textView6.setText(""+(Integer.parseInt((String) textView6.getText()) - 1));
                }
            }
        });

        return convertView;
    }
}