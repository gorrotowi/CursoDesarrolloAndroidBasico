package com.sebastian.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = ProfileActivity.class.getSimpleName();
    TextView txtNombre, txtEdad, txtMail, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtEdad = (TextView) findViewById(R.id.txtEdad);
        txtMail = (TextView) findViewById(R.id.txtMail);
        txtPass = (TextView) findViewById(R.id.txtPass);

    }

    @Override
    protected void onResume() {
        super.onResume();

        Bundle bundle = getIntent().getExtras();

        Log.i(TAG, "onResume: " + bundle.getString("nombre"));
        Log.w(TAG, "onResume: " + bundle.getString("mail"));
        Log.wtf(TAG, "algo!");

        Log.v(TAG, "algo!");

        Log.e(TAG, "onResume: "+bundle.toString());

        txtNombre.setText(getString(R.string.nombreuser, bundle.getString("nombre")));
        txtEdad.setText("Edad: " + bundle.getString("edad"));
        txtMail.setText("Mail: " + bundle.getString("mail"));
//        txtPass.setText("Pass: " + bundle.getString("pass") + " toggle" + bundle.getBoolean("toggle"));
        txtPass.setText(getString(R.string.pass, bundle.getString("pass"), bundle.getBoolean("toggle")));

    }
}
