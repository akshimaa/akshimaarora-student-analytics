<%-- 
    Document   : login
    Created on : Nov 16, 2015, 4:24:08 AM
    Author     : Akshima, madan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>CMU Student Analytics</title>
<meta charset="UTF-8">
    
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" media="screen">
 
    <link rel="stylesheet" type="text/css" href="css/bootstrap-social.css" media="screen">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.css" media="screen">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="js/jquery-2.1.4.js" type="text/js"></script>
    <script src="js/bootstrap.js" type="text/js"></script>
    
</head>
<body>
<script>
  // This is called with the results from from FB.getLoginStatus().
  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
      // Logged into your app and Facebook.
     

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

  // Now that we've initialized the JavaScript SDK, we call 
  // FB.getLoginStatus().  This function gets the state of the
  // person visiting this page and can return one of three states to
  // the callback you provide.  They can be:
  //
  // 1. Logged into your app ('connected')
  // 2. Logged into Facebook, but not your app ('not_authorized')
  // 3. Not logged into Facebook and can't tell if they are logged into
  //    your app or not.
  //
  // These three cases are handled in the callback function.

  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });

  };

  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.


</script>

<!--
  Below we include the Login Button social plugin. This button uses
  the JavaScript SDK to present a graphical Login button that triggers
  the FB.login() function when clicked.
-->

<img src="images/WebAppLogin.png" height="30%" width="30%" align="middle" style="margin-left: 5%;margin-top: 5%;min-height:78px; "/>
<div  class="container" style="margin: auto; display: block;margin-top: 5%;width: 22%;min-width: 300px">
    <a id="fb_login" class="btn btn-block btn-social btn-lg btn-facebook" style="text-align: center;" >
    <span class="fa fa-facebook"></span>Sign in with Facebook
</a>

</div>

<form id="index" action="dashboard" name="login" method="POST" style="display:none;">
  <input type="hidden" name="fbToken" id="fbToken" />
<input type="hidden" name="fbUser" id="fbUser" />
</form>

</body>
<script>
    
  $('#fb_login').click(function(){
      console.log("click");
    FB.login(function(response) {

        if (response.authResponse) {
            console.log('Welcome!  Fetching your information.... ');
            console.log(response); // dump complete info
            access_token = response.authResponse.accessToken; //get access token
            user_id = response.authResponse.userID; //get FB UID
            $('#fbToken').attr('value',access_token);
            $('#fbUser').attr('value',user_id);
            console.log("calling submit action");
            $('#index').submit();
            FB.api('/me', function(response) {
                user_email = response.email; //get user email
          // you can store this data into your database    
          console.log('Hello, '+response.name+" !");
          
            });
            

        } else {
            //user hit cancel button
            console.log('User cancelled login or did not fully authorize.');

        }
    }, {
        scope: 'public_profile,email'
    });});

</script>
</html>
