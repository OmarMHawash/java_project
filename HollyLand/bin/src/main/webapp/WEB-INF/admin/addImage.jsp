<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
    <link rel="stylesheet" href="/css/AdminLoginPageStyle.css">
	<title>HollyLand - Admin</title>
</head>
<body>
	<div class="container h-100">
        <div class="ref1">
            <a href="#" class="link-danger">Back</a>
        </div>
        
		<div class="d-flex justify-content-center h-100">
			<div class="user_card">
				<div class="d-flex justify-content-center">
					<div class="brand_logo_container">
						<img src="/img/logo.png" height="130" width="150" alt="logo">
					</div>
				</div>
				<div class="d-flex justify-content-center form_container">
					<form action="/login" method="POST" modelAttribute="admin">
                        <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                <span class="input-group-text" id="basic-addon3">Image URL</span>
                                </div>
                                <input type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3">
                          </div>
						
						<div class="d-flex justify-content-center mt-3 login_container">
				 	        <input type="submit" class="btn login_btn" value="Add">
				        </div>
					</form>
				</div>
			</div>
		</div>
        
        </div>
        
</body>
</html>