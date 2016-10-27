package com.example.basededatos;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtxName, edtxAge, edtxAddress, edtxtID;

    Button btnInsert, btnDelete;

    TextView txtViewDB;

    DBController dbController;

//    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtxName = (EditText) findViewById(R.id.edtxName);
        edtxAge = (EditText) findViewById(R.id.edtxAge);
        edtxAddress = (EditText) findViewById(R.id.edtxAddress);
        edtxtID = (EditText) findViewById(R.id.edtxtID);

        btnInsert = (Button) findViewById(R.id.btnInsertar);
        btnDelete = (Button) findViewById(R.id.btnBorrar);

        txtViewDB = (TextView) findViewById(R.id.txtContenido);

        dbController = new DBController(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edtxName.getText().toString();
                String direccion = edtxAddress.getText().toString();
                int edad = Integer.parseInt(edtxAge.getText().toString());

                dbController.open();

                dbController.insertData(nombre, direccion, edad);

                showData();

                dbController.close();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbController.open();
//                dbController.delete(index);
                dbController.delete(Long.parseLong(edtxtID.getText().toString()));
                showData();
                dbController.close();
//                index++;
            }
        });

    }

    private void showData() {
        txtViewDB.setText(null);
        Cursor cursor = dbController.getData();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(0);
                    String nombre = cursor.getString(1);
                    int edad = cursor.getInt(2);
                    String direccion = cursor.getString(3);
                    txtViewDB.append("Nombre: " + nombre +
                            " Direccion: " + direccion +
                            " Edad: " + edad +
                            " ID= " + id + "\n");
                } while (cursor.moveToNext());
            }
        }
    }
}
