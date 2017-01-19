<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Academia</title>
</head>
<body>
	<center>
		<h1>
			<font size="20" color="blue"><c:out
					value="Alteração de dados do usuário"></c:out></font>
		</h1>
		<form action="updateAluno" method="post">
			<table>
				<tr>
					<td><c:out value="Nome : " /></td>
					<td><input name="nome" type="text"
						value="${sessionScope.aluno.nome}"></td>
				</tr>
				<tr>
					<td><c:out value="CPF : " /></td>
					<td><input name="cpf" type="text" disabled="disabled"
						value="${sessionScope.aluno.cpf}"> <input name="cpf"
						type="hidden" value="${sessionScope.aluno.cpf}"></td>
				</tr>
				<tr>
					<td><c:out value="Sexo:" /></td>
					<td><c:out value="Masculino" /><input name="sexo"
						type="radio" value="0"
						${sessionScope.aluno.sexo eq 
						'MASCULINO' ? 'checked' : ''}>
						<c:out value="Feminino" /><input name="sexo" type="radio"
						value="1"
						${sessionScope.aluno.sexo eq 'FEMININO' ? 
						'checked' : ''}></td>
				</tr>
				<tr>
					<td></td>
					<td><select name="instrutor">
							<option value="${sessionScope.aluno.instrutor }">
								${sessionScope.aluno.instrutor }</option>
							<c:forEach varStatus="i" var="instrutor"
								items="${sessionScope.instrutores }">
								<option value="${instrutor.nome}">${instrutor.nome}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><c:out value="Altura : " /></td>
					<td><input name="altura" type="text"
						value="${sessionScope.aluno.altura}"></td>
				</tr>
				<tr>
					<td><c:out value="Peso : " /></td>
					<td><input name="peso" type="text"
						value="${sessionScope.aluno.peso}"></td>
				</tr>
				<tr>
					<td></td>
					<td height="50%"><input name="enviar" type="submit"
						value="Enviar"></td>
					<td height="50%"><input name="cancelar" type="submit"
						value="Cancelar"></td>
				</tr>
			</table>
			<br> <br> <a href="listarAlunos"><c:out
					value="Listar todos" /></a>
		</form>
	</center>
	<c:if test="${not empty errosAluno}">
		<font color="red"> <c:forEach var="erro" items="${errosAluno}">
				<ul>
					<li><c:out value="${erro }"></c:out></li>
				</ul>
			</c:forEach>
		</font>
	</c:if>
</body>
</html>