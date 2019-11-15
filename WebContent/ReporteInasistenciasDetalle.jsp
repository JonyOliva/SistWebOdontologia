<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="masterInclude.html"></jsp:include>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="masterMenuAdmin.jsp"></jsp:include>

<br>

<table border=1 class="col-6" style="text-align: center;" align="center">
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>DNI</th>
					<th>Odontólogo</th>
					<th>Turno</th>
					<th>Fecha</th>
					<th>Estado</th>
				</tr>
				<%
					//for (Inasistencias i : listaInasistencias) {
				%>
				<tr>
					<td>Juancito</td>
					<td>Probando</td>
					<td>Cosas</td>
					<td>Pepito</td>
					<td>2323</td>
					<td>23/2/3222</td>
					<td>Ausente</td>
				</tr>
				<%
					//}
				%>
			</table>
</body>
</html>