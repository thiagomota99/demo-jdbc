package application;

import model.dao.FabricaDAO;
import model.dao.VendedorDAO;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {
		
		VendedorDAO vendedorDAO = FabricaDAO.createVendedorDao();
		Vendedor vendedor = vendedorDAO.findById(5);
		
		System.out.println(vendedor);
	}
}
