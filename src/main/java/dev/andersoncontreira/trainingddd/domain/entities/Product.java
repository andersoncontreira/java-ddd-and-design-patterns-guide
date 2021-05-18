package dev.andersoncontreira.trainingddd.domain.entities;

public class Product {

    public Long id;

    public String productID;
    public String productName;
    public String supplierID;
    public String categoryID;
    public String quantityPerUnit;
    public Double unitPrice;
    public Integer unitsInStock;
    public Integer unitsOnOrder;
    public Integer reorderLevel;
    public Boolean discontinued;

    public Order order;
    public Supplier supplier;
    public Category category;

    public Product(Long id, String productID, String productName, String supplierID, String categoryID, String quantityPerUnit, Double unitPrice, Integer unitsInStock, Integer unitsOnOrder, Integer reorderLevel, Boolean discontinued) {
        this.id = id;
        this.productID = productID;
        this.productName = productName;
        this.supplierID = supplierID;
        this.categoryID = categoryID;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.unitsOnOrder = unitsOnOrder;
        this.reorderLevel = reorderLevel;
        this.discontinued = discontinued;
    }

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getProductID() {
        return productID;
    }

    public Product setProductID(String productID) {
        this.productID = productID;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public Product setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public Product setSupplierID(String supplierID) {
        this.supplierID = supplierID;
        return this;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public Product setCategoryID(String categoryID) {
        this.categoryID = categoryID;
        return this;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public Product setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
        return this;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public Product setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public Integer getUnitsInStock() {
        return unitsInStock;
    }

    public Product setUnitsInStock(Integer unitsInStock) {
        this.unitsInStock = unitsInStock;
        return this;
    }

    public Integer getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public Product setUnitsOnOrder(Integer unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
        return this;
    }

    public Integer getReorderLevel() {
        return reorderLevel;
    }

    public Product setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
        return this;
    }

    public Boolean getDiscontinued() {
        return discontinued;
    }

    public Product setDiscontinued(Boolean discontinued) {
        this.discontinued = discontinued;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public Product setOrder(Order order) {
        this.order = order;
        return this;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Product setSupplier(Supplier supplier) {
        this.supplier = supplier;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }
}
