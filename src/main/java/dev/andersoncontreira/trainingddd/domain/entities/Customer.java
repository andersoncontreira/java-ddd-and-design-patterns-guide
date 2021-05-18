package dev.andersoncontreira.trainingddd.domain.entities;

import java.util.HashSet;
import java.util.Set;

public class Customer {
    public Long id;

    public String contactTitle;
    public String contactName;
    public String address;
    public String city;
    public String postalCode;
    public String country;
    public String region;
    public String phone;
    public String fax;
    public String customerID;

    public Set<Order> orders;

    public Customer() {
        orders = new HashSet<>();
    }

    public Customer(Long id, String contactTitle, String contactName, String address, String city, String postalCode, String country, String region, String phone, String fax, String customerID) {
        this.id = id;
        this.contactTitle = contactTitle;
        this.contactName = contactName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.region = region;
        this.phone = phone;
        this.fax = fax;
        this.customerID = customerID;
    }

    public Long getId() {
        return id;
    }

    public Customer setId(Long id) {
        this.id = id;
        return this;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public Customer setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
        return this;
    }

    public String getContactName() {
        return contactName;
    }

    public Customer setContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Customer setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Customer setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Customer setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Customer setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public Customer setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Customer setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getFax() {
        return fax;
    }

    public Customer setFax(String fax) {
        this.fax = fax;
        return this;
    }

    public String getCustomerID() {
        return customerID;
    }

    public Customer setCustomerID(String customerID) {
        this.customerID = customerID;
        return this;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public Customer setOrders(Set<Order> orders) {
        this.orders = orders;
        return this;
    }
}
