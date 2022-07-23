package model.dao;

import db.DB;
import model.dao.impl.VendedorDaoJDBC;

public class FabricaDAO {
	
	public static VendedorDAO createVendedorDao() {
		return new VendedorDaoJDBC(DB.getConnection());
	}
}
