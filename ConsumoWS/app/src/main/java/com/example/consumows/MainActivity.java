package com.example.consumows;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    RequestQueue rq;

    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> companynames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listNetworks);

        rq = Volley.newRequestQueue(this);

        String url = "http://api.citybik.es/v2/networks";

        companynames = new ArrayList<>();

        JsonObjectRequest jsonObjectRequest =
                new JsonObjectRequest(Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
//                                Log.e(TAG, "onResponse: " + response.toString());
                                try {
                                    parseJsonNetworks(response);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "onErrorResponse: " + error);
                    }
                });

        rq.add(jsonObjectRequest);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                startActivity(new Intent(MainActivity.this, DetailActivity.class));
            }
        });

    }

    private void parseJsonNetworks(JSONObject response) throws JSONException {
        JSONArray networks = response.getJSONArray("networks");
        for (int i = 0; i < networks.length(); i++) {
            JSONObject companyjson = networks.getJSONObject(i);
            String name = companyjson.getString("name");
            companynames.add(name);
        }
        adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                companynames);
        listView.setAdapter(adapter);
    }
}
