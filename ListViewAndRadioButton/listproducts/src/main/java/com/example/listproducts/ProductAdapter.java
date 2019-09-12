package com.example.listproducts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

@SuppressLint("DefaultLocale")
public class ProductAdapter extends ArrayAdapter<Product> {

    private int resourceID;

    public ProductAdapter(Context context, int resource, List<Product> products) {
        super(context, resource, products);
        resourceID = resource;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent) {
        View myView = currentView;

        myView = inflateView(myView);

        TextView textProduct = myView.findViewById(R.id.textProduct);
        TextView textAmount = myView.findViewById(R.id.textAmount);

        Product product = getItem(position);

        setPriorityColor(textProduct, textAmount, product);

        textProduct.setText(product.getName());
        textAmount.setText(String.format("%.2f %s", product.getAmount(),
                product.getType()));

        return myView;
    }

    private View inflateView(View myView) {
        if(myView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(resourceID, null);
        }
        return myView;
    }

    private void setPriorityColor(TextView textProduct, TextView textAmount, Product product) {
        if (product.isPriority()) {
            textProduct.setTextColor(Color.RED);
            textAmount.setTextColor(Color.RED);
        }
    }
}
