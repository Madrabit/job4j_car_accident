<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form action="<c:url value='/save?id=${accident.get().id}'/>" method='POST'>
    <table>
        <tr>
            <td>Название:</td>
            <td><input type='text' name='name' value="${accident.get().name}"></td>
        </tr>
        <tr>
            <td>Описание:</td>
            <td><input type='text' name='description' value="${accident.get().description}"></td>
        </tr>
        <tr>
            <td>Адрес:</td>
            <td><input type='text' name='address' value="${accident.get().address}"></td>
        </tr>
        <tr>
            <td>Тип:</td>
            <td>
                <select name="type.id">
                    <c:forEach var="type" items="${types}" >
                        <option value="${type.id}" ${type.id == accident.get().type.id ? 'selected' : ''}>${type.name}</option>
                    </c:forEach>
                </select>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
        </tr>
    </table>
</form>
</body>
</html>
