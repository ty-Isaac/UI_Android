package com.andriodtest.isaac.testui.ListVIew;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.andriodtest.isaac.testui.R;

import java.util.LinkedList;

/**
 * Created by isaac on 2017/11/6.
 */

public class PersonAdapter extends BaseAdapter {
    private LinkedList<Celebrity> mData;
    private Context mContext;

    public PersonAdapter(LinkedList<Celebrity> mData,Context mContext){
        this.mData = mData;
        this.mContext = mContext;
    }
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.celebrity_item,parent,false);
        ImageView img_icon = (ImageView) convertView.findViewById(R.id.celebrity_image);
        TextView txt_aName = (TextView) convertView.findViewById(R.id.txt_perName);
        TextView txt_aSpeak = (TextView) convertView.findViewById(R.id.txt_aSpeak);
        img_icon.setBackgroundResource(mData.get(position).getIcon());
        txt_aName.setText(mData.get(position).getCeleName());
        txt_aSpeak.setText(mData.get(position).getDictum());

        return convertView;
    }
}

