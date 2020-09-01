package com.s2m.card.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="infoscards")
public class InfosCard implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idInfosCard")
    private Long id;

    @Column(name="intituleCarte",nullable = true)
    private String intituleCarte;

    @Column(name="ica",nullable = true)
    private String ica;
    
    @Column(name="typeProduit", nullable=false)
    private String typeProduit;
    
    @Column(name="codeProduit", nullable=false)
    private String codeProduit;
    
    @Column(name="bin",nullable = false)
    private String bin;
    
    @Column(name="scheime", nullable=true)
    private String scheime;
    
    @Column(name="paiement", nullable=false)
    private String paiement;
    
    @Column(name="puce",nullable = true)
    private Boolean puce;
    
    @Column(name="piste",nullable = true)
    private Boolean piste;

    @Column(name="fabriquantPuce",nullable = true)
    private String fabriquantPuce;

    @Column(name="typePuce",nullable = true)
    private String typePuce;

    @Column(name="capacitePuce",nullable = true)
    private String capacitePuce;

    @Column(name="dateExpPuce",nullable = true)
    private Date dateExpPuce;

    @Column(name="masquePuce",nullable = true)
    private String masquePuce;

    @Column(name="refVisaMc",nullable = true)
    private String refVisaMc;

    @Column(name="couleurRecto",nullable = true)
    private String couleurRecto;

    @Column(name="couleurVerso",nullable = true)
    private String couleurVerso;

    @Column(name="effetsSpeciaux",nullable = true)
    private String effetsSpeciaux;

    @Column(name="autresEffets",nullable = true)
    private String autresEffets;

    @Column(name="panneauSignature",nullable = true)
    private String panneauSignature;

    @Column(name="finition",nullable = true)
    private String finition;

    @Column(name="hologramme",nullable = true)
    private String hologramme;

    @Column(name="laminat",nullable = true)
    private String laminat;

    @Column(name="typeImpRecto",nullable = true)
    private String typeImpRecto;

    @Column(name="couleurImp",nullable = true)
    private String couleurImp;

    @Column(name="dateReceptionFV",nullable = true)
    private Date dateReceptionFV;

    @Column(name="demandeBatClt",nullable = true)
    private String demandeBatClt;

    @Column(name="dateEnvoiVisuelFr",nullable = true)
    private Date dateEnvoiVisuelFr;

    @Column(name="dateReception",nullable = true)
    private Date dateReception;

    @Column(name="refVisuel",nullable = true)
    private String refVisuel;

    @Column(name="dateEnvoiPdfClt",nullable = true)
    private Date dateEnvoiPdfClt;

    @Column(name="dateEnvoiPdfCltVr1",nullable = true)
    private Date dateEnvoiPdfCltVr1;

    @Column(name="dateEnvoiPdfCltVr2",nullable = true)
    private Date dateEnvoiPdfCltVr2;

    @Column(name="dateEnvoiPdfCltVr3",nullable = true)
    private Date dateEnvoiPdfCltVr3;

    @Column(name="dateValidationClt",nullable = true)
    private Date dateValidationClt;

    @Column(name="dateReceptionChromalin",nullable = true)
    private Date dateReceptionChromalin;

    @Column(name="dateSoumissionVisaMc",nullable = true)
    private Date dateSoumissionVisaMc;

    @Column(name="dateResoumissionVisaMc",nullable = true)
    private Date dateResoumissionVisaMc;

    @Column(name="numSoumission",nullable = true)
    private Long numSoumission;

    @Column(name="dateApprobationVisaMc",nullable = true)
    private Date dateApprobationVisaMc;

    @Column(name="dateBonCdeS2M",nullable = true)
    private Date dateBonCdeS2M;

    @Column(name="numBonCdeS2M",nullable = true)
    private Long numBonCdeS2M;

    @Column(name="quantite",nullable = true)
    private Long quantite;

    @Column(name="dateEnlevement",nullable = true)
    private Date dateEnlevement;

    @Column(name="dateReceptionS2M",nullable = true)
    private Date dateReceptionS2M;

    @Column(name="facturationLivraison",nullable = true)
    private Boolean facturationLivraison;

    @Column(name="numFacture",nullable = true)
    private Long numFacture;

	@Column(name="dateFacture",nullable = true)
    private Date dateFacture;
    
	@Column(name="contact", nullable = true)
	private Boolean contact;
	
	@Column(name="contactLess", nullable = true)
	private Boolean contactLess;
	
	@Column(name="dda",nullable = true)
    private Boolean dda;
	
	@Column(name="sda",nullable = true)
    private Boolean sda;
	
	@Column(name="cda",nullable = true)
    private Boolean cda;
	
	@Column(name="statut",nullable = true)
    private String statut;
	
	@Column(name="etat",nullable = true)
    private String etat; 
	
	@Column(name="commentaire",nullable = true)
    private String commentaire;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser")
    private User user;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idClient")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFournisseur")
    private Fournisseur fournisseur;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getIntituleCarte() {
        return intituleCarte;
    }

    public void setIntituleCarte(String intituleCarte) {
        this.intituleCarte = intituleCarte;
    }

    public String getTypeProduit() {
		return typeProduit;
	}

	public void setTypeProduit(String typeProduit) {
		this.typeProduit = typeProduit;
	}
	
	

	public String getIca() {
        return ica;
    }

    public void setIca(String ica) {
        this.ica = ica;
    }


    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getFabriquantPuce() {
        return fabriquantPuce;
    }

    public void setFabriquantPuce(String fabriquantPuce) {
        this.fabriquantPuce = fabriquantPuce;
    }

    public String getRefVisaMc() {
        return refVisaMc;
    }

    public void setRefVisaMc(String refVisaMc) {
        this.refVisaMc = refVisaMc;
    }

    public String getCouleurRecto() {
        return couleurRecto;
    }

    public void setCouleurRecto(String couleurRecto) {
        this.couleurRecto = couleurRecto;
    }

    public String getCouleurVerso() {
        return couleurVerso;
    }

    public void setCouleurVerso(String couleurVerso) {
        this.couleurVerso = couleurVerso;
    }

    public String getEffetsSpeciaux() {
        return effetsSpeciaux;
    }

    public void setEffetsSpeciaux(String effetsSpeciaux) {
        this.effetsSpeciaux = effetsSpeciaux;
    }

    public String getAutresEffets() {
        return autresEffets;
    }

    public void setAutresEffets(String autresEffets) {
        this.autresEffets = autresEffets;
    }

    public String getPanneauSignature() {
        return panneauSignature;
    }

    public void setPanneauSignature(String panneauSignature) {
        this.panneauSignature = panneauSignature;
    }

    public String getFinition() {
        return finition;
    }

    public String getPaiement() {
		return paiement;
	}

	public void setPaiement(String paiement) {
		this.paiement = paiement;
	}

	public void setFinition(String finition) {
        this.finition = finition;
    }

    public String getHologramme() {
        return hologramme;
    }

    public void setHologramme(String hologramme) {
        this.hologramme = hologramme;
    }

    public String getLaminat() {
        return laminat;
    }

    public void setLaminat(String laminat) {
        this.laminat = laminat;
    }

    public String getTypeImpRecto() {
        return typeImpRecto;
    }

    public void setTypeImpRecto(String typeImpRecto) {
        this.typeImpRecto = typeImpRecto;
    }

    public String getCouleurImp() {
        return couleurImp;
    }

    public void setCouleurImp(String couleurImp) {
        this.couleurImp = couleurImp;
    }

    public Date getDateReceptionFV() {
        return dateReceptionFV;
    }

    public void setDateReceptionFV(Date dateReceptionFV) {
        this.dateReceptionFV = dateReceptionFV;
    }

    public String getDemandeBatClt() {
        return demandeBatClt;
    }

    public void setDemandeBatClt(String demandeBatClt) {
        this.demandeBatClt = demandeBatClt;
    }

    public Date getDateEnvoiVisuelFr() {
        return dateEnvoiVisuelFr;
    }

    public void setDateEnvoiVisuelFr(Date dateEnvoiVisuelFr) {
        this.dateEnvoiVisuelFr = dateEnvoiVisuelFr;
    }

    public Date getDateReception() {
        return dateReception;
    }

    public void setDateReception(Date dateReception) {
        this.dateReception = dateReception;
    }

    public String getRefVisuel() {
        return refVisuel;
    }

    public Boolean getContact() {
		return contact;
	}

	public void setContact(Boolean contact) {
		this.contact = contact;
	}

	public Boolean getContactLess() {
		return contactLess;
	}

	public void setContactLess(Boolean contactLess) {
		this.contactLess = contactLess;
	}

	public void setRefVisuel(String refVisuel) {
        this.refVisuel = refVisuel;
    }

    public Date getDateEnvoiPdfClt() {
        return dateEnvoiPdfClt;
    }

    public void setDateEnvoiPdfClt(Date dateEnvoiPdfClt) {
        this.dateEnvoiPdfClt = dateEnvoiPdfClt;
    }

    public Date getDateEnvoiPdfCltVr1() {
        return dateEnvoiPdfCltVr1;
    }

    public void setDateEnvoiPdfCltVr1(Date dateEnvoiPdfCltVr1) {
        this.dateEnvoiPdfCltVr1 = dateEnvoiPdfCltVr1;
    }

    public Date getDateEnvoiPdfCltVr2() {
        return dateEnvoiPdfCltVr2;
    }

    public void setDateEnvoiPdfCltVr2(Date dateEnvoiPdfCltVr2) {
        this.dateEnvoiPdfCltVr2 = dateEnvoiPdfCltVr2;
    }

    public Date getDateEnvoiPdfCltVr3() {
        return dateEnvoiPdfCltVr3;
    }

    public void setDateEnvoiPdfCltVr3(Date dateEnvoiPdfCltVr3) {
        this.dateEnvoiPdfCltVr3 = dateEnvoiPdfCltVr3;
    }

    public Date getDateValidationClt() {
        return dateValidationClt;
    }

    public void setDateValidationClt(Date dateValidationClt) {
        this.dateValidationClt = dateValidationClt;
    }

    public Date getDateReceptionChromalin() {
        return dateReceptionChromalin;
    }

    public void setDateReceptionChromalin(Date dateReceptionChromalin) {
        this.dateReceptionChromalin = dateReceptionChromalin;
    }

    public Date getDateSoumissionVisaMc() {
        return dateSoumissionVisaMc;
    }

    public void setDateSoumissionVisaMc(Date dateSoumissionVisaMc) {
        this.dateSoumissionVisaMc = dateSoumissionVisaMc;
    }

    public Date getDateResoumissionVisaMc() {
        return dateResoumissionVisaMc;
    }

    public void setDateResoumissionVisaMc(Date dateResoumissionVisaMc) {
        this.dateResoumissionVisaMc = dateResoumissionVisaMc;
    }

    public Long getNumSoumission() {
        return numSoumission;
    }

    public void setNumSoumission(Long numSoumission) {
        this.numSoumission = numSoumission;
    }

    public Date getDateApprobationVisaMc() {
        return dateApprobationVisaMc;
    }

    public void setDateApprobationVisaMc(Date dateApprobationVisaMc) {
        this.dateApprobationVisaMc = dateApprobationVisaMc;
    }

    public Date getDateBonCdeS2M() {
        return dateBonCdeS2M;
    }

    public void setDateBonCdeS2M(Date dateBonCdeS2M) {
        this.dateBonCdeS2M = dateBonCdeS2M;
    }

    public Long getNumBonCdeS2M() {
        return numBonCdeS2M;
    }

    public void setNumBonCdeS2M(Long numBonCdeS2M) {
        this.numBonCdeS2M = numBonCdeS2M;
    }

    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }
    

    public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Date getDateEnlevement() {
        return dateEnlevement;
    }

    public void setDateEnlevement(Date dateEnlevement) {
        this.dateEnlevement = dateEnlevement;
    }

    public Date getDateReceptionS2M() {
        return dateReceptionS2M;
    }

    public void setDateReceptionS2M(Date dateReceptionS2M) {
        this.dateReceptionS2M = dateReceptionS2M;
    }

    public Boolean getFacturationLivraison() {
        return facturationLivraison;
    }

    public void setFacturationLivraison(Boolean facturationLivraison) {
        this.facturationLivraison = facturationLivraison;
    }

    public Long getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(Long numFacture) {
        this.numFacture = numFacture;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public String getTypePuce() {
        return typePuce;
    }

    public void setTypePuce(String typePuce) {
        this.typePuce = typePuce;
    }

    public String getCapacitePuce() {
        return capacitePuce;
    }

    public void setCapacitePuce(String capacitePuce) {
        this.capacitePuce = capacitePuce;
    }

    public Date getDateExpPuce() {
        return dateExpPuce;
    }

    public void setDateExpPuce(Date dateExpPuce) {
        this.dateExpPuce = dateExpPuce;
    }

    public String getMasquePuce() {
        return masquePuce;
    }

    public void setMasquePuce(String masquePuce) {
        this.masquePuce = masquePuce;
    }

	public Boolean getPuce() {
		return puce;
	}

	public void setPuce(Boolean puce) {
		this.puce = puce;
	}

	public Boolean getPiste() {
		return piste;
	}

	public void setPiste(Boolean piste) {
		this.piste = piste;
	}

	public Boolean getDda() {
		return dda;
	}

	public void setDda(Boolean dda) {
		this.dda = dda;
	}

	public Boolean getSda() {
		return sda;
	}

	public void setSda(Boolean sda) {
		this.sda = sda;
	}

	public Boolean getCda() {
		return cda;
	}

	public void setCda(Boolean cda) {
		this.cda = cda;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getCodeProduit() {
		return codeProduit;
	}

	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

    public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public String getScheime() {
		return scheime;
	}

	public void setScheime(String scheime) {
		this.scheime = scheime;
	}

	
}
