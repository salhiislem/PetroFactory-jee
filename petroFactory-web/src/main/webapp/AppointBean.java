package tn.esprit.Test2.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tn.esprit.Test2.services.TrackService;
import tn.esprit.Test2.services.WorkerServiceRemote;

@ManagedBean
@RequestScoped
public class AppointBean {
	
	@EJB
	private TrackService TrackService;
	@EJB
	private WorkerServiceRemote WorkerService;

}
