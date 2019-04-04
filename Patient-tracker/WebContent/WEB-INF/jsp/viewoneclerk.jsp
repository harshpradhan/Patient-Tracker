<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="springcore" %>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clerk Entry</title>
<style>
.error {
color: #ff0000;
font-style: italic;
}
</style>
</head>
<body>
<springform:form commandName="oneClerk" method="post" action="updateclerk.htm">
<table>
<tr>
<td><springform:label path="clerkId" >Clerk Id:</springform:label></td>
<td><springform:input path="clerkId" disabled="true"/>
<springform:errors path="clerkId" cssClass="error" ></springform:errors>
</td>
</tr>
<tr>
<td><springform:label path="firstName" >First Name:</springform:label></td>
<td><springform:input path="firstName"/>
<springform:errors path="firstName" cssClass="error" ></springform:errors>
</td>
</tr>
<tr>
<td><springform:label path="lastName" >Last Name:</springform:label></td>
<td><springform:input path="lastName"/>
<springform:errors path="lastName" cssClass="error"></springform:errors>
</td>
</tr>
<tr>
<td><springform:label path="age" >Age:</springform:label></td>
<td><springform:input path="age"/>
<springform:errors path="age" cssClass="error"></springform:errors>
</td>
</tr>
<tr>
<td><springform:label path="gender" >Gender:</springform:label></td>
<td><springform:select path="gender">
    <springform:options items="${gender}"/>
    
    </springform:select>
</td>
</tr>
<tr>
<td><springform:label path="dob" >DOB:</springform:label></td>
<td><springform:input path="dob"/>
<springform:errors path="dob" cssClass="error"></springform:errors>
</td>
</tr>
<tr>
<td><springform:label path="contactNumber">Contact Number:</springform:label></td>
<td><springform:input path="contactNumber"/>
<springform:errors path="contactNumber" cssClass="error"></springform:errors>
</td>
</tr>
<tr>
<td><springform:label path="alternateContactNumber">Alternate Contact Number:</springform:label></td>
<td><springform:input path="alternateContactNumber"/>
</td>
</tr>
<tr>
<td><springform:label path="emailId">Email-id:</springform:label></td>
<td><springform:input path="emailId"/>
<springform:errors path="emailId" cssClass="error"></springform:errors>
</td>
</tr>
<tr>
<td><springform:label path="addressLine1">Address Line1:</springform:label></td>
<td><springform:input path="addressLine1"/>
<springform:errors path="addressLine1" cssClass="error"></springform:errors>
</td>
</tr>
<tr>
<td><springform:label path="addressLine2">Address Line2:</springform:label></td>
<td><springform:input path="addressLine2"/>
<springform:errors path="addressLine2" cssClass="error"></springform:errors>
</td>
</tr>
<tr>
<td><springform:label path="city">City:</springform:label></td>
<td><springform:input path="city"/>
<springform:errors path="city" cssClass="error"></springform:errors>
</td>
</tr>
<tr>
<td><springform:label path="state">State:</springform:label></td>
<td><springform:input path="state"/>
<springform:errors path="state" cssClass="error"></springform:errors>
</td>
</tr>
<tr>
<td><springform:label path="zipCode">Zip Code:</springform:label></td>
<td><springform:input path="zipCode"/>
<springform:errors path="zipCode" cssClass="error"></springform:errors>
</td>
</tr>

<tr>
<td><input type="submit" value="Update Clerk"></td>


</tr>
</table>
</springform:form>
${status}
<form method="get" action="viewclerks.htm">
<input type="submit" value="view"/>
</form>

</body>
</html>