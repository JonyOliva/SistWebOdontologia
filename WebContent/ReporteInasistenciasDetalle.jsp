<%@page import="Entidad.Paciente"%>
<%@page import="Entidad.InasistenciasDetalle"%>
<%@page import="java.util.List"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="masterInclude.html"></jsp:include>

<%//if(session.getAttribute("usuario") == null) response.sendRedirect("index.jsp");%>

<title>Detalle de Inasistencias</title>
</head>
<body>
<link rel="stylesheet" href="Resources/css/stylesheetMain.css">
<link rel="stylesheet" href="Resources/css/tables.css">
<jsp:include page="masterMenuAdmin.jsp"></jsp:include>

<br>
<div align="center">
<%if(request.getAttribute("PacienteDetalle")!=null)
{
	Paciente p = (Paciente)request.getAttribute("PacienteDetalle");
 %>
 <h4>
<span class="text-imp">
<%
	out.println("DNI:"+" "+ p.getDni());
 %>
</span>&nbsp;&nbsp;|&nbsp;
<span class="text-imp">
<%
	out.println("Nombre: " +p.getNombre()+" "+p.getApellido());
	}
 %>
</span>
</h4>
</div><br>

<table border=1 class="col-6" style="text-align: center;" align="center">
				<tr>
					<th>Fecha</th>
					<th>Turno</th>
					<th>Odontólogo</th>
					<th>Estado</th>
				</tr>
				<%
					List<InasistenciasDetalle> listaInasistenciasDet = null;
					if(request.getAttribute("listaDetalleIna")!= null)
					{
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm");
					listaInasistenciasDet = (List<InasistenciasDetalle>)(request.getAttribute("listaDetalleIna"));
					for (InasistenciasDetalle i : listaInasistenciasDet) {
				%>
				<tr>
					<td><%out.println(i.getFecha().format(formatter)); %></td>
					<td><%out.println(i.getIdTurno()); %></td>
					<td><%out.println(i.getOdontologo()); %></td>
					<td><%out.println(i.getEstado()); %></td>
				</tr>
				<%
					}
					}
				%>
			</table>
</body>
</html>