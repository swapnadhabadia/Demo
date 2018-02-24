package com.app.tickledmedia;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SappiKaran on 24/02/18.
 */

class QuestionListAdapter extends BaseAdapter {


     final Context context;
     final List<Response> items;

    ImageLoader imageLoader;
    public QuestionListAdapter(Context context, List<Response> items) {
        this.context = context;
        this.items = items;
        imageLoader = BaseApplication.getImageLoader();
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
        ViewHolder holder = null;
        Response questions = (Response) getItem(position);

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);

            holder = new ViewHolder();
holder.frame=(FrameLayout)convertView.findViewById(R.id.frameL);
            holder.listOfImage = (ImageView) convertView.findViewById(R.id.image);
            holder.mId=(TextView)convertView.findViewById(R.id.id);
            holder.mUid=(TextView)convertView.findViewById(R.id.userId);
            holder.message=(TextView)convertView.findViewById(R.id.message);
            holder.comments=(TextView)convertView.findViewById(R.id.comments);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }


        imageLoader.displayImage(questions.image,holder.listOfImage);
        holder.mId.setText(questions.id.toString());
        holder.mUid.setText(questions.userId.toString());
        holder.message.setText(questions.message.toString());

        holder.frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer tag=(Integer)v.getTag();

               // ((MainActivity) context).replaceFragmentInContainer();
            }
        });
        //holder.comments.setText(questions.comments.get(position).message.toString());
        return convertView;


    }

    private class ViewHolder {
        ImageView listOfImage;

        TextView mId;
        TextView mUid;
        TextView message;
        TextView comments;
         FrameLayout frame;
    }


}
