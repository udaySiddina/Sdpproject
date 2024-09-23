<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="icon" type="image/x-icon" href="./images/white.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>
    <div style="background-color: #013329;">
        <div class="row">
            <div class="col-8">
                <img src="./images/login.png" style="width: 900px;height: 690px;;">
            </div>
            <div class="col-4">
                <br>
                <a href="/" class="link-offset-2 link-underline link-underline-opacity-0 link-light"><button type="submit" class="btn-close" aria-label="Close"></button></a>
    			<div class="container">
                <img src="./images/white.png" style="width: 100px; height: 100px;">
                <br>
                <span class="blink" >
				<h3 align="center" style="color: red">${message}</h3>
				</span>
				<br>
                <h1 style="color: white;">Handler Login</h1><br>
                    <form method="post" action="checkhandlerlogin">
                        <div class="container">
                        <label class="form-label" style="color: white;"> Email Address</label>
                        <input type="email" name=email class="form-control" required="required">
                        </div>
                        <br><br>
                        <div class="container">
                        <label class="form-label" style="color: white;"> Password</label>
                        <input type="password" name="password" class="form-control" required="required">
                        </div>
                        <br>
                        <div class="container" style="color:white;">
                        Not a Handler? <a href="userlogin" >Click here</a>
                        </div>
                        <br>
                        <div class="d-grid gap-2 mx-3">
                        <button class="btn btn-primary" type="submit" value="Login" style="background-color:#98B545;">Login</button>
                        </div>
                    </form>
                </div>    
            </div>
        </div>
    </div>
</body>

</html>