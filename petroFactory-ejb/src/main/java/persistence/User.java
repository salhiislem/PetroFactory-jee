package persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import utils.AccountState;
import utils.Gender;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_role", discriminatorType = DiscriminatorType.STRING)

public class User implements Serializable {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int id;
		@Column(nullable = false)
	    private String firstname;
		@Column(nullable = false)
	    private String lastname;

	    @Temporal(TemporalType.DATE)
	    private Date birthday;
		@Column(nullable = false)
	    private String username;
		@Column(nullable = false)
	    private String password;
		@Column(unique = true,nullable = false)
	    private String email;
		@Column(nullable = false)
	    private String numTel;
		@OneToMany (mappedBy="jobSeeker")
		private List<JobRequest> jobRequests;
		private static User ConnectedUser;

	 public static User getConnectedUser() {
			return ConnectedUser;
		}
		public static void setConnectedUser(User connectedUser) {
			ConnectedUser = connectedUser;
		}
	public List<JobRequest> getJobRequests() {
			return jobRequests;
		}
		public void setJobRequests(List<JobRequest> jobRequests) {
			this.jobRequests = jobRequests;
		}

		/*   @Column(name = "active", columnDefinition = "tinyint(1) default 1")
	    private Boolean active;
*/
	    @Enumerated
	    private Gender gender;

	    
	    private String address;
	    
	    private String profileImage;
		@Column(unique = true,nullable = false)
	    private String confirmationToken;
	    private AccountState accountState;
	
		public User(int id, String firstname, String lastname, String username, String numTel,String email,String password, AccountState accountState, String confirmationToken) {
			super();
			this.id = id;
			this.firstname = firstname;
			this.lastname = lastname;
			this.username = username;
			this.password = password;
			this.email = email;
			this.numTel = numTel;
			this.confirmationToken = confirmationToken;
			this.accountState = accountState;
		}
		public User(int id, String firstname, String lastname, String username,String profileImage, String numTel,String email,String password, AccountState accountState, String confirmationToken) {
			super();
			this.id = id;
			this.firstname = firstname;
			this.lastname = lastname;
			this.username = username;
			this.password = password;
			this.email = email;
			this.numTel = numTel;
			this.confirmationToken = confirmationToken;
			this.accountState = accountState;
			this.profileImage =profileImage;

		}
		
		public User(int id, String firstname, String lastname, String username,String profileImage, String numTel,String email,String password, AccountState accountState, String confirmationToken,Gender gender,String address,Date birthday) {
			super();
			this.id = id;
			this.firstname = firstname;
			this.lastname = lastname;
			this.username = username;
			this.password = password;
			this.email = email;
			this.numTel = numTel;
			this.confirmationToken = confirmationToken;
			this.accountState = accountState;
			this.profileImage =profileImage;
			this.gender = gender;
			this.address = address;
			this.birthday = birthday;
		}
	public AccountState getAccountState() {
			return accountState;
		}

		public void setAccountState(AccountState accountState) {
			this.accountState = accountState;
		}

	public String getConfirmationToken() {
			return confirmationToken;
		}

		public void setConfirmationToken(String confirmationToken) {
			this.confirmationToken = confirmationToken;
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

		public Date getBirthday() {
			return birthday;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
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

	/*	public Boolean getActive() {
			return active;
		}

		public void setActive(Boolean active) {
			this.active = active;
		}*/
		public Gender getGender() {
			return gender;
		}

		public User(String firstname, String lastname, Date birthday, String username, String password, String email,
				String numTel, String address) {
			super();
			this.firstname = firstname;
			this.lastname = lastname;
			this.birthday = birthday;
			this.username = username;
			this.password = password;
			this.email = email;
			this.numTel = numTel;
			this.address = address;
		}

		public User(String firstname, String lastname,  String username, String password, String email,
				String numTel, String address) {
			super();
			this.firstname = firstname;
			this.lastname = lastname;
			this.username = username;
			this.password = password;
			this.email = email;
			this.numTel = numTel;
		
			this.address = address;
		}

		public void setGender(Gender gender) {
			this.gender = gender;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getProfileImage() {
			return profileImage;
		}

		public void setProfileImage(String profileImage) {
			this.profileImage = profileImage;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public User(int id) {
		super();
		this.id = id;
	}
	 
}
