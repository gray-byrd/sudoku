<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="square" varStatus="status" items="${board}">
    <div class="col${status.index % 9 + 1}">
        <a>${square}</a>
    </div>
</c:forEach>
