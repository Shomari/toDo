package com.sewing.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sewing on 9/27/15.
 */
public class ItemAdapter extends ArrayAdapter<Item> {
    public ItemAdapter(Context context, ArrayList<Item> items){
        super(context, 0, items);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Item item = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.tvItemName);
        TextView tvHome = (TextView) convertView.findViewById(R.id.tvPriority);

        tvName.setText(item.text);
        tvHome.setText(item.priority);

        return convertView;
    }

}
