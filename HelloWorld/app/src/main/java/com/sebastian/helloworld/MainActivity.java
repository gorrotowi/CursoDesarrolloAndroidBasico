package com.sebastian.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtMain = (TextView) findViewById(R.id.txtMainSaludo);
        Button btnMain = (Button) findViewById(R.id.btnMainSaludo);

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMain.setText(R.string.saludo);
            }
        });

        txtMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMain.setText(R.string.buenos_dias);
            }
        });

    }

    public void goView(View v) {
        Intent intent = new Intent(MainActivity.this, SegundoActivity.class);
        startActivity(intent);
        finish();
    }

}
