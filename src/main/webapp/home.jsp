<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="icon" type="image/x-icon" href="./images/white.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
statistics-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            margin-top: 50px;
            animation: fallIn 1.5s ease-in-out;
        }
        @keyframes fallIn {
            0% {
                transform: translateY(-200px);
            }
            100% {
                transform: translateY(0);
            }
        }
        .statistics-box:hover {
            transform: scale(1.1); /* Zoom out the card */
            background-color: #F7DC6F; /* Change the background color */
        }
        .statistics-box p {
            font-size: 48px;
            margin: 0;
            color: #008000; /* Green color for the number values */
        }
  
 

        .statistics-box {
            flex: 1;
            max-width: 300px;
            background-color: #DAF7A6;
            padding: 20px;
            margin: 10px;
            box-shadow: 0 5px 10px rgba(163, 157, 157, 0.2);
            text-align: center;
            color: #0a0808;
            border-radius: 10px;
        }

        .statistics-box h2 {
            font-size: 36px;
            margin-bottom: 20px;
        }

        .statistics-box p {
            font-size: 48px;
            margin: 0;
        }

</style>
</head>
<body style="background-color: #ebe5dc;">
    <div>
        <div class="container">
        <div class="row">
        <div class="col-md-4">
        <br><br>
        <button class="btn btn-primary" type="button" style="background-color:#013329;color: white;"><a href="menu" class="link-offset-2 link-underline link-underline-opacity-0 link-light"> <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><style>svg{fill:#ffffff}</style><path d="M0 96C0 78.3 14.3 64 32 64H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32C14.3 128 0 113.7 0 96zM0 256c0-17.7 14.3-32 32-32H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32c-17.7 0-32-14.3-32-32zM448 416c0 17.7-14.3 32-32 32H32c-17.7 0-32-14.3-32-32s14.3-32 32-32H416c17.7 0 32 14.3 32 32z"/></svg></a></button>
        </div>
        <div class="col-md-7">
        <img src="./images/blacklogo.png" >
        </div>
        <div class="col-md-1">
        <br><br>
        <button class="btn btn-primary" type="submit" style="background-color:#013329; color:black"><a href="userlogout" class="link-offset-2 link-underline link-underline-opacity-0 link-light">Logout</a></button>
        </div>
        </div>
        <br>
        <h3 style="text-align: right;">"Hello, ${name}"</h3>
        <br>
		<div class="statistics-box">
        <h3 style="color:green">Total Complaints</h3>
        <p id="anotherStatCount" style="color:red">${ccount}</p>
    	</div> 
        </div>
    </div>
</body>
</html>