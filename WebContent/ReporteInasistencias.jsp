<%@page import="java.util.List"%>
<%@page import="Entidad.Inasistencias"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="masterInclude.html"></jsp:include>

<%//if(session.getAttribute("usuario") == null) response.sendRedirect("index.jsp");%>

<title>Inasistencias</title>
</head>
<body>
<link rel="stylesheet" href="Resources/css/stylesheetMain.css">
<link rel="stylesheet" href="Resources/css/tables.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<jsp:include page="masterMenuAdmin.jsp"></jsp:include>
<br>
			<div align="center">
				<h5 class="titular">
					Reporte de Inasistencias
					</h5>
			</div><br>



<form action="ServletReportes" method="post">
<div align=center>
Desde: <input type="date" id="txtDesde" name="txtDesde" required>&nbsp;&nbsp;&nbsp;|
&nbsp;&nbsp;Hasta: <input type="date" id="txtHasta" name="txtHasta" required>&nbsp;&nbsp;&nbsp;
<input type="submit" value="Filtrar"class=" btn btn-default btnVerde" id="btnFiltrar" name="btnFiltrar">
</div></form><br>

<div align="center">
<input id="Busqueda" type="text" placeholder="Buscar.." style="width: 284px; ">
</div><br>
<table border=1 class="col-6" style="text-align: center;" align="center">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>DNI</th>
					<th>Cantidad de Inasistencias</th>
					<th>Estado</th>
					<th>Detalle</th>
				</tr>
			</thead>
				<%
					List<Inasistencias> listaInasistencias = null;
					if(request.getAttribute("listaInasistencias")!= null)
					{
						listaInasistencias = (List<Inasistencias>) (request.getAttribute("listaInasistencias"));
						for (Inasistencias i : listaInasistencias) {
				%>
				<form method="post" action="ServletReportes?Param=<%=i.getPac().getIDPaciente()%>">
				<tbody id="Tabla">
				<tr>
					<td><%out.println(i.getPac().getNombre()); %></td>
					<td><%out.println(i.getPac().getApellido()); %></td>
					<td><%out.println(i.getPac().getDni()); %></td>
					<td><%out.println(i.getInasistencias()); %></td>
					<td><%out.println(i.getEstado()); %></td>
					<td>
						<input type="submit" class="btn btn-light" name="btnDetalle" title="Detalle" value="Detalle">
					</td>
				</tr>
				</tbody>
				</form>
				<%
					}
					}
				%>
			</table>
			
			
<script>
$(document).ready(function(){
  $("#Busqueda").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#Tabla tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>

</body>
</html>