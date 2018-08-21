<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var = "logedIn" scope = "session" value = "true"/>
<a id="header-logo" href="/">#</a>
<div id="header-title-frame">
    <a id="header-title" href="/">sudoku</a>
</div>
<div id="header-link-frame">
    <c:choose>
        <c:when test="${logedIn}">
            <a id="header-signup-link" href="/signup">sign up</a>
            <span>or</span>
            <a id="header-signin-link" href="/signin">sign in</a>
        </c:when>
        <c:otherwise>
            <a id="header-signup-link" href="/signup">sign up</a>
            <span>or</span>
            <a id="header-signin-link" href="/signin">sign in</a>
        </c:otherwise>
    </c:choose>
</div>