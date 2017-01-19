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
					value="Cadastro de usuário de uma academia"></c:out></font>
		</h1>
	</center>
	<form action="ControllerAlunoAction" method="post">
		<table>
			<tr>
				<td width="70%"><center>
						<a href="indexInstrutores.jsp"><c:out value="Instrutores" /></a>
					</center></td>
				<td><c:out value="Nome : " /></td>
				<td><input name="nome" type="text" value="${param.nome}"></td>
			</tr>
			<tr>
				<td width="50%">
					<center>
						<a href="indexAlunos.jsp"><c:out value="Alunos" /></a>
					</center>
				</td>
				<td><c:out value="CPF : " /></td>
				<td><input name="cpf" type="text" value="${param.cpf}"></td>
			</tr>
			<tr>
				<td></td>
				<td><c:out value="Sexo:" /></td>
				<td><c:out value="Masculino" /><input name="sexo" type="radio"
					value="0" ${param.sexo eq 0 ? 'checked' : ''}> <c:out
						value="Feminino" /><input name="sexo" type="radio" value="1"
					${param.sexo eq 1 ? 'checked' : ''}></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><select name="instrutor">
						<c:forEach varStatus="i" var="instrutor"
							items="${sessionScope.instrutores }">
							<option value="${instrutor.nome}"
								${instrutor.nome eq selecionado ? 'selected' : ''}>${instrutor.nome}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td><c:out value="Altura : " /></td>
				<td><input name="altura" type="text" value="${param.altura}"></td>
			</tr>
			<tr>
				<td></td>
				<td><c:out value="Peso : " /></td>
				<td><input name="peso" type="text" value="${param.peso}"></td>
			</tr>
			<tr>
				<td></td>
				<td height="50%"><input name="enviar" type="submit"
					value="Enviar"></td>
				<td><a href="listarAlunos"><c:out value="Listar todos" /></a></td>
			</tr>
		</table>
	</form>
	<c:if test="${not empty errosAluno}">
		<font color="red"> <c:forEach var="erro" items="${errosAluno}">
				<ul>
					<li><c:out value="${erro }"></c:out></li>
				</ul>
			</c:forEach>
		</font>
	</c:if>
	<c:if test="${not empty cpfRepetido}">
		<font color="red">
			<ul>
				<li><c:out value="${cpfRepetido }" /></li>
			</ul>
		</font>
	</c:if>
</body>
</html>