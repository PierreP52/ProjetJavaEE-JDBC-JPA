package com.reservation;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Hotel")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hotel_id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "adresse")
	private String adresse;
	
	@Column(name = "nombre_chambres_disponibles")
	private int nombre_chambres_disponibles;
	
	@Column(name = "classement_etoiles")
	private int classement_etoiles;
	
	 public Hotel() {
	 }
	 
	 public Hotel(String nom, String adresse, int nombre_chambres_disponibles, int classement_etoiles) {
	   this.nom = nom;
	   this.adresse = adresse;
	   this.nombre_chambres_disponibles = nombre_chambres_disponibles;
	   this.classement_etoiles = classement_etoiles;
	 }
	
	 // Getter and Setter for hotel_id
    public Long getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Long hotel_id) {
        this.hotel_id = hotel_id;
    }

    // Getter and Setter for nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter and Setter for adresse
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    // Getter and Setter for nombre_chambres_disponibles
    public int getNombre_chambres_disponibles() {
        return nombre_chambres_disponibles;
    }

    public void setNombre_chambres_disponibles(int nombre_chambres_disponibles) {
        this.nombre_chambres_disponibles = nombre_chambres_disponibles;
    }

    // Getter and Setter for classement_etoiles
    public int getClassement_etoiles() {
        return classement_etoiles;
    }

    public void setClassement_etoiles(int classement_etoiles) {
        this.classement_etoiles = classement_etoiles;
    }

	

}
