function inverser(){
	if (document.getElementById('pid1').style.display == 'block'){
		document.getElementById('pid1').style.display = 'none';
		document.getElementById('pid2').style.display = 'block';
		return;
	}
	if (document.getElementById('pid1').style.display == 'none'){
		document.getElementById('pid1').style.display = 'block';
		document.getElementById('pid2').style.display = 'none';
	}
}

var first, second;

function InitStart(){
    /*first = Math.floor(Math.random() * 120);
    second = Math.floor(Math.random() * 120);
    document.getElementById('captcha').innerHTML = first + ' + ' + second + ' = ?';
    document.getElementById('captcha2').innerHTML = first + ' + ' + second + ' = ?';*/
}

$(function() {
  $(".btn-submit").on("click", validate);
 
  // Validate email
  function validateCaptcha() {
    var valu = document.getElementById('captcha_text').innerValue;
    var valu2 = document.getElementById('captcha_text2').innerValue;
    return valu == first + second || valu2 == first + second;
  }
   
  // send form
  function sendForm() {
    document.getElementById('success-message1').innerHTML = "Form sending";
  }
 
  function validate() {
    if (validateCaptcha()) {
      sendForm();
    } else {
      document.getElementById('error-message1').text("captha is not valid");
    }
    return false;
  }
});

function ourajax(cur){
    var data = {};
    data = {"login":cur.text};
    //
    $.ajax
    ({
        type: "POST",//Метод передачи
        data: data,//Передаваемые данные в JSON - формате
        url: 'CheckLogin',//Название сервлета
        success:function(serverData)//Если запрос удачен
        {
            //$("#success-message1").css({"background-color":serverData.backgroundColor, "height": "50px", "color":"white"});
            $("#success-message1").html(serverData.serverInfo);
        },
        error: function(e)//Если запрос не удачен
        {
            //$("#auth-info").css({"background-color":"#CC6666", "height": "50px", "color":"white"});
            $("#error-message1").html("Ajax не удался!");
        }
    });
}
