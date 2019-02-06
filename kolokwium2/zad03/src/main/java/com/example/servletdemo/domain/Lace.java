package com.example.servletdemo.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Lace {
	public static int licznik = 0;
    private long id = 0;
    private String name = "-";
    private boolean isColorful = true;
    private boolean isPlain = true;
    private boolean isUsed = true;
    private double price = 00.00;
    private Date productionDate = new Date();

    public Lace(String name, boolean isColorful, boolean isPlain, boolean idUsed, double price, Date productionDate) {
        this.id = licznik++;
        this.name = name;
        this.isColorful = isColorful;
        this.isPlain = isPlain;
        this.isUsed = isUsed;
        this.price = price;
        this.productionDate = productionDate;
    }

    public Lace() {

    }

    public String showDetails() {
        String colorful;
        if(isColorful) {
            colorful = "Yes";
        }
        else {
            colorful = "No";
        }
        
        String pattern;
        if(isPlain) {
        	pattern = "Yes";
        }
        else {
        	pattern = "No";
        }
        
        String used;
        if(isUsed) {
        	used = "Yes";
        }
        else {
        	used = "No";
        }
        
        SimpleDateFormat df = new SimpleDateFormat ("dd-MM-yyyy");
        return "Name: " + name + "<br>Is with colorful: " + colorful +"<br>Is plain: " + pattern +"<br>Is used: " + used + "<br>Price: " + price + "<br>Production Date: " + df.format(productionDate);
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isColorful() {
		return isColorful;
	}

	public void setColorful(boolean isColorful) {
		this.isColorful = isColorful;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public boolean isPlain() {
		return isPlain;
	}

	public void setPlain(boolean isPlain) {
		this.isPlain = isPlain;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

}
