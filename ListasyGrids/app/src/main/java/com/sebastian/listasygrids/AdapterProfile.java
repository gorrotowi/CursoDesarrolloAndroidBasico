package com.sebastian.listasygrids;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gorro on 21/10/16.
 */

public class AdapterProfile extends BaseAdapter {

    private Context context;
    private int layoutResource;
    private ArrayList<ItemList> data;

    public AdapterProfile(Context context, int layoutResource, ArrayList<ItemList> data) {
        this.context = context;
        this.layoutResource = layoutResource;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View fila = convertView;
        ViewHolder holder;
        if (fila == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            fila = inflater.inflate(layoutResource, parent, false);
            holder = new ViewHolder();
            holder.txtTitle = (TextView) fila.findViewById(R.id.txtItem);
            holder.txtSubTitle = (TextView) fila.findViewById(R.id.txtItem2);
            holder.imgProfile = (ImageView) fila.findViewById(R.id.imgItem);
            fila.setTag(holder);
        } else {
            holder = (ViewHolder) fila.getTag();
        }

        ItemList itemList = data.get(position);
        holder.txtTitle.setText(itemList.getTitle());
        holder.txtSubTitle.setText(itemList.getSubtitle());
        holder.imgProfile.setImageResource(itemList.getImg());

        return fila;
    }

    private class ViewHolder {
        TextView txtTitle;
        TextView txtSubTitle;
        ImageView imgProfile;
    }

}
