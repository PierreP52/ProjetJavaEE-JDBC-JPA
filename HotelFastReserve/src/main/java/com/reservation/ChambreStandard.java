package com.reservation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("STANDARD")
public class ChambreStandard extends Chambre {
	
	public ChambreStandard() {
		
    }
}
