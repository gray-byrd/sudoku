<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="board-container" class="container">
    <form id="board-form" action="win" class="">
        <c:forEach var="row" varStatus="rowStatus" items="${board}">
            <div class="col-12">
                <div class="btn-group board-btn-row">
                    <c:forEach var="square" varStatus="colStatus" items="${row}">
                        <button type="button" class="board-btn btn btn-outline-dark"
                                id="board-btn-${rowStatus.index}${colStatus.index}">
                                ${square}
                        </button>
                    </c:forEach>
                </div>
            </div>
        </c:forEach>
    </form>
</div>