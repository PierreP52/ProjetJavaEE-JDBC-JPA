package com.reservation;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorType;

@Entity
@Table (name = "Chambre")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_chambre", discriminatorType = DiscriminatorType.STRING)
public abstract class Chambre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long chambre_id;
	
	@Column(name = "numero_chambre")
	private String numero_chambre;
	
	
	@Column(name = "tarif_journalier")
	private Double tarif_journalier;
	
	@Column(name = "nombre_de_lits")
	private int nombre_de_lits;
	
	@Column(name = "disponibilite")
	private boolean disponibilite;
	
	@OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL)
    private List<Reservation> reservations;
	
	public Chambre() {}
	
	public Chambre(String numero_chambre, Double tarif_journalier, int nombre_de_lits, boolean disponibilite) {
		this.numero_chambre = numero_chambre;
		this.tarif_journalier = tarif_journalier;
		this.nombre_de_lits = nombre_de_lits;
		this.disponibilite = disponibilite;
	}
	
	
	
	// Getter and Setter for reservations
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
 // Getter and Setter for chambre_id
    public Long getChambre_id() {
        return chambre_id;
    }

    public void setChambre_id(Long chambre_id) {
        this.chambre_id = chambre_id;
    }

    // Getter and Setter for numero_chambre
    public String getNumero_chambre() {
        return numero_chambre;
    }

    public void setNumero_chambre(String numero_chambre) {
        this.numero_chambre = numero_chambre;
    }


    // Getter and Setter for tarif_journalier
    public Double getTarif_journalier() {
        return tarif_journalier;
    }

    public void setTarif_journalier(Double tarif_journalier) {
        this.tarif_journalier = tarif_journalier;
    }

    // Getter and Setter for nombre_de_lits
    public int getNombre_de_lits() {
        return nombre_de_lits;
    }

    public void setNombre_de_lits(int nombre_de_lits) {
        this.nombre_de_lits = nombre_de_lits;
    }

    // Getter and Setter for disponibilite
    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }
    
   

    

	
}
