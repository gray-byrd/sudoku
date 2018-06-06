<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="board-container">
    <c:forEach var="row" varStatus="rowNum" items="${board}">
        <div class="btn-group">
            <c:forEach var="square" varStatus="colNum" items="${row}">
                <button class="board-btn row-${rowNum.index} col-${colNum.index}
                        ${square eq selected ? 'highlight' : ''}"
                        value="row=${rowNum.index}&col=${colNum.index}">
                        ${square}
                </button>
            </c:forEach>
        </div>
    </c:forEach>
</div>
<div id="ctrls-container" class="btn-group">
    <c:forEach var="ctrl" varStatus="ctrlNum" items="${ctrls}">
        <button class="ctrl-btn ctrl-btn-${ctrlNum.index}" value="&value=${ctrl}">
            ${ctrl}
        </button>
    </c:forEach>
</div>
