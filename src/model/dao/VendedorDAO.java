package model.dao;

import java.util.List;

public interface VendedorDAO {

	public void insert(VendedorDAO obj);
	public void update(VendedorDAO obj);
	public void deleteById(Integer id);
	VendedorDAO findById(Integer id);
	List<VendedorDAO> findAll();
}
