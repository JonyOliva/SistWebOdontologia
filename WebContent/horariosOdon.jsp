<%@page import="Entidad.iUsuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="Entidad.Odontologo"%>
<%@page import="Entidad.HorarioOdonto"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="masterInclude.html"></jsp:include>

<%//if(session.getAttribute("usuario") == null) response.sendRedirect("index.jsp");%>

<title>Horarios</title>
<link rel="stylesheet" href="Resources/css/tables.css">
<link rel="stylesheet" href="Resources/css/stylesheetMain.css">
</head>
<body>
	<jsp:include page="masterMenuAdmin.jsp"></jsp:include>

<%!List<HorarioOdonto> listaHor;%>
<%
		if (request.getAttribute("horarios") != null) {
			listaHor = (List<HorarioOdonto>) request.getAttribute("horarios");
		}
	%>




	<div class="container mt-3">
	
		<div>
			<div>
		
				<h5 class="titular">
				 Tabla de Horarios
					
					</h5>
			</div>
			<br>
			<table border=1>
				<tr>
					<th>Día</th>
					<th>Inicio de la jornada</th>
					<th>Fin de la jornada</th>
					<th>Acciones</th>
				</tr>
				<%
					for (HorarioOdonto hor : listaHor) {
					if (hor.getActivo() == true){
				%>
				<tr>
					<td><%=hor.getDia().toString() %></td>
					<td><%=hor.getHoraInicio()%></td>
					<td><%=hor.getHoraFin()%></td>
				<td style="text-align: center;">
					
						
						 <a href="ServletHorarios?action=delete&idHorario=<%=hor.getIDHorario()%>"
						class="btn btn-primary btn-sm">Eliminar</a>
						</td>	
					<%} %>
					
								
					
				</tr>
				<%
					}
				%>
				<form method="post" action="ServletHorarios">
				<tr>
				
					<td>
					
						<select name="ddlDias">
							<option value="Lunes">Lunes</option>
							<option value="Martes">Martes</option>
							<option value="Miercoles">Miercoles</option>
							<option value="Jueves">Jueves</option>
							<option value="Viernes">Viernes</option>
						</select>
					</td>
					<td><input type="time" name="HoraInicio"></td>
					<td><input type="time" name="HoraFin" ></td>
					<td style="text-align: center;"><input type="submit" name="btnAgregarHorario" value="Agregar"
						class="btn btn-primary btn-sm"/></td>
				</tr></form>
			</table>
		</div>

	</div>
	
	

</body>
</html>