<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="masterInclude.html"></jsp:include>
<title>Horarios</title>
<link rel="stylesheet" href="Resources/css/tables.css">
<link rel="stylesheet" href="Resources/css/stylesheetMain.css">
</head>
<body>
	<jsp:include page="masterMenuAdmin.html"></jsp:include>

	<div class="container mt-3">

		<div>
			<div>
				<h5 class="titular">
					Horarios Sergio Agosta
					</h1>
			</div>
			<br>
			<table border=1>
				<tr>
					<th>D�a</th>
					<th>Inicio de la jornada</th>
					<th>Fin de la jornada</th>
					<th>Acciones</th>
				</tr>
				<tr>
					<td>Martes</td>
					<td>08:00hs</td>
					<td>16:00hs</td>
					<td style="text-align: center;"><a href="fichaPaciente.jsp"
						class="btn btn-primary btn-sm">Modificar</a> <a href="#"
						class="btn btn-primary btn-sm">Eliminar</a></td>
				</tr>
				<tr>
					<td>Jueves</td>
					<td>10:00hs</td>
					<td>18:00hs</td>
					<td style="text-align: center;"><a href="#"
						class="btn btn-primary btn-sm">Modificar</a> <a href="#"
						class="btn btn-primary btn-sm">Eliminar</a></td>
				</tr>
				<tr>
					<td>
						<select >
							<option value="">Lunes</option>
							<option value="">Martes</option>
							<option value="">Miercoles</option>
							<option value="">Jueves</option>
							<option value="">Viernes</option>
						</select>
					</td>
					<td><input type="time"></td>
					<td><input type="time"></td>
					<td style="text-align: center;"><a href="#"
						class="btn btn-primary btn-sm">Agregar</a></td>
				</tr>
			</table>
		</div>

	</div>

</body>
</html>