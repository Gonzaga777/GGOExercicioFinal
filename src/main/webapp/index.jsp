<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<title>Insert title here</title>
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


			<li class="nav-item"><a class="navbar-brand" href="index.jsp">Veiculos</a>
			</li>
		</ul>
	</div>
</nav>
<body>
	<br>
	<h4 class="text-center bg-primary">LISTA DE VEICULOS</h4>
	<br>
	<br>
	<div class="container">
		<form action="ServletVeiculos" method="post">
			<button type="submit" class="btn btn-primary" name="option"
				value="insertForm">Adicionar Veiculo</button>
		</form>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th># Id</th>
					<th>Nome Veiculo</th>
					<th>Marca</th>
					<th>Ano Veiculo</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="veiculo" items="${listVeic}">
					<tr>
						<form action="ServletVeiculos" method="post">
							<td><c:out value="${veiculo.cod_veiculo}" /> <input type="hidden"
								name="cod_veiculo" value="${veiculo.cod_veiculo}" /></td>
							<td><c:out value="${veiculo.nome_veiculo}" /></td>
							<td><c:out value="${veiculo.marca}" /></td>
							<td><c:out value="${veiculo.ano_veiculo}" /></td>
							<td><button class="btn btn-primary" type="submit"
									name="option" value="delete">Deletar</button>
								<button class="btn btn-primary" type="submit" name="option"
									value="updateForm">Atualizar</button></td>
						</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>