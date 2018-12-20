package ug.awolak.javaee.kolokwium2.domain;

import java.util.Date;

public class Lace {
    private int id;
    private String producer;
    private Date productionDate;
    private double width;
    private int price;
    private int quantity;
    private boolean isColorful;

    public Lace() {
        super();
    }

    public Lace(int id, String producer, Date productionDate, double width, int price, int quantity, boolean isColorful) {
        this.id = id;
        this.producer = producer;
        this.productionDate = productionDate;
        this.width = width;
        this.price = price;
        this.quantity = quantity;
        this.isColorful = isColorful;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incrementId() {
        id++;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProdutionDate(Date productionDate) {
        this.productionDate = productionDate;
    }


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    
    public boolean getIsColorful() {
        return isColorful;
    }

    public void setIsColorful(boolean isColorful) {
        this.isColorful = isColorful;
    }

}
