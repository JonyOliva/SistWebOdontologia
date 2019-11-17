<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@page import="Entidad.Odontologo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="masterInclude.html"></jsp:include>
<link rel="stylesheet" href="Resources/css/stylesheetMain.css">
<script type="text/javascript" src="Resources/js/validar.js"></script>
<title>Ficha odontologo</title>
</head>
<style>
<
style>body {
	margin: 0 auto 0 auto;
	width: 100%;
	background: #ebf9f6;
}

input {
	border-radius: 4px;
	text-align: center;
	margin: 0px auto 10px 20px;
}

.box {
	background: white;
	width: 330px;
	border-radius: 6px;
	margin: 3% auto 0 auto;
	padding: 20px;
	border: #9de2d4 1px solid;
	align-text: center;
}

.text-imp {
	font-size: 18px;
	text-align: center;
	font-weight: bold
}
</style>

<body>
	<jsp:include page="masterMenuAdmin.jsp"></jsp:include>
	<%
		Odontologo odont = null;
		if (request.getAttribute("odontologo") != null) {
			odont = (Odontologo) request.getAttribute("odontologo");
		}
	%>
	<div class="container mt-3">
		<div>
			<div>
				<h5 class="titular">Odontologo</h5>
			</div>
			<form class="box" method="POST" action="ServletOdontologos" onsubmit="return validarCampoText()">
				<%
					if (odont != null) {
				%>
				<input type="hidden" name="action" value="edit">
				<input type="hidden" name="ID" value="<%= odont.getIDUsuario() %>">
				<p class="text-imp">Datos personales</p>
				<table>
					<tr>
						<td>Nombre:</td>
						<td><input name="Nombre" type="text" onkeypress="validarTecla(event)" value="<%= odont.getNombre() %>" required></td>
					</tr>
					<tr>
						<td>Apellido:</td>
						<td><input name="Apellido" type="text" onkeypress="validarTecla(event)" value="<%= odont.getApellido() %>" required></td>
					</tr>
					<tr>
						<td>DNI:</td>
						<td><input name="DNI" value="<%= odont.getDNI() %>" type="number" required></td>
					</tr>
					<tr>
						<td>Matricula:</td>
						<td><input name="Matricula" value="<%= odont.getMatricula() %>" required></td>
					</tr>
				</table>
				<hr>
				<p class="text-imp">Usuario de login</p>
				<table>
					<tr>
						<td>Email:</td>
						<td><input name="Email" value="<%= odont.getEmail() %>" type="email" required></td>
					</tr>
					<tr>
						<td>Contraseña:</td>
						<td><input name="Password" type="password" value="<%= odont.getPassword() %>" required></td>
					</tr>
				</table>
				<%
					} else {
				%>
				<input type="hidden" name="action" value="new">
				<p class="text-imp">Datos personales</p>
				<table>
					<tr>
						<td>Nombre:</td>
						<td><input name="Nombre" type="text" onkeypress="validarTecla(event)" required></td>
					</tr>
					<tr>
						<td>Apellido:</td>
						<td><input name="Apellido" type="text" onkeypress="validarTecla(event)" required></td>
					</tr>
					<tr>
						<td>DNI:</td>
						<td><input name="DNI" type="number" required></td>
					</tr>
					<tr>
						<td>Matricula:</td>
						<td><input name="Matricula" required></td>
					</tr>
				</table>
				<hr>
				<p class="text-imp">Usuario de login</p>
				<table>
					<tr>
						<td>Email:</td>
						<td><input name="Email" type="email" required></td>
					</tr>
					<tr>
						<td>Contraseña:</td>
						<td><input name="Password" type="password" required></td>
					</tr>
				</table>
				<%
					}
				%>
				<br>
				<div class="text-center">
					<button class="btn btn-primary">Guardar</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>