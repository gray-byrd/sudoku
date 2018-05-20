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
<div id="controls-container" class="container">
    <form id="controls-form" action="win" class="btn-group">
        <button type="submit" class="ctrl-btn btn btn-outline-dark" id="ctrl-btn-1">1</button>
        <button type="submit" class="ctrl-btn btn btn-outline-dark" id="ctrl-btn-2">2</button>
        <button type="submit" class="ctrl-btn btn btn-outline-dark" id="ctrl-btn-3">3</button>
        <button type="submit" class="ctrl-btn btn btn-outline-dark" id="ctrl-btn-4">4</button>
        <button type="submit" class="ctrl-btn btn btn-outline-dark" id="ctrl-btn-5">5</button>
        <button type="submit" class="ctrl-btn btn btn-outline-dark" id="ctrl-btn-6">6</button>
        <button type="submit" class="ctrl-btn btn btn-outline-dark" id="ctrl-btn-7">7</button>
        <button type="submit" class="ctrl-btn btn btn-outline-dark" id="ctrl-btn-8">8</button>
        <button type="submit" class="ctrl-btn btn btn-outline-dark" id="ctrl-btn-9">9</button>
    </form>
</div>