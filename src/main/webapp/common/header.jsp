<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-success fixed-top">
  <div class="container">
    <a class="navbar-brand" href="#">Модуль "Личный кабинет"</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item active">
          <a class="nav-link" href="https://shtudy.org">На главную
            <span class="sr-only">(current)</span>
          </a>
        </li>
        <c:set var="usert1" value="${sessionScope.name}"/>
        <c:if test="${empty usert1}">
          <li class="nav-item">
            <a class="nav-link" href="https://shtudy.org/regauth">Войти</a>
          </li>
        </c:if>
        <c:if test="${!empty usert1}">
          <li class="nav-item">
            <a class="nav-link" href="https://shtudy.org/logout">${usert1}</a>
          </li>
        </c:if>
      </ul>
    </div>
  </div>
</nav>