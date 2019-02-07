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
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.NamedQueries;

@Entity
@NamedQueries({
	@NamedQuery(name = "producer.findAll", query = "Select o from Producer o"),
	@NamedQuery(name = "producer.deletAll", query = "Delete from Producer "),
	@NamedQuery(name = "producer.findById", query = "Select o from Producer o where o.id = :id")
})

@XmlRootElement
public class Producer {
	private Long id;
	private String name;
	
	private List<Bed> beds = new ArrayList<Bed>();
	
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

    public void setName(String firstName) {
        this.name = firstName;
    }
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Bed> getBeds(){
    	return beds;
    }
    
    public void setBeds(List<Bed> beds) {
    	this.beds = beds;
    }
	public Producer() {
		super();
	}
	
	public Producer(String name) {
		super();
		this.name = name;
	}
}
