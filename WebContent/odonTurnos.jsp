<%@page import="NegocioImpl.GestionOdontologos"%>
<%@page import="Entidad.Odontologo"%>
<%@page import="Entidad.iUsuario"%>
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

<title>Turnos</title>
<link rel="stylesheet" href="Resources/css/tables.css">
<link rel="stylesheet" href="Resources/css/stylesheetMain.css">
</head>
<body>
	<jsp:include page="masterMenuOdont.jsp"></jsp:include>
	
	<div class="container mt-3">
		<h5 class="titular">
	<% 		
			if(session.getAttribute("usuario") != null)
			{
				Odontologo od ;
				GestionOdontologos go = new GestionOdontologos();
				od = go.get(((Odontologo)session.getAttribute("usuario")).getIDUsuario()); 
	%>			Turnos próximos de <br>Dr. <%=od.getApellido()+", "+od.getNombre() %>
	<%
			}else{response.sendRedirect("index.jsp");}
	%>
			
			</h5>
			
		<div>
		<jsp:include page="Resources/alert.jsp"></jsp:include>
		<%!List<TurnosVista> lista; %>
			<input type="hidden" name="loadOdo">
			<table border=1>
				<tr>
					<th>DNI Paciente</th>
					<th>Apellido y Nombre</th>
					<th>Odontologo</th>
					<th>Fecha y hora</th>
					<th>Acciones</th>
				</tr>
				<%	
					if(request.getAttribute("listaod")!= null) 
					{
						lista = (List<TurnosVista>) request.getAttribute("listaod");
						
						for(TurnosVista t : lista)
						{
				%>
							<tr>
							<td><%= t.getDni() %></td>
							<td><%= t.getApellidoPac()+", "+t.getNombrePac() %></td>
							<td><%=t.getTurno().getIDOdontologo()%></td>
							<td><%= t.getTurno().getFecha().toString().replace('T', ' ') %></td>
							<td><a href="ServletPacientes?action=presente&idturno=<%=t.getTurno().getIDTurno() %>&idpac=<%=t.getTurno().getIDPaciente() %>" 
								class="btn btn-primary">Presente</a>
							<a href="ServletPacientes?action=ausente&idturno=<%=t.getTurno().getIDTurno() %>&idpac=<%=t.getTurno().getIDPaciente() %>" class="btn btn-danger">Ausente</a></td>
							</tr>
				<%
						}
					}
				%>
				
			</table>
		</div>
	</div>
</body>
</html>