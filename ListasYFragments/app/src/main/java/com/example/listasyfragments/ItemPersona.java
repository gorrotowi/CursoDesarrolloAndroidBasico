package com.example.listasyfragments;

/**
 * Created by Gorro on 01/11/16.
 */

public class ItemPersona {

    String name, username, mail, telefono;

    public ItemPersona(String name, String username, String mail, String telefono) {
        this.name = name;
        this.username = username;
        this.mail = mail;
        this.telefono = telefono;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
