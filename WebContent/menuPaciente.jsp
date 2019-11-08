<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@page import="Entidad.Paciente"%>
<%@page import="Entidad.Tratamiento"%>
<%@page import="Entidad.Consulta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="masterInclude.html"></jsp:include>
<title>Ficha paciente</title>
<link rel="stylesheet" href="Resources/css/stylesheetMain.css">
</head>
<body>
	<jsp:include page="masterMenuOdont.html"></jsp:include>
	<%
		Paciente paciente = null;
		List<Tratamiento> listTrats = null;
		List<Consulta> listCons = null;
		if (request.getAttribute("paciente") != null) {
			paciente = (Paciente) request.getAttribute("paciente");
			listTrats = (ArrayList<Tratamiento>)request.getAttribute("tratamientos");
			listCons = (ArrayList<Consulta>)request.getAttribute("consultas");
		} else {
			response.sendRedirect("ServletPacientes");
		}
	%>
	<div class="container mt-3">
		<h5 class="titular">Ficha paciente</h5>
		<br />
		<div class="row justify-content-center" style="text-align: center;">
			<div class="rounded col-8" style="border: #9de2d4 1px solid;">
				<div class="subtitular">Datos del paciente</div>
				<table class="table table-sm mt-3">
					<tr>
						<th>Nombre:</th>
						<td><%=paciente.getNombre()%></td>
					</tr>
					<tr>
						<td>Apellido:</td>
						<td><%=paciente.getApellido()%></td>
					</tr>
					<tr>
						<td>DNI:</td>
						<td><%=paciente.getDni()%></td>
					</tr>
					<tr>
						<td>Teléfono:</td>
						<td><%=paciente.getTelefono()%></td>
					</tr>
					<tr>
						<td>Domicilio:</td>
						<td><%=paciente.getDomicilio()%></td>
					</tr>
					<tr>
						<td>Fecha de nacimiento:</td>
						<td><%=paciente.getFechaNacimiento()%></td>
					</tr>
					<%
						if (paciente.hayExtra()) {
					%>
					<tr>
						<td>Información extra:</td>
						<td><%=paciente.getInfoExtra()%></td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
		</div>
		<br />
		<div>
			<input type="hidden" id="idpaciente"
				value="<%=paciente.getIDPaciente()%>">
			<jsp:include page="odontograma.html"></jsp:include>
		</div>
		<br>
		<div class="row mt-3" style="text-align: center;">
			<div class="col-7 rounded" style="border: #9de2d4 1px solid;">
				<div class="subtitular">Historial clínico</div>
				<table class="table mt-3">
					<tr>
						<th>Turno</th>
						<th>Odontologo</th>
						<th>Tratamiento</th>
						<th>Fecha</th>
						<th>Detalle</th>
					</tr>
					<!-- <tr>
						<td>Pepito</td>
						<td>Conducto</td>
						<td>06/10/2019</td>
						<td><button class="btn btn-outline-primary btn-sm">Ver detalle</button></td>
					</tr> -->
					<%
						for(Consulta con : listCons){
							String det = "";
							if(con.getAnotacion() != null)
								det += "<b>Anotacion</b></br>"+con.getAnotacion()+"</br></br>";
							det += "<b>Piezas</b></br>";
							for(String p :con.getPiezasArregladas()){
								det += p+"</br>";
							}
					%>
					<input type="hidden" id="<%= con.getIDTurno()+99 %>" value="<%= det %>">
					<tr>
						<td><%= con.getIDTurno() %></td>
						<td><%= con.getNombreOdontologo() %></td>
						<td><%= con.getIdTratamiento() %></td>
						<td><%= con.getFecha() %></td>
						<td><button onclick="verDetalles(<%= con.getIDTurno()+99 %>)" class="btn btn-outline-primary btn-sm">Ver detalle</button></td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
			<div class="col-5 rounded" style="border: #9de2d4 1px solid;">
				<div class="subtitular">Registrar nueva consulta</div>
				<form method="POST" action="ServletHistoriales">
					<table class="table mt-3">
						<tr>
							<th>Tratamiento</th>
							<th>Anotacion extra:</th>
						</tr>
						<tr>
							<td><select name="Tratamiento">
									<%
										for(Tratamiento trat : listTrats){
									%>
									<option value="<%= trat.getNombreID() %>"><%= trat.getNombreID() %></option>
									<%
										}
									%>
									
							</select></td>
							<td><textarea name="Anotacion" style="width: 100%" rows="1"></textarea></td>
						</tr>
					</table>
				</form>
				<a class="btn btn-success m-2" href="#">Guardar consulta</a>
			</div>

		</div>
		<br> <br>
		
<div class="modal fade" id="detModal" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header ">
        <h6 class="modal-title col-11 text-center" id="tModal"></h6>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p id=detContent> </p>
      </div>
    </div>
  </div>
</div>
		
	</div>
	<script type="text/javascript">
		function verDetalles(id){
			//console.log(id + " " + $("#h"+id).val())
			$("#detContent").html($("#"+id).val());
			$("#tModal").html("Arreglos hechos en el turno "+(id-99));
			$("#detModal").modal("show");
		}
	</script>
</body>
</html>