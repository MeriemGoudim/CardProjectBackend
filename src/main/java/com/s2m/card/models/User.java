package com.s2m.card.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users",uniqueConstraints = {@UniqueConstraint(columnNames = "username"),@UniqueConstraint(columnNames = "email")})
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUser")
    private Long id;

    @Column(name="username",nullable = false)
    @Size(max = 20)
    private String username;

    @Column(name="email",nullable = false)
    @Email
    @Size(max = 50)
    private String email;

    @Column(name="password",nullable = false)
    @Size(max=120)
    private String password;

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<InfosCard> infoscards;

    @OneToMany(mappedBy = "user")
    private List<Notification> notifications;
    
    @OneToMany(mappedBy = "user")
    private List<Processus> processus;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "idUser"), inverseJoinColumns = @JoinColumn(name="idRole"))
    private Set<Role> roles=new HashSet<>();

    public User() {
    }

    public User(@Size(max = 20) String username, @Email @Size(max = 50) String email, @Size(max = 120) String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<InfosCard> getInfoscards() {
        return infoscards;
    }

    public void setInfoscards(List<InfosCard> infoscards) {
        this.infoscards = infoscards;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
    

    public List<Processus> getProcessus() {
		return processus;
	}

	public void setProcessus(List<Processus> processus) {
		this.processus = processus;
	}

	public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", infoscards=" + infoscards +
                ", notifications=" + notifications +
                ", processus=" + processus +
                ", roles=" + roles +
                '}';
    }
}
