package br.ucb.lab3.enumeradores;

public enum QueryInstrutor {
	INSERT_INSTRUTOR("INSERT INTO TB_INSTRUTOR VALUES(?,?,?)"),
	SELECT_INSTRUTOR("SELECT * FROM TB_INSTRUTOR"),
	SELECT_WHERE_INSTRUTOR("SELECT * FROM TB_INSTRUTOR WHERE MATRICULA = ?"),
	DELETE_INSTRUTOR("DELETE FROM TB_INSTRUTOR WHERE MATRICULA = ?"),
	UPDATE_INSTRUTOR("UPDATE TB_INSTRUTOR SET NOME = ?, MATRICULA = ?, ANO_CONCLUSAO_GRADUACAO = ? WHERE MATRICULA = ?");
	
	private String query;

	private QueryInstrutor(String query) {
		setQuery(query);
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
}
