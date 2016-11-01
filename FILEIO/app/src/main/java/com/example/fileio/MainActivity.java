package com.example.fileio;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnGuardar, btnRecuperar;
    TextView txtRecuperado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edtxInput);

        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnRecuperar = (Button) findViewById(R.id.btnRecuperar);

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

    }
}
