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
    <link rel="stylesheet" href="/css/editVillage.css">
	<title>HollyLand - Admin</title>
</head>
<body>
	<div class="container h-100">
        <div class="ref1">
            <a href="/add_village_image/${village.id}" class="link-danger">Add images</a>
        </div>
        <div class="ref2">
            <a href="/village_reports/${village.id}" class="link-danger">Show reports</a>
        </div>
        
		<div class="d-flex justify-content-center h-100">
			<div class="user_card">
				<div class="d-flex justify-content-center">
					<div class="brand_logo_container">
						<img src="/img/logo.png" height="130" width="150" alt="logo">
					</div>
				</div>
				<div class="d-flex justify-content-center form_container">
					<form action="/edit_vill/${village.id}" method="POST">
                        <div class="form-group">
                            <input type="text" name="name" class="form-control" id="exampleFormControlInput1" value="${village.name}">
                        </div>
						<div class="form-group">
                        
                            <input type="int" name="space" class="form-control" id="exampleFormControlInput1" value="${village.space}">
                        </div>
                        <div class="form-group">
                        
                            <input type="int" name="population" class="form-control" id="exampleFormControlInput1" value="${village.population}">
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1"></label>
                            <textarea name="description" class="form-control" id="exampleFormControlTextarea1" rows="3">${ village.description}</textarea>
                        </div>
						<div class="d-flex justify-content-center mt-3 login_container">
				 	        <input type="submit" class="btn login_btn" value="Update">
				        </div>
                        <div class="d-flex justify-content-center mt-3 login_container">
                            <a href="/village_delete/${village.id}" class="btn login_btn">Delete</a>
                       </div>
					</form>         
				</div>
			</div>
		</div>
	    
	</div>
</body>
</html>