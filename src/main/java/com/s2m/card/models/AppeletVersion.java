package com.s2m.card.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="appeletsVersions")
public class AppeletVersion {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idAppeletVr")
    private Long id;

    @Column(name="nom",nullable = false)
    private String nom;
    
    @OneToMany(mappedBy = "appeletVr")
    private List<Appelet> appelets;

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

	public List<Appelet> getAppelets() {
		return appelets;
	}

	public void setAppelets(List<Appelet> appelets) {
		this.appelets = appelets;
	}
    
}
