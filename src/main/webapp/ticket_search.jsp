<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="web/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
  <link href="web/css/style.css" rel="stylesheet" type="text/css" media="all"/>
  <script type="text/javascript" src="web/jquery/jquery.min.js"></script>
  <script type="text/javascript" src="web/bootstrap/js/bootstrap.bundle.min.js"></script>
  <title>Поиск билета</title>
</head>
<body>
  <jsp:include page="common/header.jsp" />
  <div class="container main-container">
    <div class="row">
      <div class="col-lg-3">
        <h3 class="my-4">Меню</h3>
        <div class="list-group">
          <a href="cabinet" class="list-group-item">Личные данные</a>
          <a href="search" class="list-group-item">Поиск билета</a>
          <a href="tickets" class="list-group-item">Билеты</a>
          <a href="settings" class="list-group-item">Настройки</a>
        </div>
      </div>

      <div class="col-lg-9 main-part">
      <form action="search" method="GET">
      <span>Откуда: </span><input type="text" name="from"/><span> Куда: </span><input type="text" name="to"/> <input type="submit" value="Найти"/></br></br>
      </form>
      <table class="table">
        <thead>
          <tr>
            <th>Тикет</th>
            <th>Отправление</th>
            <th>Прибытие</th>
            <th>Время отправления</th>
            <th>Время прибытия</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="tRow" items="${data}">
            <tr class="
              <c:if test='${tRow.status == 1}'>
                table-primary
              </c:if>
              <c:if test='${tRow.status == 2}'>
                table-success
              </c:if>
              <c:if test='${tRow.status == 3}'>
                table-danger
              </c:if>
              <c:if test='${tRow.status == 4}'>
                table-info
              </c:if>
              <c:if test='${tRow.status == 5}'>
                table-warning
              </c:if>
            ">
              <td>${tRow.tickNum}</td>
              <td>${tRow.from}</td>
              <td>${tRow.to}</td>
              <td>${tRow.fromTime}</td>
              <td>${tRow.toTime}</td>
              <td><a href="search?buy=${tRow.id}">Купить</a></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>

      </div>
    </div>
  </div>
  <jsp:include page="common/footer.jsp" />
</body>
</html>