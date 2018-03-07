<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width = device-width, initial-scale = 1">

        <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="/resources/css/style.css" />

        <title>sudoku</title>
    </head>
    <body>
        <div class="container-fluid">

            <header class="header-panel">
                <nav class="navbar navbar-dark bg-dark">
                    <a class="navbar-brand" href="#">
                        <img src="" width="30" height="30" class="d-inline-block align-top" alt="">sudoku
                    </a>
                </nav>
            </header>

            <div class="row">
                <form action="board">
                    <input type="text" name="t1"><br>
                    <input type="text" name="t2"><br>
                    <input type="submit">
                </form>
            </div>

            <footer>
                <nav class="navbar navbar-dark bg-dark">
                    <p>This is the footer, do something with it.</p>
                </nav>
            </footer>

        </div>
        <script type="text/javascript" src="/resources/js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="/resources/js/app.js"></script>
    </body>
</html>