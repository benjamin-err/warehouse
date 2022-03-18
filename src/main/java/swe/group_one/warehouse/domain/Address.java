package swe.group_one.warehouse.domain;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class Address implements Serializable {

    private String name;
    private String surename;
    private String email;
    private String street;
    private int plz;
    private String country;

    public Address(){}

    public Address(String name, String surename, String email, String street, int plz, String country) {
        this.name = name;
        this.surename = surename;
        this.email = email;
        this.street = street;
        this.plz = plz;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("A:").append(name).append("####ooooopp");

        return str.toString();
    }
}
