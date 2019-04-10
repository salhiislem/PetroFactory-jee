package services;

import java.util.List;

import javax.ejb.Remote;

import persistence.JobOffer;


@Remote
public interface JobOfferServiceRemote {
	public List<JobOffer> findAllOffers();
	public JobOffer findOfferById(int id);
}
