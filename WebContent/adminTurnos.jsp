<%@page import="Entidad.iUsuario"%>
<%@page import="Datos.iUsuarioDao"%>
<%@page import="DatosImpl.UsuarioDaoImpl"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Entidad.Turno"%>
<%@page import="Entidad.TurnosVista"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="masterInclude.html"></jsp:include>

<%//if(session.getAttribute("usuario") == null) response.sendRedirect("index.jsp");%>

<title>Turnos</title>
</head>
<body>
	<jsp:include page="masterMenuAdmin.jsp"></jsp:include>
	<link rel="stylesheet" href="Resources/css/tables.css">
	<link rel="stylesheet" href="Resources/css/stylesheetMain.css">
<form action="ServletTurnos" method="POST" class="container mt-3">
	<% if(session.getAttribute("usuario") == null) response.sendRedirect("index.jsp"); %>

	<%!List<TurnosVista> listaTurnos;%>

		<div>
			<div>
				<h5 class="titular">
					Menú Turnos
					</h5>
			</div>
			<br>
			<div>
			<jsp:include page ="Resources/alert.jsp"></jsp:include>
				<div class="row">
					<div class="col-6">
<!-- 						<form action="ServletTurnos" method="GET"> -->
<!-- 							Busqueda: <input name="buscar" -->
<%-- 								<%if (request.getAttribute("buscar") != null) --%>
<%-- 				out.print("value=\"" + request.getAttribute("buscar").toString() + "\"");%> --%>
<!-- 								type="text" required> <input name="pag" value="1" -->
<!-- 								type="hidden"> -->
<!-- 							<button type="button" class="btn btn-outline-primary">Buscar</button> -->
<!-- 							<a href="ServletTurnos" class="btn btn-outline-danger"> -->
<!-- 								&times </a> -->
<!-- 						</form> -->
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
					<th>Fecha y hora</th>
					<th>Estado</th>
					<th>Acciones</th>
				</tr>
				<tr>
				<%if(request.getAttribute("turnos") != null)
				{
					listaTurnos =(List<TurnosVista>)request.getAttribute("turnos");
				
				for(TurnosVista t : listaTurnos){ %>
					<td><%=t.getApellidoPac()+", "+t.getNombrePac() %></td>
					<td><%=t.getApellidoOd()+", "+t.getNombreOd()%></td>
					<td><%=t.getTurno().getFecha().toString().replace("T", " ") %></td>
					<td><%=t.getTurno().getEstado() %></td>
					<td style="text-align: center;"><a 
						href="ServletTurnos?operacion=modificar&dni=<%= t.getTurno().getIDPaciente()%>
						&idturno=<%=t.getTurno().getIDTurno()%>"
						class="btn btn-default btnVerde">Modificar</a> 
						<a href="ServletTurnos?operacion=borrar&id=<%=t.getTurno().getIDTurno() %>"
						class="btn btn-default btnVerde">Eliminar</a></td>
				
				</tr>
			<%		}
				}
			%>
			</table>
		</div>

</form>
</body>
</html>