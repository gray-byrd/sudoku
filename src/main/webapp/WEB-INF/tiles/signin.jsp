<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form name="login" method="POST" action="/login" modelAttribute="user">
    <table>
        <tr>
            <td><form:label path="email">Email</form:label></td>
            <td><form:input class="input-email" path="email"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:input class="input-password" path="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>