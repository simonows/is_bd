<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="web/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
  <link href="web/css/style.css" rel="stylesheet" type="text/css" media="all"/>
  <script type="text/javascript" src="web/jquery/jquery.min.js"></script>
  <script type="text/javascript" src="web/bootstrap/js/bootstrap.bundle.min.js"></script>
  <title>Модуль "Новости"</title>
  <style>
    .carousel-item{
      height: 350px;
      width: 900px;
    }
    .carousel-item img {
        background-size:cover;
    }
  </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Модуль "Новости"</a>
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
            <c:if test="${sessionScope.user != null}">
              <li class="nav-item">
                <a class="nav-link" href="logout">Выйти</a>
              </li>
            </c:if>
            <c:if test="${sessionScope.user == null}">
              <li class="nav-item">
                <a class="nav-link" href="regauth">Войти</a>
              </li>
            </c:if>
          </ul>
        </div>
      </div>
</nav>
<div class="container">
  <div class="row">

        <div class="col-lg-3">

          <h1 class="my-4">Категория</h1>
          <div class="list-group">
            <a href="#" class="list-group-item">Главные</a>
            <a href="#" class="list-group-item">Акции</a>
            <a href="#" class="list-group-item">Вакансии</a>
          </div>

        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

          <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
              <c:forEach items="${news}" var="newss">
              <div class="carousel-item active">
                <img class="d-block img-fluid" src="<c:out value="${newss.newslink}" />" alt="First slide">
                <div class="carousel-caption d-none d-md-block">
                  <p><c:out value="${newss.name}" /></p>
                </div>
              </div>
              </c:forEach>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Предыдущая</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Следующая</span>
            </a>
          </div>

          <div class="row">
            <c:forEach items="${news}" var="newss">
            <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
                <a href="<c:out value="${newss.newslink}" />"><img class="card-img-top" src="<c:out value="${newss.imgslink}" />" alt=""></a>
                <div class="card-body">
                  <h4 class="card-title">
                    <a href="#">Item One</a>
                  </h4>
                  <p class="card-text"><c:out value="${newss.name}" /></p>
                </div>
                <div class="card-footer">
                  <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                </div>
              </div>
            </div>
            </c:forEach>

          </div>
          <!-- /.row -->

        </div>
        <!-- /.col-lg-9 -->

      </div>
    </div>
  <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Александр Пешков 2020</p>
      </div>
      <!-- /.container -->
  </footer>
      <!-- /.row -->
</body>
</html>