package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.codec.digest.DigestUtils;

import persistence.Employee;
import persistence.User;
import utils.AccountState;
import utils.MD5;
import utils.MD5Hash;

@Stateless
public class UserService implements UserServiceRemote, UserServiceLocal {
	@PersistenceContext(unitName = "petroFactory-ejb")
	EntityManager entityManager;
	
	@Override
	public void createUser(User user) {
		user.setPassword(MD5Hash.getMD5Hash(user.getPassword()));
		user.setAccountState(AccountState.NOTACTIVATED);
		String activationHashedCode = MD5Hash.getMD5Hash(user.getUsername() + user.getEmail());
		user.setConfirmationToken(activationHashedCode);
		
		// Emailer.sendEmail("Eventify Account Activation",
		// "http://localhost:18080/Eventify-web/rest/users/confirm/"+activationHashedCode,
		// user.getEmail());
		entityManager.persist(user);
		// Emailer.SendEmail(user.getEmail(), "Eventify Account Activation",
		// EmailTemplate.activiationTemplate("http://localhost:18080/Eventify-web/rest/users/confirm/"+activationHashedCode));
		System.out.println("ajout avec succes");
	}
	@Override
	public boolean activateAccount(String confirmationToken) {
		Query query = entityManager.createQuery(
				"SELECT u FROM User u WHERE u.confirmationToken=:param");
		User u = null;
		try {
			u = (User) query.setParameter("param", confirmationToken).getSingleResult();

			if (u != null && u.getConfirmationToken().equals(confirmationToken)) {
				User userTochange = findUserById(u.getId());
				userTochange.setAccountState(AccountState.ACTIVATED);
				String faceListName = userTochange.getUsername();
				System.out.println("\n\n\n\n\n\n\n\n facename :  " + faceListName + "\n\n\n\n\n\n\n\n ");
				
				updateUser(userTochange);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("\n\n\n\n\n\n confirmationToken Not Found | User Not Set \n\n\n\n\n\n ");
			return false;
		}

		}

	
	@Override
	public User findUserById(int id) {
		Query query = entityManager.createQuery(
				"SELECT new User(u.id,u.firstname,u.lastname,u.username,u.profileImage,u.numTel,u.email,u.password,u.accountState,u.confirmationToken) "
						+ "FROM User u WHERE u.id=:param");
		return (User) query.setParameter("param", id).getSingleResult();
	}
	@Override
	public List<User> findAllUsers() {
		Query query = entityManager.createQuery(
				"SELECT new User(u.id,u.firstname,u.lastname,u.username,u.profileImage,u.numTel,u.email,u.password,u.accountState,u.confirmationToken,u.gender,u.address,u.birthday) "
						+ "FROM User u");
		return (List<User>) query.getResultList();
	}
	@Override
	public void updateUser(User user) {
		entityManager.merge(user);

	}
	@Override
	public void deleteUser(int id) {
		entityManager.remove(entityManager.find(User.class, id));

		
	}
	@Override
	public User loginUser(String username, String pwd) {
		System.out.println("user: " + username);
        System.out.println("password:" + MD5.crypt(pwd));
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> c = cb.createQuery(User.class);
        Root<User> emp = c.from(User.class);
        c.select(emp)
                .where(cb.equal(emp.get("username"), username),
                        cb.equal(emp.get("password"), MD5.crypt(pwd)));

        try {
        	
            return entityManager.createQuery(c).getSingleResult();
        } catch (Exception e) {
            return null;
        }
	
	}
	@Override
	public boolean changePwd(User user, String oldPwd, String newPwd) {
		System.out.println("\n\n\n\n\n\n\n\n u : "+user.getId()+"\n\n\n\n\n\n\n\n\n");
		Query query = entityManager.createQuery(
				"SELECT new User(u.id,u.firstname,u.lastname,u.username,u.numTel,u.email,u.password,u.accountState,u.confirmationToken) "
						+ "FROM User u WHERE  (u.id=:uid)");
		User userToChnage = (User) query.setParameter("uid", user.getId()).getSingleResult();
		if (user.getPassword().equals(MD5Hash.getMD5Hash(oldPwd))) {
			user.setPassword(MD5Hash.getMD5Hash(newPwd));
			entityManager.merge(user);
			return true;
		}
		return false;	}
	@Override
	public User findByMail(String mail) {
		Query query = entityManager.createQuery(
				"SELECT new User(u.id,u.firstname,u.lastname,u.username,u.numTel,u.email,u.password,u.accountState,u.confirmationToken) " + "FROM User u WHERE u.email=:param");
		User u = null;
		try {
			u = (User) query.setParameter("param", mail).getSingleResult();
			return u;
		} catch (Exception e) {
			System.out.println("\n\n\n\n\n\n mail Not Found | User Not Set \n\n\n\n\n\n ");
			return null;
		}
	}
	@Override
	public List<User> filterUsersByName(String name) {
		Query query = entityManager.createQuery(
				"SELECT u FROM Employee u WHERE u.lastname like :param OR  u.firstname like :param OR  u.username like :param");
		
		return (List<User>) query.setParameter("param","%"+name+"%").getResultList();
	}

}


