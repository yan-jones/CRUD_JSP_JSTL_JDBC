<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alteracao de dados</title>
</head>
<body>
	<center>
		<h1>
			<font size="20"><c:out value="Alteração de dados do instrutor" /></font>
		</h1>
		<form action="updateInstrutor" method="post">
			<table>
				<tr>
					<td></td>
					<td><c:out value="Nome : " /></td>
					<td><input name="nome" type="text"
						value="${sessionScope.instrutor.nome}"></td>
				</tr>
				<tr>
					<td></td>
					<td><c:out value="Matricula : " /></td>
					<td><input name="matriculaViewUsuario" type="text"
						disabled="disabled" value="${sessionScope.instrutor.matricula}">
						<input name="matricula" type="hidden"
						value="${sessionScope.instrutor.matricula}"></td>
				</tr>
				<tr>
					<td></td>
					<td><c:out value="Ano de conclusão da graduação : " /></td>
					<td><select name="anoConclusaoGraduacao">
							<option value="${sessionScope.instrutor.anoConcGrad }">
								${sessionScope.instrutor.anoConcGrad }</option>
							<c:forEach var="i" begin="1950" end="2014">
								<option value="${i }"
									${ i eq selecionado ? 
									'selected' : ''}>${i}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td></td>
					<td height="50%"><input name="enviar" type="submit"
						value="Enviar"></td>
					<td><input name="cancelar" type="submit" value="Cancelar"></td>
				</tr>
			</table>
			<br> <br> <a href="listarInstrutores"><c:out
					value="Listar todos" /></a>
		</form>
	</center>
	<c:if test="${not empty errosInstrutor}">
		<font color="red"> <c:forEach var="erro"
				items="${errosInstrutor}">
				<ul>
					<li><c:out value="${erro }"></c:out></li>
				</ul>
			</c:forEach>
		</font>
	</c:if>
</body>
</html>