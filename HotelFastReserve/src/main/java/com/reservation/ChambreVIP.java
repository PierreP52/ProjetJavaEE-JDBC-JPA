package com.reservation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VIP")
public class ChambreVIP extends Chambre {
    
    
    public ChambreVIP() {
    	
    }
}