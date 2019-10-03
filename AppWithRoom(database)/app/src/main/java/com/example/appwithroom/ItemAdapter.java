package com.example.appwithroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {

    private int rID;

    public ItemAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
        rID = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View mView = convertView;

        if (mView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rID, null);
        }

        Item item = getItem(position);

        TextView textName = mView.findViewById(R.id.textName);
        TextView textAmount = mView.findViewById(R.id.textAmount);

        textName.setText(item.getName());
        textAmount.setText(String.valueOf(item.getAmount()));

        return mView;
    }
}
