package swe.group_one.warehouse.domain;

import javax.persistence.*;

// model class
@Entity // mapping the class to the database
@Table(name="my_order")
public class Order {

    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )

    private Integer id;
    private Float weight;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "name", column = @Column(name = "s_name")),
            @AttributeOverride( name = "surename", column = @Column(name = "s_surename")),
            @AttributeOverride( name = "email", column = @Column(name = "s_email")),
            @AttributeOverride( name = "street", column = @Column(name = "s_street")),
            @AttributeOverride( name = "plz", column = @Column(name = "s_plz")),
            @AttributeOverride( name = "country", column = @Column(name = "s_country"))
    })
    private Address shipAddr;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "name", column = @Column(name = "b_name")),
            @AttributeOverride( name = "surename", column = @Column(name = "b_surename")),
            @AttributeOverride( name = "email", column = @Column(name = "b_email")),
            @AttributeOverride( name = "street", column = @Column(name = "b_street")),
            @AttributeOverride( name = "plz", column = @Column(name = "b_plz")),
            @AttributeOverride( name = "country", column = @Column(name = "b_country"))
    })
    private Address billAddr;

    private String shipment;
    private Integer pay;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "name", column = @Column(name = "p_name")),
            @AttributeOverride( name = "price", column = @Column(name = "p_price")),
            @AttributeOverride( name = "dio", column = @Column(name = "p_dio")),
            @AttributeOverride( name = "color", column = @Column(name = "p_color")),
            @AttributeOverride( name = "uv", column = @Column(name = "p_uv"))
    })
    private Product product;

    public Order() {}

    public Order(Float weight, Address shipAddr, Address billAddr, String shipment, Integer pay, Product product) {
        this.weight = weight;
        this.shipAddr = shipAddr;
        this.billAddr = billAddr;
        this.shipment = shipment;
        this.pay = pay;
        this.product = product;
    }

    public Order(Integer id, Float weight, Address shipAddr, Address billAddr, String shipment, Integer pay, Product product) {
        this.weight = weight;
        this.shipAddr = shipAddr;
        this.billAddr = billAddr;
        this.shipment = shipment;
        this.pay = pay;
        this.product = product;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Address getShipAddr() {
        return shipAddr;
    }

    public void setShipAddr(Address shipAddr) {
        this.shipAddr = shipAddr;
    }

    public Address getBillAddr() {
        return billAddr;
    }

    public void setBillAddr(Address billAddr) {
        this.billAddr = billAddr;
    }

    public String getShipment() {
        return shipment;
    }

    public void setShipment(String shipment) {
        this.shipment = shipment;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product products) {
        this.product = products;
    }

}

