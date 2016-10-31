package com.example.realmejemplo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    Realm realm;

    EditText edtxtName, edtxtAddress, edtxtEdad;

    Button btnSave;

    TextView txtContent;

    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtxtName = (EditText) findViewById(R.id.edtxName);
        edtxtAddress = (EditText) findViewById(R.id.edtxAddress);
        edtxtEdad = (EditText) findViewById(R.id.edtxEdad);
        btnSave = (Button) findViewById(R.id.btnGuardar);
        txtContent = (TextView) findViewById(R.id.content_users);

        realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();

        usuario = new Usuario();

    }

    public void save(View v) {
        usuario.nombre = edtxtName.getText().toString();
        usuario.direccion = edtxtAddress.getText().toString();

        try {
            usuario.edad = Integer.parseInt(edtxtEdad.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
            usuario.edad = 0;
        }

        realm.beginTransaction();
        realm.copyToRealm(usuario);
        realm.commitTransaction();

        RealmResults<Usuario> users = realm.where(Usuario.class)
                .findAll();
        Log.e(TAG, "save users:" + users.size());

        txtContent.setText(null);
        for (int i = 0; i < users.size(); i++) {
            String name = users.get(i).nombre;
            String address = users.get(i).direccion;
            int edad = users.get(i).edad;
            txtContent.append("Nombre: " + name + " Direccion: " + address + " Edad: " + edad + "\n");
        }

    }

    public void deleteUsers(View v) {
        final RealmResults<Usuario> users = realm.where(Usuario.class)
//                .lessThan("edad", 22)
                .lessThanOrEqualTo("edad", 22)
                .findAll();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                users.deleteAllFromRealm();
                RealmResults<Usuario> usersNews = realm.where(Usuario.class)
                        .findAll();
                txtContent.setText(null);
                for (int i = 0; i < usersNews.size(); i++) {
                    String name = usersNews.get(i).nombre;
                    String address = usersNews.get(i).direccion;
                    int edad = usersNews.get(i).edad;
                    txtContent.append("Nombre: " + name + " Direccion: " + address + " Edad: " + edad + "\n");
                }
            }
        });

    }

}
