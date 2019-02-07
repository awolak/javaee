package com.example.restejbjpa.domain;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
	@NamedQuery(name = "type.findAll", query = "Select t from Type t"),
	@NamedQuery(name = "type.deleteAll", query = "Delete from Type"),
	@NamedQuery(name = "type.findById", query = "Select t from Type t where t.id = :id")
})
@Entity
@XmlRootElement
public class Type {

    private Long id;
    private String name;
    private String description;
    private Bed bed;

    

	public Type() {
    	super();
    }
    
    public Type(String name, String descr) {
    	super();
		this.name = name;
		this.description = descr;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @OneToOne(fetch = FetchType.EAGER)
    public Bed getBed() {
		return bed;
	}

	public void setBed(Bed bed) {
		this.bed = bed;
	}
}