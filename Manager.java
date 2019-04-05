package tn.esprit.petroFact.entity;

import java.io.Serializable;


import javax.persistence.Entity;

@Entity
public class Manager extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idStation;
	
	public Integer getIdStation() {
		return idStation;
	}
	public void setIdStation(Integer idStation) {
		this.idStation = idStation;
	}
	

}
