package com.app.tickledmedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SappiKaran on 24/02/18.
 */

class QuestionListAdapter extends BaseAdapter {


     final Context context;
     final List<Response> items;


    public QuestionListAdapter(Context context, List<Response> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.list_item, parent, false);
        }

        // get current item to be displayed
        QuestionList questions = (QuestionList) getItem(position);

        // get the TextView for item name and item description
        TextView textViewItemName = (TextView)
                convertView.findViewById(R.id.line1);

        //sets the text for item name and item description from the current item object
        textViewItemName.setText(questions.message);

        // returns the view for the current row
        return convertView;
    }
}
