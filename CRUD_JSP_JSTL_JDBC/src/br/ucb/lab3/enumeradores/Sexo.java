package br.ucb.lab3.enumeradores;

public enum Sexo {

	MASCULINO, FEMININO;

	public static Sexo getByFindOrdinal(Integer ordinal) {
		for (Sexo sexo : values()) {
			if (sexo.ordinal() == ordinal.intValue())
				return sexo;
		}
		return null;
	}
}
