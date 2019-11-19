<%@page import="java.time.LocalDateTime"%>
<%@page import="NegocioImpl.GestionOdontologos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Entidad.Odontologo"%>
<%@page import="Entidad.Paciente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="masterInclude.html"></jsp:include>

<%//if(session.getAttribute("usuario") == null) response.sendRedirect("index.jsp");%>

<link rel="stylesheet" href="Resources/css/stylesheetMain.css">
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
	margin: 0px 0px 10px 0px;
}

.box {
	background: white;
	width: 350px;
	border-radius: 6px;
	margin: 3% auto 0 auto;
	padding: 20px;
	border: #9de2d4 1px solid;
	text-align: center;
}
</style>

<body>
	<jsp:include page="masterMenuAdmin.jsp"></jsp:include>

	<%!List<Odontologo> listaOdontologo;
	GestionOdontologos go = new GestionOdontologos();%>
	<%
		listaOdontologo = go.getAll();
		Paciente pac = (Paciente) request.getAttribute("paciente");
	%>

	<div class="container mt-3">
		<div>
			<div>
				<h5 class="titular">Turno</h5>
			</div>

			<form class="box" method="post" action="ServletTurnos">
			
			
			<%	
				if(request.getAttribute("Correcto")!= null)
				{
					
			%>
						<dir class="box" style="width:80%;">
							<%out.print((String)request.getAttribute("Correcto"));%>
						</dir>
			<%
						request.setAttribute("Correcto",null);
				 }
			%>
			
				<div class="row justify-content-center" style="font-size: 18px;">
					Agregar nuevo turno</div>
					<br>
				<table>
					<tr>
						<td>DNI paciente:</td>
						<td><input id="dni" name="txtDnipaciente" type="number" required></td>
					</tr>
					<tr>
						<td><button id="btnReset" type="button" class="btn btn-danger btn-sm m-2">Limpiar</button></td>
						<td><button id="btnCheck" type="button" class="btn btn-success btn-sm m-2">Comprobar paciente</button></td>
					</tr>
					<tr>
						<td>Nombre:</td>
						<td><input value="" type="text" id="nombre" disabled></td>
					</tr>
					<tr>
						<td>Apellido:</td>
						<td><input value="" type="text" id="apellido" disabled></td>
					</tr>
					<tr>
						<td>Fecha de nacimiento:</td>
						<td><input value="" type="text" id="fechaNac" disabled></td>
					</tr>
					<tr>
						<td colspan="2"> <hr></td>
					</tr>
					
					<tr>
						<td>Odontologo:</td>
						<td><select id="ddlOdontologo" name="ddlOdontologo" style="margin-bottom: 10px; width: 100%;">

								<%
									for (Odontologo odon : listaOdontologo) {
								%>
								<option value="<%=odon.getIDUsuario()%>"><%=odon.getApellido()%>,
									<%=odon.getNombre()%></option>
								<%
									}
								%>

						</select></td>
					</tr>
					<tr>
						<td>Horario:</td>
						<td><select name="ddlHorario" style="margin-bottom: 10px;">

								<option>09:30</option>
								<option>10:00</option>
								<option>10:30</option>
						</select></td>
					</tr>
					<tr>
						<td>Fecha:</td>
						<td><input name="txtFecha" required min="<%=LocalDateTime.now().toLocalDate().toString() %>" type="date"></td>
					</tr>
				</table>
				<br>
				<div style="text-align: center">
					<input type="submit" name="btnGuardar" value="Guardar"
						class="btn btn-default btnVerde"></input>
				</div>
			</form>

		</div>
	</div>
</body>

<script type="text/javascript">
	document.getElementById("btnCheck").addEventListener("click", () => {
		$.get("ServletPacientes?action=get&dni="+$("#dni").val(), (resp) => {
			if(resp != "null"){
				data = JSON.parse(resp);
				$("#dni").css("background-color", "#4BB543");
				$("#dni").attr("readonly", true);
				$("#nombre").val(data.nombre);
				$("#apellido").val(data.apellido);
				date = data.FechaNacimiento;
				$("#fechaNac").val(date.day+"/"+date.month+"/"+date.year);
			}else{
				$("#dni").css("background-color", "red");
				$("#dni").attr("readonly", true);
				$("#nombre").val("no existe");
				$("#apellido").val("no existe");
				$("#fechaNac").val("no existe");
			}
		})	
	})
	document.getElementById("btnReset").addEventListener("click", () => {
		$("#dni").attr("readonly", false);
		$("#dni").css("background-color", "white");
		$("#dni").val("");
		$("#nombre").val("");
		$("#apellido").val("");
		$("#fechaNac").val("");
	})
</script>
</html>