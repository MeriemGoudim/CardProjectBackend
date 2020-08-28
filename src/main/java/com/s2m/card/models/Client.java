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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="clients")
public class Client implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idClient")
    private Long id;
	
	@Size(max=5)
    @Column(name="cdclt",nullable = false)
    private String cdclt;
    
	@Size(max=15)
    @Column(name="libcltc",nullable = true)
    private String libcltc;
	
	@Size(max=60)
    @Column(name="libclte",nullable = true)
    private String libclte;
	
	@Size(max=2)
    @Column(name="tpclt",nullable = true)
    private String tpclt;

	@Size(max=40)
    @Column(name="rueclt1",nullable = true)
    private String rueclt1;
	
	@Size(max=40)
    @Column(name="rueclt2",nullable = true)
    private String rueclt2;
	
	@Size(max=40)
    @Column(name="vilclt",nullable = true)
    private String vilclt;
	
	@Size(max=40)
    @Column(name="payclt",nullable = true)
    private String payclt;
	
	@Size(max=15)
    @Column(name="telclt1",nullable = true)
    private String telclt1;
	
	@Size(max=15)
    @Column(name="telclt2",nullable = true)
    private String telclt2;
	
	@Size(max=15)
    @Column(name="telclt3",nullable = true)
    private String telclt3;
	
	@Size(max=15)
    @Column(name="faxclt1",nullable = true)
    private String faxclt1;
	
	@Size(max=15)
    @Column(name="faxclt2",nullable = true)
    private String faxclt2;

    @Column(name="NBTPCRT",nullable = true)
    private Short nbtrcpt;
    
    @Column(name="obsclt",nullable = true)
    private String obsclt;
	
    @Column(name="ORDCHM",nullable = true)
    private Character ordchm;
    
    @Column(name="VALTMP",nullable = true)
    private Short valtmp;
	
    @JsonBackReference
    @OneToMany(mappedBy = "client")
    private List<InfosCard> infosCards;

	public Client() {
	}

	public Client(@Size(max = 5) String cdclt, @Size(max = 15) String libcltc, @Size(max = 60) String libclte,
			@Size(max = 2) String tpclt, @Size(max = 40) String rueclt1, @Size(max = 40) String rueclt2,
			@Size(max = 40) String vilclt, @Size(max = 40) String payclt, @Size(max = 15) String telclt1,
			@Size(max = 15) String telclt2, @Size(max = 15) String telclt3, @Size(max = 15) String faxclt1,
			@Size(max = 15) String faxclt2, Short nbtrcpt, String obsclt, Character ordchm, Short valtmp) {
		super();
		this.cdclt = cdclt;
		this.libcltc = libcltc;
		this.libclte = libclte;
		this.tpclt = tpclt;
		this.rueclt1 = rueclt1;
		this.rueclt2 = rueclt2;
		this.vilclt = vilclt;
		this.payclt = payclt;
		this.telclt1 = telclt1;
		this.telclt2 = telclt2;
		this.telclt3 = telclt3;
		this.faxclt1 = faxclt1;
		this.faxclt2 = faxclt2;
		this.nbtrcpt = nbtrcpt;
		this.obsclt = obsclt;
		this.ordchm = ordchm;
		this.valtmp = valtmp;
	}

	

	public Client(@Size(max = 5) String cdclt, @Size(max = 15) String libcltc, @Size(max = 60) String libclte,
			@Size(max = 2) String tpclt, @Size(max = 40) String rueclt1, @Size(max = 40) String rueclt2,
			@Size(max = 40) String vilclt, @Size(max = 40) String payclt, @Size(max = 15) String telclt1,
			@Size(max = 15) String telclt2, @Size(max = 15) String telclt3, @Size(max = 15) String faxclt1,
			@Size(max = 15) String faxclt2, Short nbtrcpt, String obsclt, Character ordchm, Short valtmp,
			List<InfosCard> infosCards) {
		super();
		this.cdclt = cdclt;
		this.libcltc = libcltc;
		this.libclte = libclte;
		this.tpclt = tpclt;
		this.rueclt1 = rueclt1;
		this.rueclt2 = rueclt2;
		this.vilclt = vilclt;
		this.payclt = payclt;
		this.telclt1 = telclt1;
		this.telclt2 = telclt2;
		this.telclt3 = telclt3;
		this.faxclt1 = faxclt1;
		this.faxclt2 = faxclt2;
		this.nbtrcpt = nbtrcpt;
		this.obsclt = obsclt;
		this.ordchm = ordchm;
		this.valtmp = valtmp;
		this.infosCards = infosCards;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCdclt() {
		return cdclt;
	}

	public void setCdclt(String cdclt) {
		this.cdclt = cdclt;
	}

	public String getLibcltc() {
		return libcltc;
	}

	public void setLibcltc(String libcltc) {
		this.libcltc = libcltc;
	}

	public String getLibclte() {
		return libclte;
	}

	public void setLibclte(String libclte) {
		this.libclte = libclte;
	}
	
	public String getTpclt() {
		return tpclt;
	}

	public void setTpclt(String tpclt) {
		this.tpclt = tpclt;
	}
	
	public String getRueclt1() {
		return rueclt1;
	}

	public void setRueclt1(String rueclt1) {
		this.rueclt1 = rueclt1;
	}

	public String getRueclt2() {
		return rueclt2;
	}

	public void setRueclt2(String rueclt2) {
		this.rueclt2 = rueclt2;
	}

	public String getVilclt() {
		return vilclt;
	}

	public void setVilclt(String vilclt) {
		this.vilclt = vilclt;
	}

	public String getPayclt() {
		return payclt;
	}

	public void setPayclt(String payclt) {
		this.payclt = payclt;
	}

	public String getTelclt1() {
		return telclt1;
	}

	public void setTelclt1(String telclt1) {
		this.telclt1 = telclt1;
	}

	public String getTelclt2() {
		return telclt2;
	}

	public void setTelclt2(String telclt2) {
		this.telclt2 = telclt2;
	}

	public String getTelclt3() {
		return telclt3;
	}

	public void setTelclt3(String telclt3) {
		this.telclt3 = telclt3;
	}

	public String getFaxclt1() {
		return faxclt1;
	}

	public void setFaxclt1(String faxclt1) {
		this.faxclt1 = faxclt1;
	}

	public String getFaxclt2() {
		return faxclt2;
	}

	public void setFaxclt2(String faxclt2) {
		this.faxclt2 = faxclt2;
	}

	public Short getNbtrcpt() {
		return nbtrcpt;
	}

	public void setNbtrcpt(Short nbtrcpt) {
		this.nbtrcpt = nbtrcpt;
	}

	public String getObsclt() {
		return obsclt;
	}

	public void setObsclt(String obsclt) {
		this.obsclt = obsclt;
	}

	public Character getOrdchm() {
		return ordchm;
	}

	public void setOrdchm(Character ordchm) {
		this.ordchm = ordchm;
	}

	public Short getValtmp() {
		return valtmp;
	}

	public void setValtmp(Short valtmp) {
		this.valtmp = valtmp;
	}

	public List<InfosCard> getInfosCards() {
		return infosCards;
	}

	public void setInfosCards(List<InfosCard> infosCards) {
		this.infosCards = infosCards;
	}


	
    
}
