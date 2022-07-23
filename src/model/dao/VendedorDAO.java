package model.dao;

import java.util.List;

import model.entities.Vendedor;

public interface VendedorDAO {

	public void insert(VendedorDAO obj);
	public void update(VendedorDAO obj);
	public void deleteById(Integer id);
	Vendedor findById(Integer id);
	List<Vendedor> findAll();
}
