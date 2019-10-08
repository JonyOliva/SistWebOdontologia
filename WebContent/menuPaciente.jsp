<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="masterInclude.html"></jsp:include>
<title>Ficha paciente</title>
<link rel="stylesheet" href="Resources/css/stylesheetMain.css">
</head>
<body>
	<jsp:include page="masterMenuOdont.html"></jsp:include>
	<div class="container mt-3">
		<h5 class="titular">
			Ficha paciente
			</h1>

			<div>
				<jsp:include page="odontograma.html"></jsp:include>
			</div>
			<br>
			<div class="row mt-3" style="text-align: center;">
				<div class="col-6 rounded" style="border: #9de2d4 1px solid;">
					<div class="subtitular">Historial clínico</div>
					<table class="table mt-3">
						<tr>
							<th>Odontologo</th>
							<th>Tratamiento</th>
							<th>Fecha</th>
						</tr>
						<tr>
							<td>Pepito</td>
							<td>Conducto</td>
							<td>06/10/2019</td>
						</tr>
						<tr>
							<td>Cachito</td>
							<td>Corona</td>
							<td>19/05/2019</td>
						</tr>
					</table>
				</div>
				<div class="col-6 rounded" style="border: #9de2d4 1px solid;">
				<div class="subtitular">Registrar nueva consulta</div>
					<table class="table mt-3">
						<tr>
							<th>Tratamiento</th>
							<th>Anotacion extra:</th>
						</tr>
						<tr>
							<td><select>
									<option value="">empaste</option>
									<option value="">mas empaste</option>
							</select></td>
							<td><textarea style="width: 100%" rows="1"></textarea></td>
						</tr>
					</table>
					<a class="btn btn-success m-2" href="#">Guardar consulta</a>
				</div>

			</div>
			<br> <br>
	</div>
</body>
</html>