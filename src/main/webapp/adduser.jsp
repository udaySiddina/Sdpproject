<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add User</title>
    <link rel="icon" type="image/x-icon" href="./images/white.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body style="background-color: #013329;">
    <div class="row">
        <div class="col-4">
            <img src="./images/register3.png" style="width: auto;height: auto;">
        </div>
        <div class="col-7">
            <div class="container">
                <br>
                <a href="adminhome" class="link-offset-2 link-underline link-underline-opacity-0 link-light"><button type="submit" class="btn-close" aria-label="Close"></button></a>
    			<br>
                <img src="./images/white.png" style="width: 100px;height: 100px;">
                <br><br>
                <h1 style="color: white;">Add User</h1>
                <form class="row g-3" style="color: white;" method="post" action="userreg">
                    <div class="col-md-6">
                        <label class="form-label">First Name</label>
                        <input type="text" name="fname" class="form-control">
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Last name</label>
                        <input type="text" name="lname" class="form-control">
                    </div>
                    <div class="col-md-6">
                        <br>
                        <label class="form-label">Gender&nbsp&nbsp&nbsp&nbsp</label>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" value="male" required="required">
                            <label class="form-check-label" >Male</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" value="female" required="required">
                            <label class="form-check-label" >Female</label>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <label for="inputdate" class="form-label">
                            Date Of Birth
                        </label>
                        <input type="date" class="form-control" name="dob" />
                    </div>
                    <div class="col-md-4">
                        <label class="form-label">Email</label>
                        <input type="email" class="form-control" name="email">
                    </div>
                    <div class="col-md-4">
                        <label for="inputState" class="form-label">Password</label>
                        <input type="password" class="form-control" name="password">
                    </div>
                    <div class="col-md-4">
                        <label for="inputGender" class="form-label">User type</label>
                        <select class="form-select form-select mb-3" aria-label="Large select example" name="usertype">
                            <option selected>Select User</option>
                            <option value="faculty">Faculty</option>
                            <option value="student">Student</option>
                            <option value="handler">Handler</option>
                        </select>
                    </div>
                    <div class="col-md-6">
                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-primary" style="background-color: #98B545;" value="Register">Add User</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>

</html>