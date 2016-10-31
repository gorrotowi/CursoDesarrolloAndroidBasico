package com.example.realmejemplo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Gorro on 31/10/16.
 */

public class Usuario extends RealmObject {
    @PrimaryKey
    int id;
    String nombre;
    int edad;
    String direccion;

}
