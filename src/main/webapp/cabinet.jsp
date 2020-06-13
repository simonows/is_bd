<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="web/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
  <link href="web/css/style.css" rel="stylesheet" type="text/css" media="all"/>
  <script type="text/javascript" src="web/jquery/jquery.min.js"></script>
  <script type="text/javascript" src="web/bootstrap/js/bootstrap.bundle.min.js"></script>
  <title>Личный данные</title>
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
        <img src="img/user.jpg" style="height:150px; width:150px;"/>
        <p>Имя: ${namet}</p>
        <p>Фамилия: ${sernamet}</p>
        <p>Отчество: ${patrt}</p>
        <p>Дата рождения: ${birtht}</p>
        <p>Дата регистрации: ${reget}</p>
      </div>
    </div>
  </div>
  <jsp:include page="common/footer.jsp" />
</body>
</html>