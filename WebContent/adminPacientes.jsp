<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="masterInclude.html"></jsp:include>
<title>Pacientes</title>
<link rel="stylesheet" href="Resources/css/tables.css">
<link rel="stylesheet" href="Resources/css/stylesheetMain.css">
</head>
<body>
	<jsp:include page="masterMenuAdmin.html"></jsp:include>

	<div class="container mt-3">

		<div>
			<div>
				<h5 class="titular">
					Menú Pacientes
					</h1>
			</div>
			<div>
				<a href="fichaPaciente.jsp" class="btn btn-primary">Agregar
					nuevo paciente</a>
			</div>
			<br>
			<table border=1>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>DNI</th>
					<th>Teléfono</th>
					<th>Fecha de nacimiento</th>
					<th>Domicilio</th>
					<th>Extra</th>
					<th>Acciones</th>
				</tr>
				<tr>
					<td>Claudio</td>
					<td>Fernandez</td>
					<td>20326495</td>
					<td>11658243</td>
					<td>07/5/1962</td>
					<td>Calle 123</td>
					<td></td>
					<td style="text-align: center;">
						<button style="font-size: 13px;">Modificar</button>
						<button style="font-size: 13px;">Eliminar</button>
					</td>
				</tr>
			</table>
		</div>

	</div>

</body>
</html>