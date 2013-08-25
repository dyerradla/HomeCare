 
 <%@page import="com.homecare.domain.User"%>
<ul>
    <li style="font-size: 14px;"><a href="/HomeCare/editUser.do">Edit User Info</a></li>
  	<% 
  		User user = (User)session.getAttribute("user");
  		String role = user.getRole();
  	if("A".equalsIgnoreCase(role)){ %>
  		<li style="font-size: 14px;"><a href="/HomeCare/createUser.do">Create New User</a></li>
	   	<li style="font-size: 14px;"><a href="/HomeCare/editEmployerInfo.do">Edit Employer Info</a></li>
  	<% } %>
</ul>