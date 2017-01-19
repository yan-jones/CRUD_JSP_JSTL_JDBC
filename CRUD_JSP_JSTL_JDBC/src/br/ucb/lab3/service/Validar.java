package br.ucb.lab3.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.ucb.lab3.beans.Aluno;
import br.ucb.lab3.beans.Instrutor;
import br.ucb.lab3.factory.AlunoDAO;
import br.ucb.lab3.factory.InstrutorDAO;

public class Validar {

	public static ArrayList<String> validaFormInstrutor(HttpServletRequest req)
			throws ServletException, IOException {
		ArrayList<String> erros = new ArrayList<String>();

		String nome = req.getParameter("nome");
		if (nome.isEmpty() || nome == null)
			erros.add("Nome não pode ser vazio");
		String matricula = req.getParameter("matricula");
		if (matricula.isEmpty() || matricula == null)
			erros.add("Matricula não pode ser vazio");
		else {
			try {
				Integer matriculaInt = new Integer(matricula);
				if (matriculaInt < 1)
					erros.add("Matricula não pode ser menor que 1");
			} catch (NumberFormatException e) {
				erros.add("A matricula tem quer ser numerico!");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		if (matricula.length() != 8)
			erros.add("Matricula tem que ter 8 digitos");
		String anoConcGrad = (req.getParameter("anoConclusaoGraduacao"));
		if (anoConcGrad.equalsIgnoreCase("Selecione"))
			erros.add("Selecione algum ano de conclusão da gradução");
		return erros;
	}

	public static String validaMatriculaRepetida(HttpServletRequest req)
			throws ServletException, IOException {
		String matricula = req.getParameter("matricula");
		InstrutorDAO dao = new InstrutorDAO();
		Instrutor instrutorBase = (Instrutor) dao.selectWhereChave(matricula);
		if (instrutorBase.getMatricula() != null) {
			if (matricula.toLowerCase().contains(
					instrutorBase.getMatricula().toLowerCase())) {
				String erro = "Matricula ja cadastrada!!";
				return erro;
			}
		}
		return null;

	}

	public static ArrayList<String> validaFormAluno(HttpServletRequest req)
			throws ServletException, IOException {
		ArrayList<String> erros = new ArrayList<String>();
		String nome = req.getParameter("nome");
		if (nome.isEmpty() || nome == null)
			erros.add("Nome não pode ser vazio");
		String cpf = req.getParameter("cpf");
		if (cpf.isEmpty() || cpf == null)
			erros.add("CPF não pode ser vazio");
		String sexo = req.getParameter("sexo");
		if (sexo == null)
			erros.add("Selecione um tipo de sexo");
		String alturaString = req.getParameter("altura");
		if (alturaString.isEmpty() || alturaString == null)
			erros.add("Altura não pode ser vazio");
		else {
			try {
				double altura = new Double(alturaString);
				if (altura < 1 || altura > 3)
					erros.add("Altura não pode ser menor que 0,01 ou maior que 3,00");
			} catch (NumberFormatException e) {
				erros.add("Altura tem quer ser numerico");
				erros.add("Utilizar (.) como separador");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		String pesoString = req.getParameter("peso");
		if (pesoString.isEmpty() || pesoString == null)
			erros.add("Peso não pode ser vazio");
		else {
			try {
				double peso = new Double(pesoString);
				if (peso < 1 || peso > 800)
					erros.add("O peso não pode ser menor 0,001 ou maior que 800,000");
			} catch (NumberFormatException e) {
				erros.add("Peso tem quer ser numerico");
				erros.add("Utilizar (.) como separador");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return erros;
	}

	public static String validaCpfRepetido(HttpServletRequest req)
			throws ServletException, IOException {
		String cpf = req.getParameter("cpf");
		AlunoDAO dao = new AlunoDAO();
		Aluno alunoBase = (Aluno) dao.selectWhereChave(cpf);
		if (alunoBase.getCpf() != null) {
			if (cpf.toLowerCase().contains(alunoBase.getCpf().toLowerCase())) {
				String erro = "Matricula ja cadastrada!!";
				return erro;
			}
		}
		return null;

	}

	public static boolean temAluno(String nome) {
		AlunoDAO dao = new AlunoDAO();
		Aluno aluno = (Aluno) dao.selectWhereString(nome);
		if (aluno != null && aluno.getInstrutor() != null) {
			if (aluno.getInstrutor().equalsIgnoreCase(nome))
				return true;
		}
		return false;
	}
}
