<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@page import="Entidad.Paciente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="masterInclude.html"></jsp:include>
<title>Pacientes</title>
<link rel="stylesheet" href="Resources/css/tables.css">
<link rel="stylesheet" href="Resources/css/stylesheetMain.css">
</head>
<body>
	<jsp:include page="masterMenuAdmin.html"></jsp:include>

	<%!List<Paciente> listPacientes = new ArrayList<Paciente>();%>
	<%
		if (request.getAttribute("listaPacientes") != null) {
			listPacientes = (List<Paciente>) request.getAttribute("listaPacientes");
		}
	%>

	<div class="container mt-3">

		<div>
			<div>
				<h5 class="titular">Men� Pacientes</h5>
			</div>
			<br>
			<div>
				<div class="row" style="margin-bottom: 10px;">
					<div class="col-6">
						Buscar: <input type="text">
					</div>
					<div class="col-6" style="text-align: right;">
						<a href="fichaPaciente.jsp" class="btn btn-primary">Agregar
							nuevo paciente</a>
					</div>
				</div>
			</div>
			<table border=1>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>DNI</th>
					<th>Tel�fono</th>
					<th>Fecha de nacimiento</th>
					<th>Domicilio</th>
					<th>Extra</th>
					<th>Acciones</th>
				</tr>
				<!-- 
				<tr>
					<td>Claudio</td>
					<td>Fernandez</td>
					<td>20326495</td>
					<td>116582432</td>
					<td>07/05/1962</td>
					<td>Calle 123</td>
					<td></td>
					<td style="text-align: center;"><a href="fichaPaciente.jsp"
						class="btn btn-primary btn-sm">Modificar</a> <a href="#"
						class="btn btn-primary btn-sm">Eliminar</a></td>
				</tr>
				 -->
				<%
					for(Paciente p : listPacientes){
				%>
					<tr>
						<td><%= p.getNombre() %></td>
						<td><%= p.getApellido() %></td>
						<td><%= p.getDni() %></td>
						<td><%= p.getTelefono() %></td>
						<td><%= p.getFechaNacimiento() %></td>
						<td><%= p.getDomicilio() %></td>
						<td><%= p.getInfoExtra() %></td>
						<td style="text-align: center;"><a href="fichaPaciente.jsp"
							class="btn btn-primary btn-sm">Modificar</a> <a href="#"
							class="btn btn-primary btn-sm">Eliminar</a></td>
					</tr>
				<%
					}
				%>
			</table>
		</div>

	</div>

</body>
</html>