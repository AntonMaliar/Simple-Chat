<%@page import="my.chat.dao.UserDAO"%>
<%@page import="my.chat.models.User"%>
<%@page import="java.util.List"%>
<html>
<body>
<h2>Welcome Page</h2>
	<h3>Create User</h3>
	<form action="createUser" method="post">
		<label for="name">Input name:</label>
		<input type="text" id="name" name="name">
		<input type="submit" value="create">
	</form>
	<hr>
	<h3>All User:</h3>
	<%
		List<User> listOfUsers = UserDAO.getListOfUsers();
		for(User user : listOfUsers){
	%>
		<a href="userProfile?id=<%=user.getId()%>"><%=user.getName() %></a><br>
	<%} %>
</body>
</html>
