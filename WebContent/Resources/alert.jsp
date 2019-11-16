			<% if(request.getAttribute("resultado") != null){ 
				String tipo = "";
				String msg = "";
				if((boolean)request.getAttribute("resultado")){
					tipo = "success";
					msg = "Operación realizada correctamente";
				}else{
					tipo = "danger";
					msg = "Ha ocurrido un error al realizar la operación";
				}
				
			%>
			<div class="alert alert-<%= tipo %> alert-dismissible fade show text-center"
				role="alert">
				<%= msg %>
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<% } %>