package services;

import java.util.List;

import javax.ejb.Local;

import persistence.JobOffer;

@Local
public interface JobOfferServiceLocal {
	public List<JobOffer> findAllOffers();

}
