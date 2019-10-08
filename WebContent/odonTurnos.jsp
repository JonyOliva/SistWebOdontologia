<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="masterInclude.html"></jsp:include>
<title>Turnos</title>
<link rel="stylesheet" href="Resources/css/tables.css">
<link rel="stylesheet" href="Resources/css/stylesheetMain.css">
</head>
<body>
	<jsp:include page="masterMenuOdont.html"></jsp:include>
	<div class="container mt-3">
		<h5 class="titular">
			Turnos próximos
			</h1>
			
		<div>
			<table border=1>
				<tr>
					<th>Paciente</th>
					<th>Odontologo</th>
					<th>Fecha</th>
					<th>Hora</th>
					<th>Acciones</th>
				</tr>
				<tr>
					<td>****</td>
					<td>****</td>
					<td>10/05/2019</td>
					<td>9:30hs</td>
					<td><a href="menuPaciente.jsp" class="btn btn-info">Aceptar turno</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>