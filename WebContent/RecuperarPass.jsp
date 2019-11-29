<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="masterInclude.html"></jsp:include>
<link rel="stylesheet" href="Resources/css/stylesheetMain.css"> 
<title>Recuperar Contraseña</title>
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
			<form method="post" action="ServletUsuarios" class="box">
				<div class="subtitular mb-4 mt-0"> <h6> Recuperar Contraseña </h6> </div>
					<table>
					<tr>
						<td>
							Email:
						</td>
						<td>
							<input type="email" required name="txtEmail">
						</td>
					</tr>
					<tr>
						<td>
							DNI:
						</td>
						<td>
							<input type="number" required name="txtDni">
						</td>
					</tr>
					</table>
					<br>
					<div style="text-align: center">
						<input type="submit" class="btn btnVerde" name="btnPass" value="Mostrar" name="btnPass"></input><br><br>
					<div><h5><%if(request.getAttribute("Pass")!= null)
						{
						 	String pass = request.getAttribute("Pass").toString();
						 	if(pass.equals("No existe el usuario")) out.println(pass);
						 	else out.println("La contraseña es: "+pass);
						}
						 	
					 	%>
					 	</h5></div></div>
				</form>
			
		</div>
	
	</div>

</body>
</html>