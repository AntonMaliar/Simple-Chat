package my.chat.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import my.chat.dao.UserDAO;
import my.chat.models.Message;
import my.chat.models.User;

@Controller
public class UserController {
	@GetMapping("/userProfile")
	public String getUserProfile(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		
		User user = UserDAO.getUser(userId);
		List<User> allRecipient = UserDAO.getAllRecipient(user);
		
		model.addAttribute("user", user);
		model.addAttribute("allRecipient", allRecipient);
		
		return "UserProfile";
	}
	@PostMapping("/createUser")
	public String createUser(HttpServletRequest request) {
		String userName = request.getParameter("name");
		UserDAO.addUser(new User(userName));
		
		return "redirect:index.jsp";
	}
	@GetMapping("/sendMessage")
	public String sendMessage(HttpServletRequest request, Model model) {
		int senderId = Integer.parseInt(request.getParameter("senderId"));
		int	recipientId = Integer.parseInt(request.getParameter("recipientId"));
		User sender = UserDAO.getUser(senderId);
		User recipient = UserDAO.getUser(recipientId);
		
		String textMessage = request.getParameter("message");
		sender.sendMessage(new Message(textMessage), recipient);
		
		model.addAttribute("senderId", senderId);
		model.addAttribute("recipientId", recipientId);
		
		return "redirect:openChat";
	}
	
}
