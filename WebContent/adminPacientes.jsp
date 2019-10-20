<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="masterInclude.html"></jsp:include>
<title>Pacientes</title>
<link rel="stylesheet" href="Resources/css/tables.css">
<link rel="stylesheet" href="Resources/css/stylesheetMain.css">
</head>
<body>
	<jsp:include page="masterMenuAdmin.html"></jsp:include>

	<div class="container mt-3">
	
		<div>
			<div>
				<h5 class="titular">
					Men� Pacientes
					</h5>
			</div>
			<br>
			<div>
				<div class="row" style="margin-bottom: 10px;">
				<div class="col-6">Buscar: <input type="text"></div>
					<div class="col-6" style="text-align:right;"><a href="fichaPaciente.jsp" class="btn btn-primary">Agregar
					nuevo paciente</a></div>
				</div>
			</div>
			<table border=1>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>DNI</th>
					<th>Tel�fono</th>
					<th>Fecha de nacimiento</th>
					<th>Domicilio</th>
					<th>Extra</th>
					<th>Acciones</th>
				</tr>
				<tr>
					<td>Claudio</td>
					<td>Fernandez</td>
					<td>20326495</td>
					<td>116582432</td>
					<td>07/05/1962</td>
					<td>Calle 123</td>
					<td></td>
					<td style="text-align: center;">
						<a href="fichaPaciente.jsp" class="btn btn-primary btn-sm">Modificar</a>
						<a href="#" class="btn btn-primary btn-sm">Eliminar</a>
					</td>
				</tr>
				<tr>
						<td>Jorge</td>
						<td>Gomez</td>
						<td>56213024</td>
						<td>1163548712</td>
						<td>22/08/1970</td>
						<td>Calle 654</td>
						<td></td>
						<td style="text-align: center;">
							<a href="fichaPaciente.jsp" class="btn btn-primary btn-sm">Modificar</a>
							<a href="#" class="btn btn-primary btn-sm">Eliminar</a>
						</td>
					</tr>
			</table>
		</div>

	</div>

</body>
</html>