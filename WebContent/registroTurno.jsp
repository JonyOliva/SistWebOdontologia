<%@page import="java.time.LocalDate"%>
<%@page import="NegocioImpl.GestionHorarios"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="NegocioImpl.GestionOdontologos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Entidad.Odontologo"%>
<%@page import="Entidad.HorarioOdonto"%>
<%@page import="Entidad.Paciente"%>
<%@page import="Entidad.Turno"%>
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

	<%!
		
		List<Odontologo> listaOdontologo;
		GestionOdontologos go = new GestionOdontologos();
		Turno tur = null;
	%>
	<%
		listaOdontologo = go.getAll();
		Paciente pac = (Paciente) request.getAttribute("paciente");
		tur = (Turno)request.getAttribute("turnomod");
	%>

	<div class="container mt-3">
		<div>
			<div>
				<h5 class="titular">Turno</h5>
			</div>

			<form class="box" method="post" action="ServletTurnos">
			
			
			<%	
				if(tur != null)
				{
			%>		
					<input type="hidden" name="operacion" value="modificar">
					<input type="hidden" name="idtu" value="<%=tur.getIDTurno() %>">
			<%
				}else{
					out.println("<input type=\"hidden\" name=\"operacion\" value=\"facuselacome\">");
				}
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
						<td><input id="dni" name="txtDnipaciente" value="<%out.print(request.getAttribute("dnipac")); %>" 
								type="number" required></td>
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
						<td><select onchange="cargarHorarios()" id="ddlOdontologo" name="ddlOdontologo" style="margin-bottom: 10px; width: 100%;">

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
						<td>Fecha:</td>
						<td><input id="txtFecha" name="txtFecha" onchange="cargarHorarios()" value="<%= LocalDate.now() %>" required min="<%=LocalDate.now() %>" type="date"></td>
					</tr>
					<tr>
						<td>Horario:</td>
						<td><select name="ddlHorario" id="ddlHorario" style="margin-bottom: 10px;">
							<option value="null"> Seleccione hora</option>
						</select></td>
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
	function cargarHorarios(){
		var dropOdont = document.getElementById("ddlOdontologo");
		var odont = dropOdont.options[dropOdont.selectedIndex].value;
		console.log(odont)
		console.log($('#txtFecha').val())
		
		$.ajax({
			type: "GET",
			url: "ServletTurnos",
			data: { idodontologo: odont, fecha: $('#txtFecha').val()},
			success: (resp) => {
				let data = JSON.parse(resp);
				rellenarddl(data);
			}
		});
	}
	
	function rellenarddl(data){
		$('#ddlHorario').empty();
		$('#ddlHorario').append('<option value="null">Seleccione hora </option>'); 
		for (var i = 0; i < data.length; i++) {
			let min = data[i].HoraInicio.minute;
			if(data[i].HoraInicio.minute == "0")
				min = "00";
			let hor = data[i].HoraInicio.hour +':'+ min;
			$('#ddlHorario').append('<option value='+hor+'> '+hor+' </option>'); 
		}
	}
	
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