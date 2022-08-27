package my.chat.models;

import java.util.Date;
import java.util.HashMap;

public class User {
	private int id;
	private String name;
	private HashMap<User, Chat> allChats = new HashMap<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<User, Chat> getAllChats() {
		return allChats;
	}
	public void setAllChats(HashMap<User, Chat> allChats) {
		this.allChats = allChats;
	}
	public User (String name) {
		this.name = name;
	}
	public void checkChat(User recipient) {
		if(allChats.containsKey(recipient)) {
			return;
		}else {
			Chat chat = new Chat();
			this.addChat(recipient, chat);
			recipient.addChat(this, chat);
		}
	}
	public void addChat(User recipient, Chat chat) {
		allChats.put(recipient, chat);
	}
	public Chat getChat(User recipient) {
		return allChats.get(recipient);
	}
	public void sendMessage(Message message, User recipient) {
		Chat chat = allChats.get(recipient);
		message.setSender(this);
		message.setDate(new Date());
		chat.saveMessage(message);
	}
	
}
