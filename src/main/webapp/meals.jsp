<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ru">
<head>
    <title>Meals</title>
    <style>
        table {
            width: 50%; /* Ширина таблицы */
            background: white; /* Цвет фона таблицы */
            color: black; /* Цвет текста */
            border-spacing: 0px; /* Расстояние между ячейками */
        }

        td, th {
            background: white; /* Цвет фона ячеек */
            padding: 5px; /* Поля вокруг текста */
        }
    </style>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<ul>
    <table border="1">
        <tr>
            <td><p align="center">Date</p></td>
            <td><p align="center">Description</p></td>
            <td><p align="center">Calories</p></td>
            <td></td>
            <td></td>
        </tr>

        <c:forEach var="meal" items="${meals}">
            <tr
                    <c:if test="${meal.excess}">
                        style="color: red"
                    </c:if>
                    style="color: green"
            >
                <td><fmt:parseDate value="${ meal.dateTime }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime"
                                   type="both"/>
                    <fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${ parsedDateTime }"/></td>
                <td><c:out value="${meal.description}"/></td>
                <td><c:out value="${meal.calories}"/></td>
                <td>Update</td>
                <td>Delete</td>
            </tr>
        </c:forEach>
    </table>

</ul>
</body>
</html>
