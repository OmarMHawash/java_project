<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/charts.css/dist/charts.min.css" />
<link rel="stylesheet" href="/css/village.css">

<title>Village</title>
</head>
<body>
	<header>
		<div></div>
		<div>
			<a href="#"><img src="/img/logo.png" alt="logo" /></a>
		</div>
		<div class="go-back">
			<a href="">Go Back</a>
		</div>
	</header>
	<main>
		<h3 class="cName" style="font-size: 26px">${village.city.name }</h3>
		<h1 class="vName" style="font-size: 40px">${village.name}</h1>
		<div class="images">
			<c:forEach items="${village.images}" var="image">
				<img src="${image.url}" alt="image of ${village.name}">
			</c:forEach>
		</div>
		<section>
			<div class="left" style="width: 35%">
				<table id="bar-example-17"
					class="
              charts-css
              bar
              show-labels show-primary-axis show-data-axes
              data-spacing-15
            ">
					<caption></caption>
					<thead>
						<tr>
							<th scope="col">Year</th>
							<th scope="col">Progress</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">Population</th>
							<td style="--size: 1.4">${village.population } People</td>
						</tr>
						<tr>
							<th scope="row">area</th>
							<td style="--size: 0.8">${village.space } km</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="right" style="width: 55%">
				<p>${village.description }</p>
			</div>
		</section>
	</main>

	<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<h5>
						<i class="fa fa-road"></i> HolyLand
					</h5>
					<div class="row">
						<div class="col-6">
							<ul class="list-unstyled">
								<li><a href="/">Homepage</a></li>
								<li><a href="/admin">Admin page</a></li>
								<li><a href="">Send Us An Image</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-2">
					<h6 class="text-md-right">Report this Page</h6>
					<hr />
				</div>
				<div class="col-md-5">
					<form:form action="/add_report/${village.id}" method="POST"
						modelAttribute="report">
						<fieldset class="form-group">

							<form:textarea path="report" class="form-control" placeholder="..."></form:textarea>
						</fieldset>
						<fieldset class="form-group text-xs-right">
							<input type="submit" class="btn btn-secondary btn-lg"
								value="Send">
						</fieldset>
					<form:hidden value="${village.id}" path="village" />

					</form:form>
					</div>
				</div>
			</div>
	</footer>
</body>
</html>