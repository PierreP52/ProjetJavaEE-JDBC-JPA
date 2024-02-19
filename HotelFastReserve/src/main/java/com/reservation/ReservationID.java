package com.reservation;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class ReservationID implements Serializable {
	
	@Column (name ="client_id")
	private Long clientID;
	
	@Column (name ="chambre_id")
	private Long chambreID;
	
	@Column (name ="dateReservation")
	private Date dateReservation;
	
	public ReservationID() {
		
	}

	public ReservationID(Long clientID, Long chambreID, Date dateReservation) {
		this.clientID = clientID;
		this.chambreID = chambreID;
		this.dateReservation = dateReservation;
		
	}
	
	public Long getClientID() {
		return clientID;
	}
	
	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}
	
	public Long getChambreID() {
		return chambreID;
	}
	
	public void setChambreID(Long chambreID) {
		this.chambreID = chambreID;
	}
	
	public Date getDateReservation() {
		return dateReservation;
	}
	
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	
	@Override
	public int hashCode() {
	    return Objects.hash(clientID, chambreID, dateReservation);
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    ReservationID that = (ReservationID) o;
	    return Objects.equals(clientID, that.clientID) &&
	           Objects.equals(chambreID, that.chambreID)&&
	           Objects.equals(dateReservation, that.dateReservation);
	}
	
	@Override
	public String toString() {
		return "ReservationID{" +
				"clientID=" + clientID +
				", chambreID=" + chambreID +
				", dateReservation=" + dateReservation +
				'}';
	}
}
