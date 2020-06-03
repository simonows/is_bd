<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ru" >
<head>
  <meta charset="UTF-8">
  <title>Форма авторизации</title>
  <link rel="stylesheet" href="css/reg_and_auth.css">
  <link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/index.js"></script>
</head>
<body onLoad="InitStart()">
  <div class="form-shell">
    <table style=" table-layout:auto;">
      <tr style="">
          <td style="vertical-align: bottom;">
              <div class="error-message">
                  <p class='mesage-error' id="error-message1">${errorlog}</p>
                  <p class='success-message' id="success-message1">${successlog}</p>
              </div>
          </td>
      </tr>
      <tr style="height:364px;">
        <td>
          <div class="form">
            <form class="register-form" style="display: none;" action="UserRegistration" method="post" name="form_register">
              <input type="text" onBlur="ourajax(this);" id="place123" name="name" placeholder="логин" required/>
              <input type="password" name="password" placeholder="пароль" required/>
              <input type="text" name="email" placeholder="email" pattern="^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$" required/>
              <div id="captcha">${captcha}</div>
              <input type="text" id="captcha_text" name="captcha_text" placeholder="проверочный код" required/>
              <input class="nonselect button btn-submit" type="submit" name="btn_submit_register" value="Зарегистрироваться"/>
              <!--<button class="nonselect">Зарегистрироваться</button>!-->
            </form>
            <form class="login-form" action="UserLogin" method="post" name="form_auth" required>
              <input type="text" name="name" placeholder="логин" required/>
              <input type="password" name="password" placeholder="пароль" required/>
              <div class="checkboxelem nonselect"><div class="centerer"><input id="check-foreign" type="checkbox"/><label for="check-foreign">чужой компьютер</label></div></div>
              <div id="captcha2">${captcha}</div>
              <input type="text" id="captcha_text" name="captcha_text" placeholder="проверочный код" required/>
              <input class="nonselect button btn-submit" type="submit" id="btn_submit_auth" name="btn_submit_auth" value="Войти"/>
              <!--<button class="nonselect">Войти</button>!-->
            </form>
          </div>
        </td>
      </tr>
      <tr style="">
        <td style="vertical-align: top;">
          <div class="login-info" id="pid1" style="display:block;"><p class="message">Не зарегистрированны? <a href="#" onclick="inverser();">Создайте аккаунт</a></p></div>
          <div class="login-info" id="pid2" style="display:none;"><p class="message">Уже зарегистрированны? <a href="#" onclick="inverser();">Войдите</a></p></div>
        </td>
      </tr>
    </table>
    <script>
      $('.message a').click(function(){
        $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
      });
    </script>
  </div>
  <div id="signature" class="nonselect"><a href="/"><div id="logo"><div class="sheath2" style="display: inline-block; font-size: 0.85em; font-style: italic;">S</div>8</div></a></div>
  <div class="footer">
    <a href="#">cправка</a>
    <a href="#">помощь</a>
    <a href="#">предложения</a>
    <a href="#">контакты</a>
  </div>
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
</body>
</html>
