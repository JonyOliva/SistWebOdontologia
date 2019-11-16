<%@page import="java.util.List"%>
<%@page import="Entidad.Inasistencias"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="masterInclude.html"></jsp:include>
<title>Inasistencias</title>
</head>
<body>
<jsp:include page="masterMenuAdmin.jsp"></jsp:include>
<br>
<form method="get" action="ServletReportes">
<div align="center">
<input type="number" >
<input type="submit" class="btn btn-light" value="Buscar" name="btnBuscar">
</div>
</form>
<br>

<table border=1 class="col-6" style="text-align: center;" align="center">
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>DNI</th>
					<th>Cantidad de Inasistencias</th>
					<th></th>
				</tr>
				<%
					List<Inasistencias> listaInasistencias = null;
					if(request.getAttribute("listaInasistencias")!= null)
					{
						listaInasistencias = (List<Inasistencias>) (request.getAttribute("listaInasistencias"));
					}
					for (Inasistencias i : listaInasistencias) {
				%>
				<form method="post" action="ServletReportes">
				<tr>
					<td><%out.println(i.getPac().getNombre()); %></td>
					<td><%out.println(i.getPac().getApellido()); %></td>
					<td><%out.println(i.getPac().getDni()); %></td>
					<td><%out.println(i.getInasistencias()); %></td>
					<td>
						<input type="submit" class="btn btn-light" name="btnDetalle" title="Detalle" value="Detalle">
					</td>
				</tr>
				</form>
				<%
					}
				%>
			</table>
</body>
</html>