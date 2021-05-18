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

    public Set<Product> products;
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

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCustomerID() {
        return customerID;
    }

    public Order setCustomerID(String customerID) {
        this.customerID = customerID;
        return this;
    }

    public String getOrderID() {
        return orderID;
    }

    public Order setOrderID(String orderID) {
        this.orderID = orderID;
        return this;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public Order setOrderDate(String orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public Order setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
        return this;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public Order setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
        return this;
    }

    public String getFreight() {
        return freight;
    }

    public Order setFreight(String freight) {
        this.freight = freight;
        return this;
    }

    public String getShipCity() {
        return shipCity;
    }

    public Order setShipCity(String shipCity) {
        this.shipCity = shipCity;
        return this;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public Order setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
        return this;
    }

    public String getShipName() {
        return shipName;
    }

    public Order setShipName(String shipName) {
        this.shipName = shipName;
        return this;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public Order setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
        return this;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public Order setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
        return this;
    }

    public String getRequiredDate() {
        return requiredDate;
    }

    public Order setRequiredDate(String requiredDate) {
        this.requiredDate = requiredDate;
        return this;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public Order setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
        return this;
    }

    public String getShipVia() {
        return shipVia;
    }

    public Order setShipVia(String shipVia) {
        this.shipVia = shipVia;
        return this;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Order setProducts(Set<Product> products) {
        this.products = products;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Order setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }
}
