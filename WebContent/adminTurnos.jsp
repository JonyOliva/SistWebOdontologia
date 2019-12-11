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

	<% if(session.getAttribute("usuario") == null) response.sendRedirect("index.jsp"); %>

	<%!
		List<TurnosVista> listaTurnos;
		String buscar = null;
	%>
	<%
		if (request.getAttribute("turnos") != null) {
			listaTurnos = (List<TurnosVista>) request.getAttribute("turnos");
		}
		if (request.getAttribute("buscar") != null) {
			buscar = request.getAttribute("buscar").toString();
		}
	%>
	

		
		<div class="container mt-3">
				<h5 class="titular">
					Menú Turnos
					</h5>
			<br>
			<div>
			<jsp:include page ="Resources/alert.jsp"></jsp:include>
				<div class="row">
					<div class="col-12">
						<form action="ServletTurnos" method="GET">
						<div>
						<select name="tbusqueda">
						<option value="v">Buscar por...</option>
						<option 
					<%
						if(request.getAttribute("tbusque") != null)
							if(request.getAttribute("tbusque").toString().equals("od")) 
								out.print("selected=\"true"+"\"");
					%> 				value="od"> Buscar por odontologo</option>
						<option 
					<%	
						if(request.getAttribute("tbusque") != null)
							if(request.getAttribute("tbusque").toString().equals("pac")) 
								out.print("selected=\"true"+"\"");
					%> 				value="pac"> Buscar por paciente</option>
						</select>
						</div>
						<br>
							Busqueda: <input name="buscar"
								<%if (request.getAttribute("buscar") != null)
									out.print("value=\"" + request.getAttribute("buscar").toString() + "\"");%>
								type="text" > <input name="pag" value="1"
								type="hidden">
							<button type="submit" class="btn btn-outline-primary">Buscar</button>
							<a href="ServletTurnos?tbusqueda=v" class="btn btn-outline-danger">
								&times </a>
						Desde: <input
						<% 
							if(request.getAttribute("desde")!= null) 
							{
								out.print("value=\""+request.getAttribute("desde").toString()+"\"");
								
							}
								
						%>  	
								type="date" name = "desde">
							
						
							
							Hasta: <input
						<% 
							if(request.getAttribute("hasta")!= null) 
							{
								out.print("value=\""+request.getAttribute("hasta").toString()+"\"");
								
							}
								
						%>  	
							type="date" name = "hasta">
							<a href="registroTurno.jsp" class=" btn btn-default btnVerde">Agregar
								nuevo turno</a>
						</form>

					</div>
					</div>
		

				</div>
			</div>
		<form action="ServletTurnos" method="POST" class="container mt-3">
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
		</form>
			<div>
				<div class="row mt-2">
					<div class="col text-right">
						<%
							if (request.getAttribute("anterior") != null) {
								String pagAnterior = request.getAttribute("anterior").toString();
						%>
						<form action="ServletTurnos" method="GET">
							<%
								if (request.getAttribute("buscar") != null) {
							%>
							<input type="hidden" name="buscar" value="<%=buscar%>">
							<%
								}
							%>
							<input type="hidden" name="desde"
						<%
							if(request.getAttribute("desde")!= null)
							{
								out.print(" value=\""+request.getAttribute("desde").toString()+"\"");
							} 
						%>
							>
							<input type="hidden" name="hasta" 
						<%
							if(request.getAttribute("hasta")!= null)
							{
								out.print("value=\""+request.getAttribute("hasta").toString()+"\"");
							} 
						%>
							>
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
						<form action="ServletTurnos" method="GET">
							<%
								if (request.getAttribute("buscar") != null) {
							%>
							<input type="hidden" name="buscar" value="<%=buscar%>">
							<%
								}
							%>
							<input type="hidden" name="desde"
						<%
							if(request.getAttribute("desde")!= null)
							{
								out.print(" value=\""+request.getAttribute("desde").toString()+"\"");
							} 
						%>
							>
							<input type="hidden" name="hasta" 
						<%
							if(request.getAttribute("hasta")!= null)
							{
								out.print("value=\""+request.getAttribute("hasta").toString()+"\"");
							} 
						%>
							>
							<input type="hidden" name="pag" value="<%=pagSiguiente%>">
							<button type="submit" class="btn btn-light">Siguiente</button>
						</form>
						<%
							}
						%>
					</div>
				</div>
			</div>
</body>
</html>