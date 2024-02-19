package com.reservation;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long client_id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "numero_telephone")
	private String numero_telephone;
	
	
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	/*CascadeType.All: Cette stratégie est pratique 
	 * lorsque vous souhaitez que les opérations de persistance 
	 * sur un client (par exemple, la suppression d'un client) 
	 * soient également appliquées à ses réservations. 
	 * Cela simplifie le processus de gestion des entités liées. 
	 * 
	 * FetchType.LAZY: Cela convient généralement aux situations où la plupart du temps, 
	 * vous n'avez pas besoin de charger les réservations lors du chargement d'un client, 
	 * ce qui peut réduire le temps de chargement initial.
	 */
    private List<Reservation> reservations;
	
	 public Client() {
	        
	    }
	 
	 // Constructeur avec des arguments
    public Client(String nom, String prenom, String email, String numero_telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numero_telephone = numero_telephone;
    }
	 
	 
	
	// Getter and Setter for reservations
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
	
	public Long getClientID() {
		return client_id;
	}
	
	public void setClientID(Long clientID) {
		this.client_id = clientID;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNumTel() {
		return numero_telephone;
	}
	
	public void setNumTel(String numero_telephone) {
		this.numero_telephone = numero_telephone;
	}
}


