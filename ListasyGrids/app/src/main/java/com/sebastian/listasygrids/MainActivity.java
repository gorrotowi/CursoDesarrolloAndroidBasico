package com.sebastian.listasygrids;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    ListView listView;
    GridView gridView;
    ArrayAdapter<String> adapter;

    String[] data = new String[]{
            "Google", "Paypal", "Virgin", "Twitter", "Apple", "Facebook", "Tesla"
    };

    AdapterProfile adapterProfile;
    AdapterProfile adapterProfileGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        gridView = (GridView) findViewById(R.id.gridView);
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
//        listView.setAdapter(adapter);
//        gridView.setAdapter(adapter);

        adapterProfile = new AdapterProfile(this, R.layout.item_list, getData());
        adapterProfileGrid = new AdapterProfile(this, R.layout.item_grid, getData());
        listView.setAdapter(adapterProfile);
        gridView.setAdapter(adapterProfileGrid);

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
        return item;
    }

    @Override
    protected void onResume() {
        super.onResume();

        /**
         * Simple listener
         */
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                TextView txtItem = (TextView) findViewById(android.R.id.text1);
//                TextView txtItem1 = (TextView) view.findViewById(android.R.id.text1);
//                Log.e(TAG, "onItemClick data: " + data[position]);
//                Log.e(TAG, "onItemClick find: " + txtItem.getText().toString());
//                Log.e(TAG, "onItemClick view.find: " + txtItem1.getText().toString());
//            }
//        });
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.e(TAG, "onItemClick data: " + data[position]);
//            }
//        });

        /**
         * Adapter Listeners
         */

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textViewTitle = (TextView) view.findViewById(R.id.txtItem);
                Log.e(TAG, "onItemClick: " + textViewTitle.getText().toString());
                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(intent);
            }
        });

    }
}
