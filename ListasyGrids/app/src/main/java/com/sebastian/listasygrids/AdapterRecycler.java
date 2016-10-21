package com.sebastian.listasygrids;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Gorro on 21/10/16.
 */

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ReclerAdapterViewHoler> {

    private Context context;
    private List<ItemList> data;
    private int layoutResource;

    public AdapterRecycler(Context context, List<ItemList> data, int layoutResource) {
        this.context = context;
        this.data = data;
        this.layoutResource = layoutResource;
    }

    @Override
    public ReclerAdapterViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewAdapter =
                (LayoutInflater.from(parent.getContext()).inflate(layoutResource, null));
        ReclerAdapterViewHoler adapterViewHoler = new ReclerAdapterViewHoler(viewAdapter);
        return adapterViewHoler;
    }

    @Override
    public void onBindViewHolder(ReclerAdapterViewHoler holder, final int position) {
        holder.imgProf.setImageResource(data.get(position).getImg());
        holder.txtTitle.setText(data.get(position).getTitle());
        holder.txtSubTitle.setText(data.get(position).getSubtitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("RecyclerClick", data.get(position).getTitle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ReclerAdapterViewHoler extends RecyclerView.ViewHolder {

        ImageView imgProf;
        TextView txtTitle;
        TextView txtSubTitle;

        public ReclerAdapterViewHoler(View itemView) {
            super(itemView);
            imgProf = (ImageView) itemView.findViewById(R.id.imgItem);
            txtTitle = (TextView) itemView.findViewById(R.id.txtItem);
            txtSubTitle = (TextView) itemView.findViewById(R.id.txtItem2);
        }
    }

}
