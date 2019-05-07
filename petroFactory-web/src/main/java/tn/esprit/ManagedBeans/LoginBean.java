package tn.esprit.ManagedBeans;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import persistence.User;
import services.UserService;
@ManagedBean
@SessionScoped
//(name="loginBean")

public class LoginBean {

	public LoginBean() {
		super();
	}
	
	private String login;
	private String password;
    private int id;
	
	    private String firstname;
		
	    private String lastname;

	  
		
	    private String username;
		
	   
		
	    private String email;
		
	    private String numTel;
	private User user;
	private boolean loggedIn;
	private String repeat;
	private String adress;
	@EJB
	private UserService userService;
	
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getRepeat() {
		return repeat;
	}

	public void setRepeat(String repeat) {
		this.repeat = repeat;
	}

	public String doLogin() {
	/*	System.out.println("login " + login);
		System.out.println("pwd "+ password);
		*/
		System.out.println("login btnclickd");
		System.out.println("user"+login);
		String navigateTo = "null";
		user = userService.loginUser(login, password);
		
		if (user != null )
		{ 
			navigateTo = "/indexAdmin?faces-redirect=true";
			setLoggedIn(true);
		}else {
			FacesContext.getCurrentInstance().addMessage("form:btn",new FacesMessage("bad credentials"));		}
	
	return navigateTo;
}

	public String getLogin() {
		return login;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String DoLogout()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		setLoggedIn(false);
		return "/template/index?faces-redirect=true";
	}
	public void CreateUser()
	{
		userService.createUser(new User( firstname, lastname, username,  password,  email,
				numTel,adress));
	}
}
