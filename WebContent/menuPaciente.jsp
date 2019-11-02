<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
		<%@page import="Entidad.Paciente"%>
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
	<%
		Paciente paciente = null;
		if (request.getAttribute("paciente") != null) {
			paciente = (Paciente)request.getAttribute("paciente");
		} else {
			response.sendRedirect("ServletPacientes");
		}
	%>
	<div class="container mt-3">
		<h5 class="titular">Ficha paciente</h5>
		<br/>
		<div class="row justify-content-center" style="text-align: center;">
			<div class="rounded col-8" style="border: #9de2d4 1px solid;">
				<div class="subtitular">Datos del paciente</div>
				<table class="table table-sm mt-3">
					<tr>
						<th>Nombre: </th>
						<td><%= paciente.getNombre() %></td>
					</tr>
					<tr>
						<td>Apellido: </td>
						<td><%= paciente.getApellido() %></td>
					</tr>
					<tr>
						<td>DNI: </td>
						<td><%= paciente.getDni() %></td>
					</tr>
					<tr>
						<td>Teléfono: </td>
						<td><%= paciente.getTelefono() %></td>
					</tr>
					<tr>
						<td>Domicilio: </td>
						<td><%= paciente.getDomicilio() %></td>
					</tr>
					<tr>
						<td>Fecha de nacimiento: </td>
						<td><%= paciente.getFechaNacimiento() %></td>
					</tr>
					<% if(paciente.hayExtra()){ %>
					<tr>
						<td>Información extra: </td>
						<td><%= paciente.getInfoExtra() %></td>
					</tr>
					<%
					}
					%>
				</table>
			</div>
		</div>
		<br />
		<div>
			<input type="hidden" id="idpaciente" value="<%= paciente.getIDPaciente() %>">
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