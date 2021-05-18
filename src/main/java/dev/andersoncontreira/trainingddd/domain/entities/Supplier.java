package dev.andersoncontreira.trainingddd.domain.entities;

import java.util.HashSet;
import java.util.Set;

public class Supplier {

    public Long id;

    public String supplierID;
    public String contactTitle;
    public String contactName;
    public String homePage;
    public String city;
    public String postalCode;
    public String country;
    public String phone;
    public String fax;
    public String companyName;
    public String region;
    public String address;

    public Set<Product> products;

    public Supplier() {
        products = new HashSet<>();
    }

    public Supplier(Long id, String supplierID, String contactTitle, String contactName, String homePage, String city, String postalCode, String country, String phone, String fax, String companyName, String region, String address) {
        this.id = id;
        this.supplierID = supplierID;
        this.contactTitle = contactTitle;
        this.contactName = contactName;
        this.homePage = homePage;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
        this.fax = fax;
        this.companyName = companyName;
        this.region = region;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public Supplier setId(Long id) {
        this.id = id;
        return this;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public Supplier setSupplierID(String supplierID) {
        this.supplierID = supplierID;
        return this;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public Supplier setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
        return this;
    }

    public String getContactName() {
        return contactName;
    }

    public Supplier setContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public String getHomePage() {
        return homePage;
    }

    public Supplier setHomePage(String homePage) {
        this.homePage = homePage;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Supplier setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Supplier setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Supplier setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Supplier setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getFax() {
        return fax;
    }

    public Supplier setFax(String fax) {
        this.fax = fax;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Supplier setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public Supplier setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Supplier setAddress(String address) {
        this.address = address;
        return this;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Supplier setProducts(Set<Product> products) {
        this.products = products;
        return this;
    }
}
