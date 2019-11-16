<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@page import="Entidad.Paciente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Gestor"%>
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

	<%!List<Paciente> listPacientes;
	String buscar = null;%>
	<%
		if (request.getAttribute("pacientes") != null) {
			listPacientes = (List<Paciente>) request.getAttribute("pacientes");
		}
		if (request.getAttribute("buscar") != null) {
			buscar = request.getAttribute("buscar").toString();
		}
	%>

	<div class="container mt-3">
		<div>
			<div>
				<h5 class="titular">Menú Pacientes</h5>
			</div>
			<br>
			<jsp:include page="Resources/alert.jsp"></jsp:include>
			<div>
				<div class="row" style="margin-bottom: 10px;">
					<div class="col-6">
						<form action="ServletPacientes" method="GET">
							Busqueda: <input name="buscar"
								<%if (request.getAttribute("buscar") != null)
				out.print("value=\"" + request.getAttribute("buscar").toString() + "\"");%>
								type="text" required> <input name="pag" value="1"
								type="hidden">
							<button type="submit" class="btn btn-outline-primary">Buscar</button>
							<a href="ServletPacientes" class="btn btn-outline-danger">
								&times </a>
						</form>
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
					<th>Teléfono</th>
					<th>Fecha de nacimiento</th>
					<th>Domicilio</th>
					<th>Extra</th>
					<th>Acciones</th>
				</tr>
				<%
					for (Paciente p : listPacientes) {
				%>
				<tr>
					<td><%=p.getNombre()%></td>
					<td><%=p.getApellido()%></td>
					<td><%=p.getDni()%></td>
					<td><%=p.getTelefono()%></td>
					<td><%=p.getFechaNacimiento()%></td>
					<td><%=p.getDomicilio()%></td>
					<td>
						<%
							if (p.hayExtra()) {
						%> <input type="button" class="btn btn-light"
						data-toggle="tooltip" data-placement="bottom"
						title="<%=p.getInfoExtra()%>" value="Info"> <%
 	}
 %>
					</td>
					<td style="text-align: center;"><a
						href="ServletPacientes?action=edit&id=<%=p.getIDPaciente()%>"
						class="btn btn-primary btn-sm">Modificar</a> <a
						href="ServletPacientes?action=delete&id=<%=p.getIDPaciente()%>"
						class="btn btn-primary btn-sm">Eliminar</a></td>
				</tr>
				<%
					}
				%>
			</table>
			<div>
				<div class="row mt-2">
					<div class="col text-right">
						<%
							if (request.getAttribute("anterior") != null) {
								String pagAnterior = request.getAttribute("anterior").toString();
						%>
						<form action="ServletPacientes" method="GET">
							<%
								if (request.getAttribute("buscar") != null) {
							%>
							<input type="hidden" name="buscar" value="<%=buscar%>">
							<%
								}
							%>
							<input type="hidden" name="pag" value="<%=pagAnterior%>">
							<button type="submit" class="btn btn-light">Anterior</button>
						</form>
						<%
							}
						%>
					</div>
					<div class="col">
						<%
							if (request.getAttribute("siguiente") != null) {
								String pagSiguiente = request.getAttribute("siguiente").toString();
						%>
						<form action="ServletPacientes" method="GET">
							<%
								if (request.getAttribute("buscar") != null) {
							%>
							<input type="hidden" name="buscar" value="<%=buscar%>">
							<%
								}
							%>
							<input type="hidden" name="pag" value="<%=pagSiguiente%>">
							<button type="submit" class="btn btn-light">Siguiente</button>
						</form>
						<%
							}
						%>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>