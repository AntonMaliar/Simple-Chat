package my.chat.models;

import java.util.ArrayList;
import java.util.List;

public class Chat {
	private int id;
	private List<Message> chatHistory = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Message> getChatHistory() {
		return chatHistory;
	}
	public void setChatHistory(List<Message> chatHistory) {
		this.chatHistory = chatHistory;
	}
	public void saveMessage(Message message) {
		chatHistory.add(message);
	}
}
