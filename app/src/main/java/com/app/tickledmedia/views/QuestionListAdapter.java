package com.app.tickledmedia.views;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.tickledmedia.BaseApplication;
import com.app.tickledmedia.MainActivity;
import com.app.tickledmedia.R;
import com.app.tickledmedia.models.Response;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;



public class QuestionListAdapter extends BaseAdapter {


     final Context context;
     final List<Response> items;
    private final String type;

    ImageLoader imageLoader;
    private String question;

    public QuestionListAdapter(Context context, List<Response> items, String answer) {
        this.context = context;
        this.items = items;
        this.type=answer;
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

        question= questions.message;

        if(type.equals("answer"))
        {

        }
        else
        {
            holder.frame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //     Integer tag=(Integer)v.getTag();

                    ((MainActivity) context).replaceFragmentInContainer(AnswerFragment.TAG, AnswerFragment.newInstance(question));
                }
            });
        }


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
