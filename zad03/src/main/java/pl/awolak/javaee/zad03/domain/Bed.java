package pl.awolak.javaee.zad03.domain;

import java.util.Date;

public class Bed {
    private String name;
    private Date productionDate;
    private boolean isSoft;
    private double width;

    public Bed() {
        super();
    }

    public Bed(String name, Date productionDate, double width, boolean isSoft) {
        this.name = name;
        this.productionDate = productionDate;
        this.width = width;
        this.isSoft = isSoft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProdutionDate(Date productionDate) {
        this.productionDate = productionDate;
    }
    
    public double getwidth() {
        return width;
    }

    public void setwidth(double width) {
        this.width = width;
    }
    
    public boolean isSoftStatus() {
        return isSoft;
    }

    public void setVipStatus(boolean isSoft) {
        this.isSoft = isSoft;
    }

}
