<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="icon" type="image/x-icon" href="./images/white.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>
    <div style="background-color: #013329;">
        <div class="row">
            <div class="col-4">
                <img src="./images/register3.png" style="width: auto;height: auto;">
            </div>
            <div class="col-8">
                <div class="container">
                    <br>
                    <button type="button" class="btn-close" style="background-color: white;" aria-label="Close" onclick="window.location.href = 'index.jsp';"></button>
                    <br>
                    <img src="./images/white.png" style="width: 100px;height: 100px;">
                    <br><br>
                    <h1 style="color: white;">Create account</h1>
                    <form class="row g-3" style="color: white;">
                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Email</label>
                            <input type="email" class="form-control" id="inputEmail4">
                        </div>
                        <div class="col-md-4">
                            <label for="inputPassword4" class="form-label">Passcode</label>
                            <input type="password" class="form-control" id="inputPassword4">
                        </div>
                        <div class="col-md-6">
                            <label class="form-label">Full Name</label>
                            <input type="text" class="form-control">
                        </div>
                        <div class="col-md-4">
                            <label class="form-label">Username</label>
                            <input type="text" class="form-control">
                        </div>
                        <br>
                        <div class="col-md-4">
                            <label class="form-label">Contact</label>
                            <input type="text" class="form-control">
                        </div>
                        <div class="col-md-6">
                            <label for="inputZip" class="form-label">Password</label>
                            <input type="password" class="form-control" id="inputZip">
                        </div>
                        <div class="col-12">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" id="gridCheck">
                                <label class="form-check-label" for="gridCheck">I agree to all terms and conditions</label>
                            </div>
                        </div>
                        <div class="col-md-5">
                            <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-primary" style="background-color: #98B545;">Sign up</button>
                            </div>
                        </div>
                        <div class="col-md-5">
                                <button type="button" class="btn btn-primary" onclick="window.location.href = 'login.jsp';">Go to Login</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>

</html>