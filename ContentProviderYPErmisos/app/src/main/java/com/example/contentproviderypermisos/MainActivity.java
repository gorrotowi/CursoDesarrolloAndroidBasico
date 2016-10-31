package com.example.contentproviderypermisos;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    TextView txtMensajes;

    String[] permisos = {Manifest.permission.READ_SMS};
    int REQUEST_SMS_CODE = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMensajes = (TextView) findViewById(R.id.txtMensajes);

        checkReadSMSPermission();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_SMS_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                readSMS();
            } else {
                new AlertDialog.Builder(this)
                        .setTitle("Permisos invalidos")
                        .setMessage("No se pueden leer los mensajes, " +
                                "por favor acepta los permisos de lectura")
                        .setPositiveButton("Autorizar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                checkReadSMSPermission();
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                finish();
                            }
                        }).create().show();
            }
        }
    }

    private void checkReadSMSPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_SMS)
                    == PackageManager.PERMISSION_GRANTED) {
                readSMS();
            } else {
                requestPermissions(permisos, REQUEST_SMS_CODE);
            }
        } else {
            readSMS();
        }
    }

    private void readSMS() {
        Uri uri = Uri.parse("content://sms/inbox");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor.moveToFirst()) {
            //TODO
            for (int i = 0; i < cursor.getColumnCount(); i++) {
                String columname = cursor.getColumnName(i);
                Log.e(TAG, "readSMS colum name: " + columname);
            }

            for (int i = 0; i < cursor.getCount(); i++) {
                String smsTxt = cursor.getString(cursor.getColumnIndexOrThrow("body"));
                String num = cursor.getString(cursor.getColumnIndexOrThrow("address"));
                txtMensajes.append("\n" + num + "\n" + smsTxt + "\n");
                Log.e(TAG, "readSMS: " + num + smsTxt);
                cursor.moveToNext();
            }

        } else {
            cursor.close();
        }
    }
}
