package com.supershop.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.supershop.R;
import com.supershop.model.Product;

import java.util.ArrayList;

public class ProductListAdapter extends ArrayAdapter<Product> {
    Context mContext;
    ArrayList<Product> mProduct;

    public ProductListAdapter(Activity context, ArrayList<Product> product) {
        super(context, R.layout.custom_product_list, product);
        this.mContext=context;
        this.mProduct=product;

    }
//    public View getView(int position, View view, ViewGroup parent) {
//        LayoutInflater inflater=context.getLayoutInflater();
//        View rowView=inflater.inflate(R.layout.custom_product_list, null,true);
//
//        TextView titleText = (TextView) rowView.findViewById(R.id.title);
//        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
//        TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);
//
//        titleText.setText(maintitle[position]);
//        imageView.setImageResource(imgid[position]);
//        subtitleText.setText(subtitle[position]);
//
//        return rowView;
//
//    };

    public  class  Holder{
        TextView nameFV;
        ImageView pic;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position

        Product data = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view

        Holder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {


            viewHolder = new Holder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.custom_product_list, parent, false);

            viewHolder.nameFV = (TextView) convertView.findViewById(R.id.title);
            viewHolder.pic = (ImageView) convertView.findViewById(R.id.icon);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (Holder) convertView.getTag();
        }


        viewHolder.nameFV.setText(data.getProductName());
        viewHolder.pic.setImageBitmap(convertToBitmap(data.getProductImage()));


        // Return the completed view to render on screen
        return convertView;
    }
    //get bitmap image from byte array

    private Bitmap convertToBitmap(byte[] b){

        return BitmapFactory.decodeByteArray(b, 0, b.length);

    }

}