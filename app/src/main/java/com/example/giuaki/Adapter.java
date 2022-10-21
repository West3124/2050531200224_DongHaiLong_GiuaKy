package com.example.giuaki;

import android.app.Activity;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private String[] items;
    private String[] classes;
    private String[] shortDescription;

    public Adapter(Activity activity, String[] items, String[] classes, String[] shortDescription) {
        this.activity = activity;
        this.items = items;
        this.classes = classes;
        this.shortDescription = shortDescription;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public int getCountClasses() {
        return classes.length;
    }

    public Object getClass(int i) {
        return classes[i];
    }

    public int getCountImages() {
        return shortDescription.length;
    }

    public Object getImage(int i) {
        return shortDescription[i];
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.item, null);
        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        tvName.setText(items[i]);
        TextView  tvDescription = (TextView) view.findViewById(R.id.tv_description);
        tvDescription.setText(classes[i]);
        ImageView image =(ImageView) view.findViewById(R.id.image);
        image.setImageResource(R.drawable.ic_account_circle_24);
        return view;
    }

    public void removeItem(int i) {
        List<String> itemsList = new ArrayList<String>();
        for(int ck= 0;ck<items.length;ck++)
        {
            if(ck == i)
            {
                // No operation here
            }
            else
            {
                itemsList.add(items[ck]);
            }
        }
        items = itemsList.toArray(new String[itemsList .size()]);
    }
}