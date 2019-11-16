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
<div align="center">
<label >
<%
	out.println("DNI:"+ "");
 %>
</label>
<label>
<%
	out.println("Nombre:" +"");
 %>
</label>
</div><br>

<table border=1 class="col-6" style="text-align: center;" align="center">
				<tr>
					<th>Fecha</th>
					<th>Turno</th>
					<th>Odontólogo</th>
					<th>Tratamiento</th>
					<th>Anotación</th>
					<th>Estado</th>
				</tr>
				<%
					//for (Inasistencias i : listaInasistencias) {
				%>
				<tr>
					<td>23/2/3222</td>
					<td>2323</td>
					<td>Mario Perez</td>
					<td>Exodoncia</td>
					<td>Excesivo Sangrado</td>
					<td>Ausente</td>
				</tr>
				<%
					//}
				%>
			</table>
</body>
</html>