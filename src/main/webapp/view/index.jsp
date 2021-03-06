<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta lang="ru"/>
  <title>Авиакасса</title>
  <link href="css/base.css" rel="stylesheet" type="text/css"/>
  <link href="css/news.css" rel="stylesheet" type="text/css"/>
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/list.js"></script>
</head>
<body>
  <header>
    <div id="logo" class="noselect">
      <span class="second-ch">S</span>8
    </div>
    <div class="signup">
      <c:set var="usert1" value="${sessionScope.name}"/>
      <c:if test="${empty usert1}">
        <a href="regauth">Войти/Зарегистрироваться</a>
      </c:if>
      <c:if test="${!empty usert1}">
        <a href="cabinet">${usert1}</a>
      </c:if>
    </div>
  </header>
  <div class="body-container">
    <nav class="menu">
      <div class="menu-elem noselect">Прилет</div>
      <div class="menu-elem noselect">Вылет</div>
      <div class="menu-elem noselect"><a href="https://shtudy.org/news">Новости</a></div>
      <div class="menu-elem noselect">Акции</div>
      <div class="menu-elem noselect">Правила</div>
      <div class="menu-elem noselect">Отмена рейсов</div>
    </nav>
    <div class="body">
        <table border="0" width="100%" bgcolor="#E8E8E8" cellspacing="0" cellpadding="0">
            <tr>
                <td width="100%">
                    <script src="js/tip_of_the_day.js"></script>
                </td>
            </tr>
        </table>
      <ul id="listticker">
        <li>
          <img src="img/1.png" />
          <a href="" class="news-title">Новость 1</a>
          <span class="news-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore</span>
        </li>
        <li>
          <img src="img/2.png" />
          <a href="" class="news-title">Новость 2</a>
          <span class="news-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore</span>
        </li>
        <li>
          <img src="img/3.png" />
          <a href="" class="news-title">Новость 3</a>
          <span class="news-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore</span>
        </li>
        <li>
          <img src="img/4.png" />
          <a href="" class="news-title">Новость 4</a>
          <span class="news-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore</span>
        </li>
        <li>
          <img src="img/2.png" />
          <a href="" class="news-title">Новость 5</a>
          <span class="news-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore</span>
        </li>
        <li>
          <img src="img/2.png" />
          <a href="" class="news-title">Новость 6</a>
          <span class="news-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore</span>
        </li>
      </ul>
      <ul id="listticker" style="float:left;">
        <li>
          <img src="img/1.png" />
          <a href="" class="news-title">Новость 1</a>
          <span class="news-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore</span>
        </li>
        <li>
          <img src="img/2.png" />
          <a href="" class="news-title">Новость 2</a>
          <span class="news-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore</span>
        </li>
        <li>
          <img src="img/3.png" />
          <a href="" class="news-title">Новость 3</a>
          <span class="news-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore</span>
        </li>
        <li>
          <img src="img/4.png" />
          <a href="" class="news-title">Новость 4</a>
          <span class="news-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore</span>
        </li>
        <li>
          <img src="img/2.png" />
          <a href="" class="news-title">Новость 5</a>
          <span class="news-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore</span>
        </li>
        <li>
          <img src="img/2.png" />
          <a href="" class="news-title">Новость 6</a>
          <span class="news-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore</span>
        </li>
      </ul>
    </div>
  </div>
  <footer>
    <div class="footer-column">
      <div class="footer-elem">Помощь</div>
      <div class="footer-elem">Предложения</div>
      <div class="footer-elem">Вакансии</div>
      <div class="footer-elem">Новости</div>
    </div>
    <div class="footer-column">
      <div class="footer-elem">Помощь</div>
      <div class="footer-elem">Помощь</div>
      <div class="footer-elem">Помощь</div>
      <div class="footer-elem">Помощь</div>
    </div>
    <div class="footer-column">
      <div class="footer-elem">Помощь</div>
      <div class="footer-elem">Помощь</div>
      <div class="footer-elem">Помощь</div>
      <div class="footer-elem">Помощь</div>
    </div>
  </footer>
</body>
</html>
