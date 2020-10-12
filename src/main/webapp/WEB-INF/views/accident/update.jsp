<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <title>Редактировать</title>
</head>
<body>
<div class="container pt-3 vh-100 d-flex align-items-center justify-content-center">
    <div class="row  card ">
        <div class="card-header"><h2>Редактировать инцидент</h2></div>
        <form class="p-3" action="<c:url value='/save?id=${accident.id}'/>" method='POST'>
            <table>
                <tr>
                    <td>Название:</td>
                    <td><input type='text' name='name' value="${accident.name}"></td>
                </tr>
                <tr>
                    <td>Описание:</td>
                    <td><input type='text' name='description' value="${accident.description}"></td>
                </tr>
                <tr>
                    <td>Адрес:</td>
                    <td><input type='text' name='address' value="${accident.address}"></td>
                </tr>
                <tr>
                    <td>Тип:</td>
                    <td>
                        <select name="type.id">
                            <c:forEach var="type" items="${types}">
                                <option value="${type.id}" ${type.id== accident.type.id ?
                                'selected' : ''}>${type.name}</option>
                            </c:forEach>
                        </select>
                </tr>
            </table>
            <input class="mt-3 btn btn-primary" name="submit" type="submit" value="Сохранить"/>
        </form>
    </div>
</div>
</body>
</html>
