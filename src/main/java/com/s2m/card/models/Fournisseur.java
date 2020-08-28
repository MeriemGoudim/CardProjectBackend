package com.s2m.card.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="fournisseurs")
public class Fournisseur implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idFournisseur")
    private Long id;

    @Column(name="nom",nullable = false)
    private String nom;
    
    @JsonBackReference
    @OneToMany(mappedBy = "fournisseur")
    private List<InfosCard> infosCards;


	public Fournisseur() {
		super();
	}

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

	public List<InfosCard> getInfosCards() {
		return infosCards;
	}

	public void setInfosCards(List<InfosCard> infosCards) {
		this.infosCards = infosCards;
	}


	
	
    
    
}
