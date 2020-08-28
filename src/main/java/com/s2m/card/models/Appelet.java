package com.s2m.card.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="appelets")
public class Appelet {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idAppelet")
    private Long id;

    @Column(name="nom",nullable = false)
    private String nom;
    
    @OneToMany(mappedBy = "appelet")
    private List<Scheime> scheimes;
    
    @ManyToOne
    @JoinColumn(name = "idAppeletVr")
    private AppeletVersion appeletVr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Scheime> getScheimes() {
		return scheimes;
	}

	public void setScheimes(List<Scheime> scheimes) {
		this.scheimes = scheimes;
	}
    
    
}
