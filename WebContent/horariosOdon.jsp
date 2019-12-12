<%@page import="Entidad.iUsuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="Entidad.Odontologo"%>
<%@page import="Entidad.HorarioOdonto"%>
<%@page import="NegocioImpl.GestionOdontologos"%>


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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">


</head>
<body>
	<jsp:include page="masterMenuAdmin.jsp"></jsp:include>

<%!List<HorarioOdonto> listaHor;%>
<%!String Nombre="";%>



<%
		if (request.getAttribute("horarios") != null) {
			listaHor = (List<HorarioOdonto>) request.getAttribute("horarios");
		}
	%>




	<div class="container mt-3">
	
		<div>
			<div>

			<%!GestionOdontologos gh = new GestionOdontologos();%>
<% 
if (request.getAttribute("id")!= null){
Odontologo od = gh.get(request.getAttribute("id").toString());
Nombre= od.getNombre() +" "+ od.getApellido();
}
%>

		
				<h5 class="titular">
				 Tabla de Horarios<br/>
					Dr. <%= Nombre %>
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
					
						
						 <a href="ServletHorarios?action=delete&id=<%=request.getAttribute("id")%>&idHorario=<%=hor.getIDHorario()%>"
						class="btn btn-primary btn-sm">Eliminar</a>
						</td>	
					<%} %>
					
								
					
				</tr>
				<%
					}
				%>
				<form method="post" action="ServletHorarios">
				<input type="hidden" name="id" value="<%=request.getAttribute("id") %>">
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
						
				</tr>
				</form>

				<%
				if (request.getAttribute("Insertado")!= null) {
			Boolean listo = Boolean.parseBoolean(request.getAttribute("Insertado").toString());
			if (listo == true){
			%>
			<div class="alert alert-success" role="alert">
  Horario Insertado con éxito
</div>
			
			
			<% 
		
			} 
			else if (listo == false){
			
			%>
				<div class="alert alert-danger" role="alert">
  Faltan datos o los datos ingresados son incorrectos.
</div>
			
			 <%}
			;}
			 %> 

			</table>
		</div>

	</div>
	
	
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>