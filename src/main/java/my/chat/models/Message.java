package my.chat.models;

import java.util.Date;

public class Message {
	private User sender;
	private Date date;
	private String value;
	
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Message(String value) {
		this.value = value;
	}
	public String showMessage() {
		return "{"+date+"}{"+sender.getName()+"}{"+value+"}";
	}
}
