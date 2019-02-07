package com.example.restejbjpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "bed.all", query = "Select b from Bed b"),
	@NamedQuery(name = "bed.delete.all", query = "Delete from Bed "),
	//@NamedQuery(name = "bed.deleteId", query = "Delete b from bed b where b.id = :id "),
	@NamedQuery(name = "bed.findByCountOfSheets", query = "Select b from Bed b where b.countOfSheets = :countOfSheets")//,
//	@NamedQuery(name = "bedProducer.findByAthorFirstName",
//	query = "Select a.firstName, a.lastName, b.title, b.yop from Book b JOIN b.authors a where a.firstName = :name")
	})
@XmlRootElement
public class Bed {

	private Long id;
	private String name;
	private boolean isSoft;
	private double weight;
	private String  productionDate;
	private int countOfSheets;
	private List<Pillow> pillows = new ArrayList<Pillow>();
    private List<Producer> producers = new ArrayList<Producer>();
    private Type type;
	
	
	public Bed() {
		super();
	}

	public Bed(String name, String productionDate, boolean isSoft, double weight, int countOfSheets) {
		super();
		this.name = name;
		this.isSoft = isSoft;
		this.weight = weight;
		this.productionDate = productionDate;
		this.countOfSheets = countOfSheets;
	}

	public Bed(Long id, String name, String productionDate, boolean isSoft, double weight, int countOfSheets) {
		super();
		this.id = id;
		this.name = name;
		this.isSoft = isSoft;
		this.weight = weight;
		this.productionDate = productionDate;
		this.countOfSheets = countOfSheets;
	}
	public Bed(String name) {
		super();
		this.name = name;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSoft() {
		return isSoft;
	}
	public void setIsSoft(boolean isSoft) {
		this.isSoft = isSoft;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}
	
	public int getCountOfSheets() {
		return countOfSheets;
	}

	public void setCountOfSheets(int countOfSheets) {
		this.countOfSheets = countOfSheets;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Pillow> getPillows() {
        return pillows;
    }

    public void setPillows(List<Pillow> pillows) {
        this.pillows = pillows;
    }
	
    @OneToOne(fetch = FetchType.EAGER)
    public Type getType() {
        return type;
    }
    
    public void setTail(Type type) {
        this.type = type;
    }
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Producer> getProducers() {
		return producers;
	}
    
    public void setProducers(List<Producer> producers) {
		this.producers = producers;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		//result = prime * result + countOfSheets;
		//result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bed other = (Bed) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Bed [name=" + name + ", isSoft=" + isSoft + ", weight=" + weight + ", productionDate=" + productionDate
				+ ", countOfSheets=" + countOfSheets + "]";
	}
	
}