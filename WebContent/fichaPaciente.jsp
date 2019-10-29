<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Entidad.Paciente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="masterInclude.html"></jsp:include>
<link rel="stylesheet" href="Resources/css/stylesheetMain.css">
<title>Ficha paciente</title>
</head>
<style>
<
style>body {
	margin: 0 auto 0 auto;
	width: 100%;
	background: #ebf9f6;
}

input {
	border-radius: 4px;
	text-align: center;
	margin: 0px 0px 10px 0px;
}

.box {
	background: white;
	width: 300px;
	border-radius: 6px;
	margin: 3% auto 0 auto;
	padding: 20px;
	border: #9de2d4 1px solid;
}
</style>

<body>
	<jsp:include page="masterMenuAdmin.html"></jsp:include>
	<%
		Paciente paciente = null;
		if (request.getAttribute("paciente") != null) {
			paciente = (Paciente) request.getAttribute("paciente");
		}
	%>
	<div class="container mt-3">
		<div>
			<div>
				<h5 class="titular">Paciente</h5>
			</div>
			<form class="box" method="POST" action="ServletPacientes">
				
				<%if (paciente != null) {%>
					<input type="hidden" name="action" value="edit">
					<input type="hidden" name="ID" value="<%= paciente.getIDPaciente() %>">
				<%
					} else {
				%>
					<input type="hidden" name="action" value="new">
				<%
					}
				%>

				<table>
					<%
						if (paciente != null) {
					%>
					<tr>
						<td>Nombre:</td>
						<td><input name="Nombre" value="<%=paciente.getNombre()%>" required>
						</td>
					</tr>
					<tr>
						<td>Apellido:</td>
						<td><input name="Apellido" value="<%=paciente.getApellido()%>" required></td>
					</tr>
					<tr>
						<td>DNI:</td>
						<td><input name="DNI" value="<%=paciente.getDni()%>" type="number"
							required></td>
					</tr>
					<tr>
						<td>Teléfono:</td>
						<td><input name="Telefono" value="<%=paciente.getTelefono()%>" type="number"></td>
					</tr>
					<tr>
						<td>Domicilio:</td>
						<td><input name="Domicilio" value="<%=paciente.getDomicilio()%>" type="text"></td>
					</tr>
					<tr>
						<td>Fecha de nacimiento:</td>
						<td><input name="Fecha" value="<%=paciente.getFechaNacimiento()%>"
							type="date" required></td>
					</tr>
					<% if(paciente.hayExtra()){ %>
					<tr>
						<td>Anotacion:</td>
						<td><input name="InfoExtra" type="text" value="<%=paciente.getInfoExtra()%>"></td>
					</tr>
					<%
					}
					%>
					<%
						} else {
					%>
					<tr>
						<td>Nombre:</td>
						<td><input name="Nombre" required></td>
					</tr>
					<tr>
						<td>Apellido:</td>
						<td><input name="Apellido" required></td>
					</tr>
					<tr>
						<td>DNI:</td>
						<td><input name="DNI" type="number" required></td>
					</tr>
					<tr>
						<td>Teléfono:</td>
						<td><input name="Telefono" type="number"></td>
					</tr>
					<tr>
						<td>Domicilio:</td>
						<td><input name="Domicilio" type="text"></td>
					</tr>
					<tr>
						<td>Fecha de nacimiento:</td>
						<td><input name="Fecha" type="date" required></td>
					</tr>
					<tr>
						<td>Anotacion:</td>
						<td><input name="InfoExtra" type="text"></td>
					</tr>
					<%
						}
					%>
				</table>
				<br>
				<div style="text-align: center">
					<input value="Guardar" type="submit" class="btn btn-primary">
				</div>
			</form>
		</div>
	</div>
</body>
</html>