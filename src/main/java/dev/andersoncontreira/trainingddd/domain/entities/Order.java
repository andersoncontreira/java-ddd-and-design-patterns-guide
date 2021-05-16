package dev.andersoncontreira.trainingddd.domain.entities;

import java.util.HashSet;
import java.util.Set;

public class Order {

    public Long id;

    public String customerID;
    public String orderID;
    public String orderDate;
    public String shipAddress;
    public String shipRegion;
    public String freight;
    public String shipCity;
    public String shipCountry;
    public String shipName;
    public String employeeID;
    public String shippedDate;
    public String requiredDate;
    public String shipPostalCode;
    public String shipVia;

//    @Relationship(type = "ORDERS", direction = Relationship.OUTGOING)
    public Set<Product> products;
//    @Relationship(type = "PURCHASED", direction = Relationship.INCOMING)
    public Customer customer;

    public Order() {
        products = new HashSet<>();
    }

    public Order(Long id, String customerID, String orderID, String orderDate, String shipAddress, String shipRegion, String freight, String shipCity, String shipCountry, String shipName, String employeeID, String shippedDate, String requiredDate, String shipPostalCode, String shipVia) {
        this.id = id;
        this.customerID = customerID;
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.shipAddress = shipAddress;
        this.shipRegion = shipRegion;
        this.freight = freight;
        this.shipCity = shipCity;
        this.shipCountry = shipCountry;
        this.shipName = shipName;
        this.employeeID = employeeID;
        this.shippedDate = shippedDate;
        this.requiredDate = requiredDate;
        this.shipPostalCode = shipPostalCode;
        this.shipVia = shipVia;
    }
}
