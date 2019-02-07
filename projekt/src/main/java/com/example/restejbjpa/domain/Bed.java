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
	
	@NamedQuery(name = "bed.findByCountOfSheets", query = "Select b from Bed b where b.countOfSheets = :countOfSheets")//,

})

@XmlRootElement
public class Bed {
	
	private Long id;
	private String name;
	private boolean isSoft;
	private double weight;
	private String productionDate;
	private int countOfSheets;
	private List<Producer> producers = new ArrayList<Producer>();
	private List<Pillow> pillows = new ArrayList<Pillow>();
 	private Type type;
 	
 	
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
 	
 	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public boolean getIsSoft(){
		return isSoft;
	}
	public void setIsSoft(boolean isSoft) {
		this.isSoft = isSoft;
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
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Producer> getProducers(){
		return producers;
	}
	
	public void setProducers(List<Producer> producers) {
		this.producers = producers;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Pillow> getPillows(){
		return pillows;
	}
	
	public void setPillows(List<Pillow> Pillows) {
		this.pillows = pillows;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	public Type getType() {
		return type;
	}
	
	public void setType(Type type)
	{
		this.type = type;
	}
	
 	public Bed() {
 		super();
 	}
 	
 	public Bed(String name, String productionDate, boolean isSoft, double weight) {
 		super();
 		this.name = name;
 		this.isSoft = isSoft;
 		this.weight = weight;
 		this.productionDate = productionDate;
 	}
 	
 	public Bed(Long id,String name, String productionDate, boolean isSoft, double weight) {
 		super();
 		this.id = id;
 		this.name = name;
 		this.isSoft = isSoft;
 		this.weight = weight;
 		this.productionDate = productionDate;
 	}
 	
 	public Bed(String name) {
 		super();
 		this.name = name;
 	}
}
