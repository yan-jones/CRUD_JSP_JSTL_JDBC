package br.ucb.lab3.beans;

public class Instrutor {

	// instrutor tem nome, matrícula e ano de conclusão do curso de graduação.
	private String nome;
	private String matricula;
	private Integer anoConcGrad;

	public Instrutor() {
	}

	public Instrutor(String nome, String matricula, Integer anoConcGrad) {
		setNome(nome);
		setMatricula(matricula);
		setAnoConcGrad(anoConcGrad);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Integer getAnoConcGrad() {
		return anoConcGrad;
	}

	public void setAnoConcGrad(Integer anoConcGrad) {
		this.anoConcGrad = anoConcGrad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Instrutor other = (Instrutor) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Instrutores = Nome: " + getNome() + ", Matricula: "
				+ getMatricula() + ", Ano de conlusao da graduacao: "
				+ getAnoConcGrad();
	}

}
