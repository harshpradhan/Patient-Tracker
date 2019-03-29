<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clerk Details</title>
</head>
<body>
<table>
<tr>
<th>Clerk Id</th>
<th>Clerk First Name</th>
<th>Clerk Last Name</th>
<th>Clerk Age </th>
<th>Clerk Gender</th>
<th>Clerk DOB</th>
<th>Clerk Contact No.</th>
<th>Clerk Alt No.</th>
<th>Clerk Email-id</th>
<th>Clerk AddressLine1</th>
<th>Clerk AddressLine2</th>
<th>Clerk City</th>
<th>Clerk State</th>
<th>Clerk Zip-code</th>

</tr>

<c:forEach items="${clerkList}" var="clerk">
<tr>
<td><c:out value="${clerk.clerkId}"/></td>
<td><c:out value="${clerk.firstName}"/></td>
<td><c:out value="${clerk.lastName}"/></td>
<td><c:out value="${clerk.age}"/></td>
<td><c:out value="${clerk.gender}"/></td>
<td><c:out value="${clerk.dob}"/></td>
<td><c:out value="${clerk.contactNumber}"/></td>
<td><c:out value="${clerk.alternateContactNumber}"/></td>
<td><c:out value="${clerk.emailId}"/></td>
<td><c:out value="${clerk.addressLine1}"/></td>
<td><c:out value="${clerk.addressLine2}"/></td>
<td><c:out value="${clerk.city}"/></td>
<td><c:out value="${clerk.state}"/></td>
<td><c:out value="${clerk.zipCode}"/></td>

</c:forEach>

</table>
<table>
<tr>
<td>
<form method="get" action="addclerkform.htm">
<input type="submit" value="Add Clerk"/>
</form>
</td>
<td>
<form method="get" action="clerkform.htm">
<input type="submit" value="Update Clerk"/>
</form>
</td>
<td>
<form method="get" action="clerkform.htm">
<input type="submit" value="Delete Clerk"/>
</form>
</td>
</tr>
</body>
</html>