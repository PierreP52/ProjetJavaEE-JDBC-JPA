package com.reservation;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Reservation")
public class Reservation {
	
	@EmbeddedId
	private ReservationID id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chambre_id", insertable = false, updatable = false)
    private Chambre chambre;
	
    @Column(name = "dateReservation", insertable = false, updatable = false)
    private Date dateReservation;
	
	@Column(name = "date_fin")
	private Date date_fin;
	
	@Column(name = "montant_total")
	private Double montant_total;
	
	@Column(name = "statut_confirmation")
	private String statut_confirmation;
	
	 public Reservation() {
	        
	    }
	 
	 public Reservation(ReservationID id, Client client, Chambre chambre, Date dateReservation, Date date_fin, Double montant_total, String statut_confirmation) {
	     
		 this.id = id;
		 this.client = client;
		 this.chambre = chambre;
		 this.dateReservation = dateReservation;
		 this.date_fin = date_fin;
		 this.montant_total = montant_total;
		 this.statut_confirmation = statut_confirmation;
		 
	    }
	
	// Getter and Setter for id
    public ReservationID getId() {
        return id;
    }

    public void setId(ReservationID id) {
        this.id = id;
    }
    
    

    // Getter and Setter for dateReservation
    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    // Getter and Setter for date_fin
    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    // Getter and Setter for montant_total
    public Double getMontant_total() {
        return montant_total;
    }

    public void setMontant_total(Double montant_total) {
        this.montant_total = montant_total;
    }

    // Getter and Setter for statut_confirmation
    public String getStatut_confirmation() {
        return statut_confirmation;
    }

    public void setStatut_confirmation(String statut_confirmation) {
        this.statut_confirmation = statut_confirmation;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, dateReservation, date_fin, montant_total, statut_confirmation);
    }
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(dateReservation, that.dateReservation) &&
               Objects.equals(date_fin, that.date_fin) &&
               Objects.equals(montant_total, that.montant_total) &&
               Objects.equals(statut_confirmation, that.statut_confirmation);
    }
	
    @Override
    public String toString() {
        return "Reservation{" +
               "id=" + id +
               ", dateReservation=" + dateReservation +
               ", date_fin=" + date_fin +
               ", montant_total=" + montant_total +
               ", statut_confirmation='" + statut_confirmation + '\'' +
               '}';
    }
}
