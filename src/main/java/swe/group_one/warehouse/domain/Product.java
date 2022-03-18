package swe.group_one.warehouse.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Product {

    private String name;
    private Integer price;
    private String dio;
    private String color;
    private String uv;

    public Product() {
    }

    public Product(String name, Integer price, String dio, String color, String uv) {
        this.name = name;
        this.price = price;
        this.dio = dio;
        this.color = color;
        this.uv = uv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDio() {
        return dio;
    }

    public void setDio(String dio) {
        this.dio = dio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }
}