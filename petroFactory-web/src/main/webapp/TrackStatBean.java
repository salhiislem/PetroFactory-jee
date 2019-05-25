package tn.esprit.Test2.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tn.esprit.Test2.services.TrackService;

@ManagedBean
@RequestScoped
public class TrackStatBean {
	

	@EJB
	private TrackService TrackService;

}
