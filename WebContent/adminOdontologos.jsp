<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="masterInclude.html"></jsp:include>
<title>Odontologos</title>
</head>
<body>
	<jsp:include page="masterMenuAdmin.html"></jsp:include>
	<link rel="stylesheet" href="Resources/css/tables.css">
	<link rel="stylesheet" href="Resources/css/stylesheetMain.css">
	<div class="container mt-3">
		<div>
			<div>
				<h5 class="titular">
					Menú Odontologos
					</h1>
			</div>

			<div>
				<a href="fichaOdontologo.jsp" class="btn btn-primary">Agregar
					nuevo odontologo</a>
			</div>
			<br>
			<table border=1>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>DNI</th>
					<th>Matrícula</th>
					<th>Horarios</th>
					<th>Acciones</th>
				</tr>
				<tr>
					<td>Sergio</td>
					<td>Agosta</td>
					<td>20685423</td>
					<td>3680/1</td>
					<td style="text-align: center;">
						<a href="horariosOdon.jsp"
						class="btn btn-info btn-sm">Ver horarios</a>
					</td>
					<td style="text-align: center;"><a href="fichaOdontologo.jsp"
						class="btn btn-primary btn-sm">Modificar</a> <a href="#"
						class="btn btn-primary btn-sm">Eliminar</a>
					</td>
				</tr>
			</table>
		</div>

	</div>
</body>
</html>