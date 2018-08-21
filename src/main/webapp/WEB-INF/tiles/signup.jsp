<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form name="registerUser" method="POST" action="/registerUser" modelAttribute="user">
    <table>
        <tr>
            <td><form:label path="userName">User Name</form:label></td>
            <td><form:input path="userName"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td><form:label path="email">Email</form:label></td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td><form:label path="firstName">First Name</form:label></td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="lastName">Last Name</form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td><form:label path="dob">Date of Birth</form:label></td>
            <td><form:input path="dob"/></td>
        </tr>
        <tr>
            <td><form:label path="ssn">Social Security Number</form:label></td>
            <td><form:input path="ssn"/></td>
        </tr>
        <tr>
            <td><form:label path="phone">Phone Number</form:label></td>
            <td><form:input path="phone"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>