package br.ucb.lab3.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucb.lab3.beans.Aluno;
import br.ucb.lab3.factory.AlunoDAO;

public class ListarAlunosAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -12378281043134036L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AlunoDAO dao = new AlunoDAO();
		List<Aluno> alunos = dao.select();
		HttpSession session = req.getSession();
		session.setAttribute("alunos", alunos);
		req.getRequestDispatcher("listarAlunos.jsp").forward(req, resp);
	}
}
