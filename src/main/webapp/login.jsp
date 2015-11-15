<%-- 
<<<<<<< HEAD
    Document   : login
    Created on : 14/11/2015, 12:30:21 AM
    Author     : Akshima
--%>

<!DOCTYPE html>
<html>
<head>
<title>Facebook Login JavaScript Example</title>
<meta charset="UTF-8">
</head>
<body>
<script>

function statusChangeCallback(response) {
    
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
      // Logged into your app and Facebook.
      testAPI();
    } else if (response.status === 'not_authorized') {
      // The person is logged into Facebook, but not your app.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into this app.';
    } else {
      // The person is not logged into Facebook, so we're not sure if
      // they are logged into this app or not.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into Facebook.';
    }
  }
  
  
   // This function is called when someone finishes with the Login
  // Button.  See the onlogin handler attached to it in the sample
  // code below.
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }

  window.fbAsyncInit = function() {
  FB.init({
    appId      : '166777283673977',
    cookie     : true,  // enable cookies to allow the server to access 
                        // the session
    xfbml      : true,  // parse social plugins on this page
    version    : 'v2.5' // use version 2.2
  });
  
  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });

  };


  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
    
  }(document, 'script', 'facebook-jssdk'));

function testAPI() {
   
    redirect(this);
  }

function redirect(elem){
    //alert("redirecting");
    window.location="index.jsp";
}
 
</script>
<fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
</fb:login-button>

<div id="status">
</div>

</body>
</html>
=======
    Document   : index
    Created on : Nov 3, 2015, 5:23:33 PM
    Author     : madan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form action="upload" method="post" enctype="multipart/form-data">
                <input type="file" name="file" accept=".csv" />
                <input type="submit" value="upload" />
            </form> 
        </div>
    </body>
</html>
>>>>>>> origin/master
