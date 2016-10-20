package com.sebastian.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

public class SegundoActivity extends AppCompatActivity {

    private static final String TAG = SegundoActivity.class.getSimpleName();
    EditText edtxNombre, edtxEdad, edtxMail, edtxPass;
    ToggleButton tglBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        edtxNombre = (EditText) findViewById(R.id.edtxNombre);
        edtxEdad = (EditText) findViewById(R.id.edtxEdad);
        edtxMail = (EditText) findViewById(R.id.edtxMail);
        edtxPass = (EditText) findViewById(R.id.edtxContrasena);
        tglBtn = (ToggleButton) findViewById(R.id.tglBtn);

    }

    public void goViewSecond(View v) {
        String nombre = edtxNombre.getText().toString();
        String edad = edtxEdad.getText().toString();
        String mail = edtxMail.getText().toString();
        String pass = edtxPass.getText().toString();
        Intent intent = new Intent(SegundoActivity.this, ProfileActivity.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("edad", edad);
        intent.putExtra("mail", mail);
        intent.putExtra("pass", pass);
        intent.putExtra("toggle", tglBtn.isChecked());
        startActivity(intent);

        Log.e(TAG, "goViewSecond: go Second View");
    }

}
