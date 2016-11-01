package com.example.fileio;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnGuardar, btnRecuperar;
    Button btnGuardarSD, btnRecuperarSD;
    TextView txtRecuperado;

    boolean sdDisponible = false;
    boolean sdAccesoW = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edtxInput);

        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnRecuperar = (Button) findViewById(R.id.btnRecuperar);

        btnGuardarSD = (Button) findViewById(R.id.btnGuardarSD);
        btnRecuperarSD = (Button) findViewById(R.id.btnRecuperarSD);

        txtRecuperado = (TextView) findViewById(R.id.txtRecuperado);

    }

    @Override
    protected void onResume() {
        super.onResume();

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    OutputStreamWriter streamWriter =
                            new OutputStreamWriter(openFileOutput("andy.txt", Context.MODE_APPEND));
                    streamWriter.write(editText.getText().toString() + "\n");
                    streamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error al escribir en la memoria interna", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    BufferedReader bufferedReader =
                            new BufferedReader(new InputStreamReader(openFileInput("andy.txt")));
                    txtRecuperado.setText(bufferedReader.readLine());
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error al leer de la memoria", Toast.LENGTH_SHORT).show();
                }
            }
        });

        final String status = Environment.getExternalStorageState();

        if (status.equals(Environment.MEDIA_MOUNTED)) {
            sdDisponible = true;
            sdAccesoW = true;
        } else if (status.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            sdDisponible = true;
            sdAccesoW = false;
        } else {
            sdAccesoW = false;
            sdDisponible = false;
        }

        btnGuardarSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sdDisponible && sdAccesoW) {
                    try {
                        File ruta_sd = Environment.getExternalStorageDirectory();
//                        File ruta_sd2 = Environment.getExternalStorageState(ruta_sd);
                        File filescritura = new File(ruta_sd.getAbsolutePath(), "andysd.txt");
                        Log.e("filepath", filescritura.getAbsolutePath() + "");
                        OutputStreamWriter streamWriterSD =
                                new OutputStreamWriter(new FileOutputStream(filescritura));
                        streamWriterSD.write(editText.getText().toString());
                        streamWriterSD.close();
                        Toast.makeText(MainActivity.this, "Dato guardado en la SD", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Error al escribir en memoria SD", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        btnRecuperarSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    File ruta_sd = Environment.getExternalStorageDirectory();
                    File fileRec = new File(ruta_sd.getAbsolutePath(), "andysd.txt");
                    BufferedReader bufferedReadersd =
                            new BufferedReader(new InputStreamReader(new FileInputStream(fileRec)));
                    txtRecuperado.setText(bufferedReadersd.readLine());
                    bufferedReadersd.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error al leer de la SD", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
