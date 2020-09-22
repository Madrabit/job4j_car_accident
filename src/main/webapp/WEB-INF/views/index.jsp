<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
<head>
    <title>Accident</title>
</head>
<body>
<div class="container pt-3">
    <div class="row">
        <div>
            Login as : <c:out value="${user.username}"/>
        </div>
        <div class="card" style="width: 100%">
            <div class="card-header">
                Аварии
                <a href="<c:url value='/create'/>">Добавить инцидент</a>
            </div>
            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Имя</th>
                        <th scope="col">Описание</th>
                        <th scope="col">Адресс</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${accidents}" var="accident">
                        <tr>
                            <td>
                                <c:out value="${accident.id}"/>
                            </td>
                            <td>
                                <a href="<c:url value='/update?id=${accident.id}'/>">
                                    <i class="fa fa-edit mr-3"></i>
                                </a>
                                <c:out value="${accident.name}"/>
                            </td>
                            <td>
                                <c:out value="${accident.description}"/>
                            </td>
                            <td>
                                <c:out value="${accident.address}"/>
                            </td>
                            <td>
                                <c:out value="${accident.rules}"/>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
