package com.example.listasyfragments;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Gorro on 01/11/16.
 */

public class ListAdapter extends ArrayAdapter<ItemPersona> {

    private ItemPersona[] itemPersonas;
    private int resourceLayout;
    private Context ctx;

    public ListAdapter(Context context, int resource, ItemPersona[] itemPersonas) {
        super(context, resource, itemPersonas);
        ctx = context;
        resourceLayout = resource;
        this.itemPersonas = itemPersonas;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) ctx).getLayoutInflater();
        View adapterview = inflater.inflate(resourceLayout, null);

        TextView txtCuadrado = (TextView) adapterview.findViewById(R.id.txtItemLetter);
        TextView txtName = (TextView) adapterview.findViewById(R.id.txtItemTitle);
        TextView txtUsername = (TextView) adapterview.findViewById(R.id.txtItemSubTitle);

        if (position % 2 == 0) {
            txtCuadrado.setBackgroundColor(ctx.getResources().getColor(R.color.colorPrimary));
        } else {
            txtCuadrado.setBackgroundColor(ctx.getResources().getColor(R.color.colorAccent));
        }

        String charone = String.valueOf(itemPersonas[position].getName().toUpperCase().charAt(0));
        txtCuadrado.setText(charone);
        txtName.setText(itemPersonas[position].getName());
        txtUsername.setText(itemPersonas[position].getUsername());

        return adapterview;

    }
}
