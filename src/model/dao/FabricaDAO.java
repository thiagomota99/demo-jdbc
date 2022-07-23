package model.dao;

import model.dao.impl.VendedorDaoJDBC;

public class FabricaDAO {
	
	public static VendedorDAO createVendedorDao() {
		return new VendedorDaoJDBC();
	}
}
