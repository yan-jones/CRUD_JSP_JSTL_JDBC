package br.ucb.lab3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucb.lab3.beans.Aluno;
import br.ucb.lab3.enumeradores.Sexo;
import br.ucb.lab3.factory.AlunoDAO;

public class CadastrarAlunoAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8488424805087099384L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Aluno aluno = new Aluno(req.getParameter("nome"),
				req.getParameter("cpf"), Sexo.getByFindOrdinal(Integer
						.parseInt(req.getParameter("sexo"))),
				req.getParameter("instrutor"), Double.parseDouble(req
						.getParameter("altura")), Double.parseDouble(req
						.getParameter("peso")));
		AlunoDAO dao = new AlunoDAO();
		dao.insert(aluno);
		HttpSession session = req.getSession();
		session.setAttribute("aluno", aluno);
		resp.sendRedirect("listarAlunos");
	}
}
