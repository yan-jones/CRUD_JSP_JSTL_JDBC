package br.ucb.lab3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucb.lab3.beans.Aluno;
import br.ucb.lab3.factory.AlunoDAO;

public class PesquisaAlunoAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7015048015055049213L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String cpf = req.getParameter("cpf");
		AlunoDAO dao = new AlunoDAO();
		Aluno aluno = (Aluno) dao.selectWhereChave(cpf);
		HttpSession session = req.getSession();
		session.setAttribute("aluno", aluno);
		resp.sendRedirect("updateAluno.jsp");

	}
}
