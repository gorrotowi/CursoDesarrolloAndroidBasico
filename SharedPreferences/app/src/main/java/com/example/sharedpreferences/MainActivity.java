package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtxName, edtxCorreo, edtxEdad, edtxUsername;
    TextView txtPreferences;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtxName = (EditText) findViewById(R.id.edtxName);
        edtxCorreo = (EditText) findViewById(R.id.edtxMail);
        edtxEdad = (EditText) findViewById(R.id.edtxEdad);
        edtxUsername = (EditText) findViewById(R.id.edtxUsername);
        txtPreferences = (TextView) findViewById(R.id.txtPreferences);

        preferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                final String name = preferences.getString("Nombre", "");
                final String correo = preferences.getString("Correo", "");
                final String username = preferences.getString("Username", "");
                final int edad = preferences.getInt("Edad", 0);

                editor = preferences.edit();
                editor.putString("Nombre", edtxName.getText().toString());
                editor.putString("Correo", edtxCorreo.getText().toString());
                editor.putString("Username", edtxUsername.getText().toString());
                editor.putInt("Edad", Integer.parseInt(edtxEdad.getText().toString()));
                editor.apply();
                txtPreferences.setText("Nombre: " + preferences.getString("Nombre", "") + "\n" +
                        "Corre: " + edtxCorreo.getText().toString() + "\n" +
                        "Username: " + edtxUsername.getText().toString() + "\n" +
                        "Edad:" + Integer.parseInt(edtxEdad.getText().toString()));

                Snackbar.make(view, "Preferencias editadas", Snackbar.LENGTH_LONG)
                        .setAction("Deshacer", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                editor = preferences.edit();
                                editor.putString("Nombre", name);
                                editor.putString("Correo", correo);
                                editor.putString("Username", username);
                                editor.putInt("Edad", edad);
                                editor.apply();
                            }
                        })
                        .show();

            }
        });

        txtPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            String name = preferences.getString("Nombre", "");
            String correo = preferences.getString("Correo", "");
            String username = preferences.getString("Username", "");
            int edad = preferences.getInt("Edad", 0);
            txtPreferences.setText("Nombre: " + name + "\n" +
                    "Corre: " + correo + "\n" +
                    "Username: " + username + "\n" +
                    "Edad:" + edad);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
