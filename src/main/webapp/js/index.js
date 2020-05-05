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
    first = Math.floor(Math.random() * 120);
    second = Math.floor(Math.random() * 120);
    document.getElementById('captcha').innerHTML = first + ' + ' + second + ' = ?';
    document.getElementById('captcha2').innerHTML = first + ' + ' + second + ' = ?';
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
