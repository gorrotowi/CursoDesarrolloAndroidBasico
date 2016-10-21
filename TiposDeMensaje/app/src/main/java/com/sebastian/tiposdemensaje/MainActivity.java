package com.sebastian.tiposdemensaje;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mostrarTostada(View v) {
        Toast.makeText(this, "Hola Usuario desde una Tostada", Toast.LENGTH_LONG).show();
    }

    public void mostrarAlerta(View v) {
        new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage("Hola usuario desde una alerta")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Cerrando Dialogo", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .setNeutralButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "El dialogo se cerro", Toast.LENGTH_SHORT).show();
                    }
                })
                .create()
                .show();
    }

    public void customAlert(View v) {
        new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setView(R.layout.content_dialog)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        EditText edtx = (EditText) findViewById(R.id.edtxDialog);
//                        Toast.makeText(MainActivity.this, edtx.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                })
                .create().show();
    }

}
