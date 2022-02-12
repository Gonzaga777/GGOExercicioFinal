<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<title>Cadastro De Veiculos</title>
</head>
<nav class="navbar navbar-expand-lg navbar-light bg-primary ">
	<div class="container-fluid">
		<a class="navbar-brand" href="form.jsp">RaiaDrogasil</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<ul class="navbar-nav me-auto mb-2 mb-lg-0">


			<li class="nav-item"><a class="navbar-brand" href="#">Veiculos</a>
			</li>
		</ul>
	</div>
</nav>
<body>
		<!-- BEGIN FORM -->
	<div class="container col-12 col-md-4 col-lg-4 col-xl-4 shadow p-3">
		<h3 class="card-title text-center">Adicionar Veiculo</h3>
	
		<form action="ServletVeiculos" method="post">
				<c:choose>
					<c:when test="${ veiculo == null }">
					
						<div class=mb-3>
							<label class="form-label">NOME VEICULO</label>
							<input type="text" class="form-control" name="nome_veiculo" required/>
						</div>
						
						<div class=mb-3>
							<label class="form-label">MARCA</label>
							<input type="text" class="form-control" name="marca" required/>
						</div>
					
						<div class=mb-3>
							<label class="form-label">ANO</label>
							<input type="text" class="form-control" name="ano_veiculo" required/>
						</div>
						
						
						<div class="d-grid gap-2 d-md-flex justify-content-md-end">
							<button type="submit" name="option" class="btn btn-primary flex-start" value="insert">Salvar</button>
						</div>
						
					</c:when>
				
					<c:otherwise>
					
						<div class="mb-3">
							<input type="hidden" name="cod_veiculo" value="${veiculo.cod_veiculo}"/>
						</div>
						
						<div class=mb-3>
							<label class="form-label">NOME VEICULO</label>
							<input type="text" class="form-control" name="nome_veiculo" value="${veiculo.nome_veiculo}"/>
						</div>
						
						<div class="mb-3">
							<label class="form-label">MARCA</label>
							<input type="text" class="form-control" name="marca" value="${veiculo.marca}"/>
						</div>
						
						<div class="mb-3">
							<label class="form-label">ANO VEICULO</label>
							<input type="number" class="form-control" name="ano_veiculo" value="${veiculo.ano_veiculo}"/>
						</div>
						
						<div class="d-grid gap-2 d-md-flex justify-content-md-end">
							<button type="submit" name="option" class="btn btn-primary flex-start" value="update">Atualizar</button>
						</div>
						
					</c:otherwise>
				
				</c:choose>
		</form>
	</div>
	<!-- END FORM -->
</body>
</html>