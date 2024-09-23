<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Complaints</title>
    <link rel="icon" type="image/x-icon" href="./images/white.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body style="background-color: #013329;">
    <div class="container">
        <div class="row">
            <div class="col-md-5">
                <br><br>
                <button class="btn btn-primary" type="button" style="background-color:#013329;color: white;">
                    <a href="adminmenu" class="link-offset-2 link-underline link-underline-opacity-0 link-light">
                        <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512">
                            <style>
                                svg { fill: #ffffff }
                            </style>
                            <path d="M0 96C0 78.3 14.3 64 32 64H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32C14.3 128 0 113.7 0 96zM0 256c0-17.7 14.3-32 32-32H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32c-17.7 0-32-14.3-32-32zM448 416c0 17.7-14.3 32-32 32H32c-17.7 0-32-14.3-32-32s14.3-32 32-32H416c17.7 0 32 14.3 32 32z" />
                        </svg>
                    </a>
                </button>
            </div>
            <div class="col-md-6">
                <br><br>
                <img src="./images/whitelogo3.png">
            </div>
        </div>
        <br><br>
        
        <table class="table table-striped">
		
		<thead>
    		<tr>
      			<th scope="col">USER-ID</th>
      			<th scope="col">GROUP</th>
      			<th scope="col">ISSUE</th>
      			<th scope="col">IMAGE</th>
      			<th scope="col">STATUS</th>
    		</tr>
  		</thead>
  		<tbody>
  			<c:forEach items="${clist}" var="c">
    		<tr>
      			<th scope="row">${c.userid}</th>
      			<td><c:out value="${c.grp}" /></td>
      			<td><c:out value="${c.issue}" /></td>
      			<td><img src='displayimage?id=${c.id}' width="20%" height="20%"></td>
      			<td><c:out value="${c.status}" /></td>
    		</tr>
    		</c:forEach>
    		
  </tbody>
		
		</table>
        
    </div>
    
</body>
</html>