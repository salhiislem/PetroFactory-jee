package tn.esprit.ManagedBeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import utils.Degree;
@ManagedBean
@ApplicationScoped
public class RoleComb {

	public RoleComb() {
		// TODO Auto-generated constructor stub
	}
public Degree[] getDegree()
{ return Degree.values();
	}
}
