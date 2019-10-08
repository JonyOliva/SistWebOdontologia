<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="masterInclude.html"></jsp:include>
<title>Inicio</title>
</head>

<style>
	body{
	    margin: 0 auto 0 auto;
	    width: 100%;
	    background: #ebf9f6;
	}
	input{
	    border-radius: 4px;
	    text-align: center;
	}
	.box{
		background: white;
	    width:300px;
	    border-radius:6px;
	    margin: 3% auto 0 auto;
	    padding: 20px;
	    border: #9de2d4 1px solid; 
	}
</style>

<body>
	<div class="container">
	
		<div>
			<form action="adminTurnos.jsp" class="box">
				<table>
				<tr>
					<td>
						Email:
					</td>
					<td>
						<input type="email">
					</td>
				</tr>
				<tr>
					<td>
						Contrase�a:
					</td>
					<td>
						<input type="password">
					</td>
				</tr>
				</table>
				<br>
				<div style="text-align: center">
					<button > Iniciar sesi�n</button>
				</div >
			</form>
		</div>
	
	</div>
</body>
</html>