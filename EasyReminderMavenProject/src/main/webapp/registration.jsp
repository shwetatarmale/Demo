<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--<html>
<body>
 <form action="RegisterServlet" method="post"> Name:
  <input type="text" name="name" />
  <br />
  <br /> Email Id:
  <input type="text" name="email" />
  <br />
  <br /> Password:
  <input type="password" name="password" />
  <br />
  <br /> Address:
  <input type="text" name="address" />
  <br />
  <br /> Mobile No:
  <input type="text" name="mobileno" />
  <br />
  <br />
  <br />
  <br />
  <input type="submit" value="register" formaction="RegisterServlet">
   </form>
</body>
</html>-->



<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Sign Up Signin Form Template Example</title>
  <link rel="stylesheet" href="./style.css">

</head>
<body>
<!-- partial:index.partial.html -->
<html lang="en">
<head>
  <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
 <link rel="stylesheet" href="css/registration.css">
 <link rel="stylesheet" href="css/navigation.css">
 
  </head>

<body>

	<nav class="navbar">
		<ul>
			<li><a href="login.jsp">Home</a></li>
			<li><a href="xmlparse.jsp">ParseXml</a></li>
			<li><a href="jsonparse.jsp">ParseJson</a></li>
			<li><a href="errordata.jsp">ErrorData</a></li>
			<li><a href="displayerrordata.jsp">DisplayErrorData </a></li>
			<li><a href="login.jsp">Logout</a></li>
			

		</ul>
	</nav>

<div id="form">
  <div class="container">
    <div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-md-8 col-md-offset-2">
      <div id="userform">
        <div class="tab-content">
          <div>
            <h2 class="text-uppercase text-center"> REGISTER HERE</h2>
            <form  action="RegisterServlet" method="post">
              <div class="row">
                <div class="col-xs-12 col-sm-6">
                  <div class="form-group">
                    <label>First Name<span class="req">*</span> </label>
                    <input type="text" class="form-control" id="first_name" name="name" required data-validation-required-message="Please enter your name." autocomplete="off">
                    <p class="help-block text-danger"></p>
                  </div>
                </div>
                <div class="col-xs-12 col-sm-6">
                  <div class="form-group">
                    <label> Last Name<span class="req">*</span> </label>
                    <input type="text" class="form-control" id="last_name" name="lastname"required data-validation-required-message="Please enter your name." autocomplete="off">
                    <p class="help-block text-danger"></p>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label> Your Email<span class="req">*</span> </label>
                <input type="email" class="form-control" id="email" name="email" required data-validation-required-message="Please enter your email address." autocomplete="off">
                <p class="help-block text-danger"></p>
              </div>
               <div class="form-group">
                <label> Password<span class="req">*</span> </label>
                <input type="password" class="form-control" id="" name="password" required data-validation-required-message="Please enter your password" autocomplete="off">
                <p class="help-block text-danger"></p>
              </div>
               <div class="form-group">
                <label> Address<span class="req">*</span> </label>
                <input type="tel" class="form-control" id="phone"  name="address" required data-validation-required-message="Please enter your phone number." autocomplete="off">
                <p class="help-block text-danger"></p>
              </div>
               
              <div class="form-group">
                <label> Your Phone<span class="req">*</span> </label>
                <input type="tel" class="form-control" id="phone"  name="mobileno" required data-validation-required-message="Please enter your phone number." autocomplete="off">
                <p class="help-block text-danger"></p>
              </div>
             
              <div class="mrgn-30-top">
                <button type="submit"  formaction="RegisterServlet" class="btn btn-larger btn-block"/>
                REGISTER
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- /.container --> 
</div>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
<!-- partial -->
  <script  src="./script.js"></script>

</body>
</html>