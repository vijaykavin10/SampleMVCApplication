<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Web Application</title>
	<style type="text/css">
		body {
			font-family: sans-serif;
		}
		.data, .data td {
			border-collapse: collapse;
			width: 100%;
			border: 1px solid #aaa;
			margin: 2px;
			padding: 2px;
		}
		.data th {
			font-weight: bold;
			background-color: #5C82FF;
			color: white;
		}
	</style>
</head>
<body>

<h2>Contact</h2>

<form:form method="post" action="add.html" commandName="contact">

	<table>
	<tr>
		<td><form:label path="firstname"><spring:message code="label.firstname"/></form:label></td>
		<td><form:input path="firstname" /></td> 
	</tr>
	<tr>
		<td><form:label path="lastname"><spring:message code="label.lastname"/></form:label></td>
		<td><form:input path="lastname" /></td>
	</tr>
	<tr>
		<td><form:label path="email"><spring:message code="label.email"/></form:label></td>
		<td><form:input path="email" /></td>
	</tr>
	<tr>
		<td><form:label path="telephone"><spring:message code="label.telephone"/></form:label></td>
		<td><form:input path="telephone" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="<spring:message code="label.addcontact"/>"/>
		</td>
	</tr>
</table>	
</form:form>

	
<h3>Contacts</h3>
<c:if  test="${!empty contactList}">
<table class="data">
<tr>
	<th>Name</th>
	<th>Email</th>
	<th>Telephone</th>
	<th>Operations</th>
</tr>
<c:forEach items="${contactList}" var="contact">
	<tr>
		<td  style="width: 15%;"> ${contact.firstname} ${contact.lastname}</td>
		<td style="width:20%;">${contact.email}</td>
		<td style="width: 15% !important;">${contact.telephone}</td>
		<td style="width:15%"><a href="delete/${contact.id}">edit</a>
		<a href="delete/${contact.id}">delete</a></td>
	</tr>
</c:forEach>
</table>
</c:if>

</body>
</html>
