package com.sebastian.listasygrids;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterRecycler adapterRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = (RecyclerView) findViewById(R.id.rcView);
//        adapterRecycler = new AdapterRecycler(this, getData(), R.layout.item_list);
        adapterRecycler = new AdapterRecycler(this, getData(), R.layout.item_grid);

//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        recyclerView.setAdapter(adapterRecycler);

    }

    private ArrayList<ItemList> getData() {
        ArrayList<ItemList> item = new ArrayList<>();
        item.add(new ItemList("Alberto", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Gerardo", "Ingeniero1", R.mipmap.ic_launcher));
        item.add(new ItemList("Rodrigo", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Elliot", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Angelica", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Melisa", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Juan", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Pepe", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Carlos", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Melisa", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Juan", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Pepe", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Carlos", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Melisa", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Juan", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Pepe", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Carlos", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Melisa", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Juan", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Pepe", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Carlos", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Melisa", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Juan", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Pepe", "Ingeniero", R.mipmap.ic_launcher));
        item.add(new ItemList("Carlos", "Ingeniero", R.mipmap.ic_launcher));
        return item;
    }
}
