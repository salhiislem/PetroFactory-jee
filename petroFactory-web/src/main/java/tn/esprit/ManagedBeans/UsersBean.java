package tn.esprit.ManagedBeans;

import java.io.Serializable;
//import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import persistence.User;
import services.UserService;

@ManagedBean
@SessionScoped
public class UsersBean implements Serializable {
private int nb;
	
	public int getNb() {
		return userService.findAllUsers().size();
	}
	public void setNb(int nb) {
		this.nb = nb;
	}
	private static final long serialVersionUID = 1L;
	private String firstname;
	private String lastname;
	// private Date birthday;
	private String username;
	private String password;
	private String email;
	private String numTel;
	private String address;
	private User user;

	public UsersBean() {
		super();
	}

	@EJB
	UserService userService;
	public List<User> users;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<User> getUsers() {
		users = userService.getAllUsers();

		return users;
	}

	public void AddUser() {
		userService.createUser(new User(firstname, lastname, username, password, email, numTel, address));
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public UsersBean(String firstname, String lastname, String username, String password, String email, String numTel) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		// this.birthday = birthday;
		this.username = username;
		this.password = password;
		this.email = email;
		this.numTel = numTel;
	}
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public void deleteUser(int id) {
		userService.deleteUser(id);

	}
public String GoToJobOffersBack(){
	 
return "/pages/JobOffersBack?faces-redirect=true";
}
}
