<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="masterInclude.html"></jsp:include>
<title>Turnos</title>
</head>
<body>
	<jsp:include page="masterMenuAdmin.html"></jsp:include>
	<link rel="stylesheet" href="Resources/css/tables.css">
	<link rel="stylesheet" href="Resources/css/stylesheetMain.css">
	<div class="container mt-3">

		<div>
			<div>
				<h5 class="titular">
					Menú Turnos
					</h1>
			</div>
			<div>
				<a href="regTurno.jsp" class=" btn btn-default"
					style="color: black; background: #48C9B0;">Agregar nuevo
					turno</a>
			</div>
			<br>
			<table border=1>
				<tr>
					<th>Paciente</th>
					<th>Odontologo</th>
					<th>Fecha</th>
					<th>Estado</th>
					<th>Acciones</th>
				</tr>
				<tr>
					<td>****</td>
					<td>****</td>
					<td>28/04/2020</td>
					<td>activo</td>
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