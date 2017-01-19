package br.ucb.lab3.interfaces;

import java.util.List;

public interface DAO<T> {

	public void insert(T object);

	public List<T> select();

	public Object selectWhereChave(String str);
	
	public Object selectWhereString(String str);

	public void update(T object, String str);

	public void delete(String str);
}
