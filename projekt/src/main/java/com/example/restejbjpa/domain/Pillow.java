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
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
		@NamedQuery(name = "pillow.findAll", query = "Select t from Pillow t"),
		@NamedQuery(name = "pillow.delete.all", query = "Delete from Pillow "),
		@NamedQuery(name = "pillow.findById", query = "Select t from Pillow t where t.id = :id")
})
@Entity
@XmlRootElement
public class Pillow {

	private Long id;
    private String name;
    @ManyToOne
    private Bed bed;
    
    public Pillow() {
		super();
	}
	
    public Pillow(String name) {
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

}