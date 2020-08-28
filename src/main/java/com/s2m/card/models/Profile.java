package com.s2m.card.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="profiles")
public class Profile implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProfile")
    private Long id;

    @OneToMany(mappedBy = "profile")
    private List<Notification> notifications;

    @Column(name="nom",nullable = false)
    private String nom;

    @Column(name="preferences",nullable = false)
    private String preferences;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    @Override
    public String toString() {
        return "Profile{" +
                ", notifications=" + notifications +
                ", nom='" + nom + '\'' +
                ", preferences='" + preferences + '\'' +
                '}';
    }
}
