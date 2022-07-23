package model.dao;

import java.util.List;

public interface Vendedor {

	public void insert(Vendedor obj);
	public void update(Vendedor obj);
	public void deleteById(Integer id);
	Vendedor findById(Integer id);
	List<Vendedor> findAll();
}
