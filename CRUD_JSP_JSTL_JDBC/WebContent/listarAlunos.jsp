<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><c:out value="Listar Alunos" /></title>
<script type="text/javascript" src="javascript/validacao.js"> </script>
</head>
<body>
	<center>
		<h1>
			<font size="20"><c:out value="Listagem de Alunos cadastrados" /></font>
		</h1>
		<c:choose>
			<c:when test="${empty sessionScope.alunos}">
				<h1>
					<font size="20" color="red"><c:out
							value="Não existe alunos
						cadastrados" /></font>
				</h1>
			</c:when>
			<c:otherwise>
				<table border="1">
					<tr>
						<th><c:out value="NOME" /></th>
						<th><c:out value="CPF" /></th>
						<th><c:out value="SEXO" /></th>
						<th><c:out value="INSTRUTOR" /></th>
						<th><c:out value="ALTURA" /></th>
						<th><c:out value="PESO" /></th>
					</tr>
					<c:forEach var="aluno" items="${alunos}">
						<tr>
							<td><center>
									<a
										href="pesquisaAluno?
										cpf=${aluno.cpf}
										">${aluno.nome
										}</a>
								</center></td>
							<td><center>
									<c:out value="${aluno.cpf}" />
								</center></td>
							<td><center>
									<c:out value="${aluno.sexo}" />
								</center></td>
							<td><center>
									<c:out value="${aluno.instrutor}" />
								</center></td>
							<td><center>
									<c:out value="${aluno.altura}" />
								</center></td>
							<td><center>
									<c:out value="${aluno.peso}" />
								</center></td>
							<td><center>
									<a onclick="confirmarExclusaoAluno(${aluno.cpf})"><img
										alt="Excluir" src="imagens/delete.jpg"></a>
								</center></td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
		<c:if test="${not empty mensagemExcluir}">
			<font color="red"> <c:out value="${mensagemExcluir }" />
			</font>
		</c:if>
		<br> <a href="indexAlunos.jsp"><c:out
				value="Clique para voltar" /></a>
	</center>
</body>
</html>