<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><c:out value="Cadastrar instrutor" /></title>
</head>
<body>
	<center>
		<h1>
			<font size="20" color="blue"><c:out
					value="Cadastro de instrutor de uma academia" /></font>
		</h1>
	</center>
	<form action="ControllerAction" method="post">
		<table>
			<tr>
				<td width="50%"><center>
						<a href="indexInstrutores.jsp"><c:out value="Instrutores" /></a>
					</center></td>
				<td><c:out value="Nome : " /></td>
				<td><input name="nome" type="text" value="${param.nome}"></td>
			</tr>
			<tr>
				<c:choose>
					<c:when test="${not empty sessionScope.instrutores}">
						<td width="50%">
							<center>
								<a href="indexAlunos.jsp"><c:out value="Alunos" /></a>
							</center>
						</td>
					</c:when>
					<c:otherwise>
						<td></td>
					</c:otherwise>
				</c:choose>
				<td><c:out value="Matricula : " /></td>
				<td><input name="matricula" type="text"
					value="${param.matricula}"></td>
			</tr>
			<tr>
				<td></td>
				<td><c:out value="Ano de conclusão da graduação : " /></td>
				<td><select name="anoConclusaoGraduacao">
						<option value="Selecione">Selecione</option>
						<c:forEach var="i" begin="1950" end="2014">
							<option value="${i}"
								${ i eq selecionado ? 
							'selected' : ''}>${i}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td height="50%"><input name="enviar" type="submit"
					value="Enviar"></td>
				<td><a href="listarInstrutores"><c:out value="Listar todos" /></a></td>
			</tr>
		</table>
	</form>
	<c:if test="${not empty errosInstrutor}">
		<font color="red"> <c:forEach var="erro"
				items="${errosInstrutor}">
				<ul>
					<li><c:out value="${erro }"></c:out></li>
				</ul>
			</c:forEach>
		</font>
	</c:if>
	<c:if test="${not empty matriculaRepetida}">
		<font color="red">
			<ul>
				<li><c:out value="${matriculaRepetida }" /></li>
			</ul>
		</font>
	</c:if>
</body>
</html>