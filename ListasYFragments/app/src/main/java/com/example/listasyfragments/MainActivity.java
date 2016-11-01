package com.example.listasyfragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ItemPersona[] data = {
            new ItemPersona("Elliot", "@elliot", "elliot@mail.com", "5463324234"),
            new ItemPersona("Juan", "@juan", "juan@mail.com", "5463324234"),
            new ItemPersona("Rebeca", "@rebeca", "rebeca@mail.com", "5463324234"),
            new ItemPersona("Pepe", "@pepe", "pepe@mail.com", "5463324234"),
            new ItemPersona("Gonzalo", "@gonzalo", "gonzalo@mail.com", "5463324234"),
            new ItemPersona("Elizabeth", "@elizabeth", "elizabeth@mail.com", "5463324234"),
            new ItemPersona("Yazmin", "@yazmin", "yaz@mail.com", "5463324234"),
            new ItemPersona("Alberto", "@alberto", "alberto@mail.com", "5463324234"),
            new ItemPersona("Carlos", "@carlos", "carlos@mail.com", "5463324234"),
            new ItemPersona("Paloma", "@paloma", "paloma@mail.com", "5463324234"),
            new ItemPersona("Paloma", "@paloma", "paloma@mail.com", "5463324234"),
            new ItemPersona("Paloma", "@paloma", "paloma@mail.com", "5463324234"),
            new ItemPersona("Paloma", "@paloma", "paloma@mail.com", "5463324234")
    };

    ListView listView;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listFragment);
        adapter = new ListAdapter(this, R.layout.item_usuario, data);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ItemPersona persona = (ItemPersona) listView.getAdapter().getItem(position);
                TextView textView = (TextView) findViewById(R.id.txtDetalle);

                String detalle = "Nombre: " + persona.getName() + " \n" +
                        "Correo: " + persona.getMail() + " \n" +
                        "Telefono: " + persona.getTelefono() + " \n" +
                        "Username: " + persona.getUsername() + " \n";

                textView.setText(detalle);
            }
        });

    }
}
