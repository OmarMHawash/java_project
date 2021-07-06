<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
<link rel="stylesheet" href="/css/AdminDashboardPageStyle.css">
<title>Admin</title>
</head>
<body>
	<header>
		<nav
			class="navbar navbar-dark bg-light justify-content-between header_nav">
			<div class="logo_div">
				<img id="logo" src="/img/logo.png" height="100" width="120"
					alt="holyland-logo">
			</div>
			<div class="header-right">
				<div class="input-group rounded" id="search-div">
					<input type="search" class="form-control rounded"
						placeholder="Search" aria-label="Search"
						aria-describedby="search-addon" /> <span
						class="input-group-text border-0" id="search-addon"> <i
						class="fas fa-search"></i>
					</span>
				</div>
				<div id="logout-div">
					<form action="/logout" method="POST">
						<input type="submit" class="btn btn-secondary btn-sm"
							value="Logout">
					</form>
				</div>
			</div>
		</nav>
	</header>
	<div class="con">
		<div class="inner-con">
			<div>
				<div>
					<p><a href="/createVillage">Create new village</a></p>
				</div>
				<c:forEach items="${cities}" var="city">
					<div>
						<button type="button" id="${city.id}" class="btn btn-secondary btn-lg"><c:out value="${city.name}"/></button>
						<div class="${city.id}">
							<c:forEach items="villages" var="village">
								<button type="button" id="${village.id}" class="btn btn-secondary btn-lg"><c:out value="${village.name}"/></button>
							</c:forEach>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>