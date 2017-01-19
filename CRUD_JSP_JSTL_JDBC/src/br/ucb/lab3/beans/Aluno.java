package br.ucb.lab3.beans;

import br.ucb.lab3.enumeradores.Sexo;

public class Aluno {

	private String nome;
	private String cpf;
	private Sexo sexo;
	private String instrutor;
	private Double altura;
	private Double peso;

	public Aluno() {
	}

	public Aluno(String nome, String cpf, Sexo sexo, String instrutor,
			Double altura, Double peso) {
		setNome(nome);
		setCpf(cpf);
		setSexo(sexo);
		setInstrutor(instrutor);
		setAltura(altura);
		setPeso(peso);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(String instrutor) {
		this.instrutor = instrutor;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Aluno other = (Aluno) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno = Nome: " + getNome() + ", Cpf: " + getCpf() + ", Sexo: "
				+ getSexo().name() + ", Instrutor: " + getInstrutor()
				+ ", Altura: " + getAltura() + ", Peso: " + getPeso();
	}

}
