package persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import utils.AccountState;
import utils.Role;
import utils.TypeContrat;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
@DiscriminatorValue(value="Employee")
public class Employee extends User implements Serializable {

	private Role EmployeeRole;
	@Enumerated
	private TypeContrat typeContrat;
	 @Temporal(TemporalType.DATE)
	private Date dateEmbauche;
	 @Temporal(TemporalType.DATE)
	private Date dateFinContrat;
	private double salaire;
	private static final long serialVersionUID = 1L;

	public TypeContrat getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(TypeContrat typeContrat) {
		this.typeContrat = typeContrat;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public Date getDateFinContrat() {
		return dateFinContrat;
	}

	public void setDateFinContrat(Date dateFinContrat) {
		this.dateFinContrat = dateFinContrat;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	public Role getEmployeeRole() {
		return EmployeeRole;
	}

	public void setEmployeeRole(Role employeeRole) {
		EmployeeRole = employeeRole;
	}

	public Employee() {
		super();
	}

	public Employee(int id, String firstname, String lastname, String username, String numTel, String email,
			String password, AccountState accountState, String confirmationToken, Role role, TypeContrat typeContrat,
			Date dateEmbauche, Date dateFinContrat, double salaire) {
		super(id, firstname, lastname, username, numTel, email, password, accountState, confirmationToken);
		this.EmployeeRole = role;
		this.typeContrat = typeContrat;
		this.dateEmbauche = dateEmbauche;
		this.dateFinContrat = dateFinContrat;
		this.salaire = salaire;
	}
   
}
