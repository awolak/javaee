package ug.awolak.javaee.zad03.domain;

import java.util.Date;

public class Bed {
    private int id;
    private String producer;
    private Date productionDate;
    private double width;
    private int price;
    private int quantity;
    private boolean isSoft;

    public Bed() {
        super();
    }

    public Bed(int id, String producer, Date productionDate, double width, int price, int quantity, boolean isSoft) {
        this.id = id;
        this.producer = producer;
        this.productionDate = productionDate;
        this.width = width;
        this.price = price;
        this.quantity = quantity;
        this.isSoft = isSoft;
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
    
    public boolean getIsSoft() {
        return isSoft;
    }

    public void setIsSoft(boolean isSoft) {
        this.isSoft = isSoft;
    }

}
