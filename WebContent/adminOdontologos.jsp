<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Entidad.Odontologo"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="masterInclude.html"></jsp:include>

<%//if(session.getAttribute("usuario") == null) response.sendRedirect("index.jsp");%>

<title>Odontologos</title>
</head>
<body>
	<jsp:include page="masterMenuAdmin.jsp"></jsp:include>
	<link rel="stylesheet" href="Resources/css/tables.css">
	<link rel="stylesheet" href="Resources/css/stylesheetMain.css">
	<%!List<Odontologo> listOdonts;%>
	<%
		if (request.getAttribute("odontologos") != null) {
			listOdonts = (List<Odontologo>) request.getAttribute("odontologos");
		}
	%>
	<div class="container mt-3">
		<div>
			<div>
				<h5 class="titular">Menú Odontologos</h5>
			</div>
			<br />
			<jsp:include page="Resources/alert.jsp"></jsp:include>
			<div>
				<div class="row" style="margin-bottom: 10px;">
					<div class="col-6"></div>
					<div class="col-6" style="text-align: right;">
						<a href="fichaOdontologo.jsp" class="btn btn-primary">Agregar
							nuevo odontologo</a>
					</div>
				</div>
			</div>
			<table border=1>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>DNI</th>
					<th>Matrícula</th>
					<th>Horarios</th>
					<th>Acciones</th>
				</tr>
				<%
					for (Odontologo odont : listOdonts) {
				%>
				<tr>
					<td><%=odont.getNombre()%></td>
					<td><%=odont.getApellido()%></td>
					<td><%=odont.getDNI()%></td>
					<td><%=odont.getMatricula()%></td>
					<td style="text-align: center;"><a
						href="ServletHorarios?id=<%=odont.getIDUsuario()%>"
						class="btn btn-secondary btn-sm">Ver Horarios</a></td>
					<td style="text-align: center;"><a
						href="ServletOdontologos?action=edit&id=<%=odont.getIDUsuario()%>"
						class="btn btn-primary btn-sm">Modificar</a> 
						<!-- <a href="#" class="btn btn-primary btn-sm">Eliminar</a></td> -->
				</tr>
				<%
					}
				%>
			</table>
		</div>

	</div>
</body>
</html>