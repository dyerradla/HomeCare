<link rel="stylesheet" href="styles/EmpoyeeManagement.css" type="text/css">
 <%@page import="com.homecare.domain.User"%>
<ul>
    <li><a href="/HomeCare/editUser.do">Edit User Info</a></li>
  	<% 
  		User user = (User)session.getAttribute("user");
  		String role = user.getRole();
  	if("A".equalsIgnoreCase(role)){ %>
  		<li><a href="/HomeCare/createUser.do">Create New User</a></li>
	   	<li><a href="/HomeCare/editEmployerInfo.do">Edit Employer Info</a></li>
  	<% } %>
</ul>