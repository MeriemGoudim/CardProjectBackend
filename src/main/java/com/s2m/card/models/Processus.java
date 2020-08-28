package com.s2m.card.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="processus")
public class Processus {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProcessus")
    private Long id;

    @Column(name="etape",nullable = false)
    private String etape;
    
    @Column(name="dateDebut",nullable = false)
    private Date dateDebut;
    
    @Column(name="delai1",nullable = false)
    private Long delai1;
    
    @Column(name="delai2",nullable = true)
    private Long delai2;
    
    @Column(name="delai3",nullable = true)
    private Long delai3;
    
    @Column(name="dateFin",nullable = true)
    private Date dateFin;
    
    @Column(name="isDisable",nullable = true)
    private Boolean isDisable;
    
    @Column(name="statut",nullable = false)
    private String statut;
    
    @Column(name="namesFiles",nullable = false)
    private String namesFiles;
    
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

	public Processus() {
		super();
	}

	public Processus(String etape, Date dateDebut, Long delai1, Long delai2, Long delai3, Date dateFin,
			Boolean isDisable, String statut, String namesFiles) {
		super();
		this.etape = etape;
		this.dateDebut = dateDebut;
		this.delai1 = delai1;
		this.delai2 = delai2;
		this.delai3 = delai3;
		this.dateFin = dateFin;
		this.isDisable = isDisable;
		this.statut=statut;
		this.namesFiles=namesFiles;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtape() {
		return etape;
	}

	public void setEtape(String etape) {
		this.etape = etape;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Long getDelai1() {
		return delai1;
	}

	public void setDelai1(Long delai1) {
		this.delai1 = delai1;
	}

	public Long getDelai2() {
		return delai2;
	}

	public void setDelai2(Long delai2) {
		this.delai2 = delai2;
	}

	public Long getDelai3() {
		return delai3;
	}

	public void setDelai3(Long delai3) {
		this.delai3 = delai3;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Boolean getIsDisable() {
		return isDisable;
	}

	public void setIsDisable(Boolean isDisable) {
		this.isDisable = isDisable;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	

	public String getNamesFiles() {
		return namesFiles;
	}

	public void setNamesFiles(String namesFiles) {
		this.namesFiles = namesFiles;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
}
