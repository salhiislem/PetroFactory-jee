package services;

import java.util.List;

import javax.ejb.Local;

import persistence.User;
@Local
public interface UserServiceLocal {
	public void createUser(User user);
	public boolean activateAccount(String confirmationToken);
	public User findUserById(int id);
	public List<User> findAllUsers();
	public void updateUser(User user);
	public void deleteUser(int id);
	public User loginUser(String username, String pwd);
	public boolean changePwd(User user, String oldPwd, String newPwd);
	public User findByMail(String mail);
	public List<User> filterUsersByName(String name);


}
