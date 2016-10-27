package com.sebastian.toolbarejemplo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    Toolbar toolbarCard;
    Toolbar toolbarCardextend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbarCard = (Toolbar) findViewById(R.id.toolbarCard);
        toolbarCardextend = (Toolbar) findViewById(R.id.toolbarExtend);

        toolbar.setTitle("Titulo Toolbar");
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbarCard.setTitle("Toolbar Card");
        toolbarCard.inflateMenu(R.menu.toolbar_card_menu);
        toolbarCardextend.inflateMenu(R.menu.toolbar_card_menu);
        toolbarCard.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.opcionCard) {
                    Toast.makeText(MainActivity.this, "Item card menu", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*if (item.getItemId() == android.R.id.home) {
            Toast.makeText(this, "Icono Toolbar seleccionado", Toast.LENGTH_SHORT).show();
        }*/
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "Icono Toolbar seleccionado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion1:
                Toast.makeText(this, "Menu opcion 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion2:
                break;
            case R.id.opcion3:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
