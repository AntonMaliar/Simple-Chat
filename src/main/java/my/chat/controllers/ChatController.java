package my.chat.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import my.chat.dao.UserDAO;
import my.chat.models.Message;
import my.chat.models.User;

@Controller
public class ChatController {
	
	@GetMapping("/openChat")
	public String openChat(HttpServletRequest request, Model model) {
		int senderId = Integer.parseInt(request.getParameter("senderId"));
		int	recipientId = Integer.parseInt(request.getParameter("recipientId"));
		// логіка яка провіряє чи є відправника чат з отримувачем
		User sender = UserDAO.getUser(senderId);
		User recipient = UserDAO.getUser(recipientId);
		sender.checkChat(recipient);
		List<Message> chatHistory = sender.getChat(recipient).getChatHistory();
		
		model.addAttribute("chatHistory", chatHistory);
		model.addAttribute("recipient", recipient);
		model.addAttribute("sender", sender);
		
		return "Chat";
	}
}
