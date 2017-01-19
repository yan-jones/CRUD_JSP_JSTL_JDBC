<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><c:out value="Listar instrutores" /></title>
<script type="text/javascript" src="javascript/validacao.js"> </script>
</head>
<body>
	<center>
		<h1>
			<font size="20"><c:out
					value="Listagem de Instrutores cadastrados" /></font>
		</h1>
		<c:if test="${not empty mensagemRestricao}">
			<font color="red"> <c:out value="${mensagemRestricao }" />
			</font>
		</c:if>
		<c:choose>
			<c:when test="${empty sessionScope.instrutores}">
				<h1>
					<font size="20" color="red"><c:out
							value="Não existe instrutores
						cadastrados" /></font>
				</h1>
			</c:when>
			<c:otherwise>
				<table border="1">
					<tr>
						<th><c:out value="NOME" /></th>
						<th><c:out value="MATRICULA" /></th>
						<Th><c:out value="ANO CONLUSÃO DA GRADUAÇÃO" /></Th>
					</tr>
					<c:forEach var="instrutor" items="${instrutores}">
						<tr>
							<td><center>
									<a
										href="pesquisaInstrutor?
										matricula=${instrutor.matricula}
										">${instrutor.nome
										}</a>
								</center></td>
							<td><center>
									<c:out value="${instrutor.matricula }" />
								</center></td>
							<td><center>
									<c:out value="${instrutor.anoConcGrad }" />
								</center></td>
							<td><center>
									<a onclick="confirmarExclusaoInstrutor(${instrutor.matricula})"><img
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
		<br> <a href="indexInstrutores.jsp"><c:out
				value="Clique para voltar" /></a>
	</center>
</body>
</html>