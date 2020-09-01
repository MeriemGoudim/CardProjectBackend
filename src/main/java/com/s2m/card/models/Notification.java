package com.s2m.card.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="notifications")
public class Notification implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idNotification")
    private Long id;

    @Column(name="message",nullable = false)
    private String message;

    @Column(name="confirmation",nullable = false)
    private Boolean confirmation;

    @Column(name="argument",nullable = false)
    private Boolean argument;

    @Column(name="affichage",nullable = false)
    private Boolean affichage;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    public Notification() {
        super();
    }

    public Notification(String message, Boolean confirmation, Boolean argument, User user) {
        this.message = message;
        this.confirmation = confirmation;
        this.argument = argument;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }

    public Boolean getArgument() {
        return argument;
    }

    public void setArgument(Boolean argument) {
        this.argument = argument;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "message='" + message + '\'' +
                ", confirmation=" + confirmation +
                ", argument=" + argument +
                ", user=" + user +
                '}';
    }
}
