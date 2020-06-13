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
      height: 450px;
      width: 900px;
    }
    .carousel-item img {
      height: 450px;
      width: 900px;
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
            <a href="https://shtudy.org/news" class="list-group-item">Главные</a>
            <a href="https://shtudy.org/news1.jsp" class="list-group-item">Акции</a>
            <a href="https://shtudy.org/news2.jsp" class="list-group-item">Вакансии</a>
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
              <div class="carousel-item active">
                <img class="d-block img-fluid" src="https://cdn25.img.ria.ru/images/97229/14/972291409_0:131:2504:1540_600x0_80_0_0_fee6bea393bb5d0580852297dfdd8344.jpg.webp" alt="First slide">
                <div class="carousel-caption d-none d-md-block">
                  <p>Эксперт рассказал, как определить, прослушивается ли ваш смартфон</p>
                </div>
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid" src="https://cdn25.img.ria.ru/images/07e4/06/02/1572364759_0:0:2814:1583_600x0_80_0_0_f71e3ef79010e9ed38b85d9a1acfab98.jpg.webp" alt="Second slide">
                <div class="carousel-caption d-none d-md-block">
                  <p>Россию ждет новая модель потребления</p>
                </div>
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid" src="https://cdn25.img.ria.ru/images/93518/43/935184386_0:238:2000:1363_600x0_80_0_0_3d7558f1d82a5ed9934ae0a620ddf96b.jpg.webp" alt="Second slide">
                <div class="carousel-caption d-none d-md-block">
                  <p>В Швеции появилась "вакансия мечты" с зарплатой в две тысячи долларов</p>
                </div>
              </div>
            </div>
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

            <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
                <a href="https://ria.ru/20200604/1572435413.html"><img class="card-img-top" src="https://cdn25.img.ria.ru/images/07e4/04/0a/1569870332_0:0:3072:1728_600x0_80_0_0_7bdfd53e1e64c48e5662a88342052e7a.jpg.webp" alt=""></a>
                <div class="card-body">
                  <h4 class="card-title">
                    <a href="https://ria.ru/20200604/1572435413.html">Новость 1</a>
                  </h4>
                  <p class="card-text">Военные-добровольцы прошли обследование для испытания вакцины от COVID-19</p>
                </div>
                <div class="card-footer">
                  <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                </div>
              </div>
            </div>

            <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
                <a href="https://ria.ru/20200604/1572434815.html"><img class="card-img-top" src="https://cdn25.img.ria.ru/images/07e4/06/04/1572434798_0:4:3072:1732_600x0_80_0_0_62cf170db8be4f5f750ccd079fbe59de.jpg.webp" alt=""></a>
                <div class="card-body">
                  <h4 class="card-title">
                    <a href="https://ria.ru/20200604/1572434815.html">Новость 2</a>
                  </h4>
                  <p class="card-text">Полиция оттеснила протестующих в Вашингтоне от Белого дома</p>
                </div>
                <div class="card-footer">
                  <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                </div>
              </div>
            </div>

            <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
                <a href="https://ria.ru/20200604/1572434125.html"><img class="card-img-top" src="https://cdn25.img.ria.ru/images/150106/79/1501067991_0:77:3369:1972_600x0_80_0_0_ee5a7f4dd7a1f79883fd79265861e446.jpg.webp" alt=""></a>
                <div class="card-body">
                  <h4 class="card-title">
                    <a href="https://ria.ru/20200604/1572434125.html">Новость 3</a>
                  </h4>
                  <p class="card-text">Пивовары опасаются снижения качества пива в ЕАЭС из-за техрегламента</p>
                </div>
                <div class="card-footer">
                  <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                </div>
              </div>
            </div>

            <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
                <a href="https://ria.ru/20200603/1572427274.html"><img class="card-img-top" src="https://cdn25.img.ria.ru/images/156115/42/1561154277_0:255:2921:1898_600x0_80_0_0_51996abb56e286841dccce9ef868bd16.jpg.webp" alt=""></a>
                <div class="card-body">
                  <h4 class="card-title">
                    <a href="https://ria.ru/20200603/1572427274.html">Новость 4</a>
                  </h4>
                  <p class="card-text">Костин считает, что в России не будет банковского кризиса</p>
                </div>
                <div class="card-footer">
                  <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                </div>
              </div>
            </div>

            <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
                <a href="https://ria.ru/20200603/1572363516.html"><img class="card-img-top" src="https://cdn25.img.ria.ru/images/07e4/06/02/1572365052_0:342:2867:1955_600x0_80_0_0_4958477052708d6acffb7bec91f986f0.jpg.webp" alt=""></a>
                <div class="card-body">
                  <h4 class="card-title">
                    <a href="https://ria.ru/20200603/1572363516.html">Новость 5</a>
                  </h4>
                  <p class="card-text">Америке предлагают выбирать между расизмом и анархией</p>
                </div>
                <div class="card-footer">
                  <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                </div>
              </div>
            </div>

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