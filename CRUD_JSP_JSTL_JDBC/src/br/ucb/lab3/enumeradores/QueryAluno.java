package br.ucb.lab3.enumeradores;

public enum QueryAluno {
	INSERT_ALUNO("INSERT INTO TB_ALUNO VALUES(?,?,?,?,?,?)"),
	SELECT_ALUNO("SELECT * FROM TB_ALUNO"),
	SELECT_WHERE_CPF_ALUNO("SELECT * FROM TB_ALUNO WHERE CPF = ?"),
	SELECT_WHERE_INSTRUTOR_ALUNO("SELECT * FROM TB_ALUNO WHERE INSTRUTOR = ?"),
	DELETE_ALUNO("DELETE FROM TB_ALUNO WHERE CPF = ?"),
	UPDATE_ALUNO("UPDATE TB_ALUNO SET NOME = ?, CPF = ?, SEXO = ?, INSTRUTOR = ?, ALTURA = ?, PESO = ? WHERE CPF = ?");	
	private String query;

	private QueryAluno(String query) {
		setQuery(query);
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
}
