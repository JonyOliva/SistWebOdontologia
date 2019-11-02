<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="masterInclude.html"></jsp:include>
<title>Turnos</title>
</head>

<style>
.btnVerde {
	color: black;
	background: #48C9B0;
	border: grey solid 1px;
}
</style>

<body>
	<jsp:include page="masterMenuAdmin.jsp"></jsp:include>
	<link rel="stylesheet" href="Resources/css/tables.css">
	<link rel="stylesheet" href="Resources/css/stylesheetMain.css">
	<div class="container mt-3">
	<% if(session.getAttribute("usuario") == null) response.sendRedirect("index.jsp"); %>

		<div>
			<div>
				<h5 class="titular">
					Menú Turnos
					</h1>
			</div>
			<br>
			<div>
				<div class="row">
					<div class="col-6">
						Buscar: <input type="text">
					</div>
					<div class="col-6" style="text-align: right;">
						<a href="registroTurno.jsp" class=" btn btn-default btnVerde">Agregar
							nuevo turno</a>
					</div>
				</div>
			</div>
			<div></div>
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
					<td style="text-align: center;"><a href="registroTurno.jsp"
						class="btn btn-default btn-sm btnVerde">Modificar</a> <a href="#"
						class="btn btn-default btn-sm btnVerde">Eliminar</a></td>
				</tr>
			</table>
		</div>

	</div>


</body>
</html>