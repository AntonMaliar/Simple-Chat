package my.chat.dao;

import java.util.ArrayList;
import java.util.List;

import my.chat.models.User;

public class UserDAO {
	private static List<User> listOfUsers;
	private static int INDEX = 0;
	
	static {
		listOfUsers = new ArrayList<>();
	}
	
	public static List<User> getListOfUsers() {
		return listOfUsers;
	}

	public static void setListOfUsers(List<User> listOfUsers) {
		UserDAO.listOfUsers = listOfUsers;
	}

	public static void addUser(User user) {
		user.setId(INDEX++);
		listOfUsers.add(user);
	}
	
	public static User getUser(int id) {
		return listOfUsers.get(id);
	}
	
	public static List<User> getAllRecipient(User sender){
		List<User> allRecipient = new ArrayList<>();
		allRecipient.addAll(listOfUsers);
		allRecipient.remove(sender.getId());
		return allRecipient;
	}
}
