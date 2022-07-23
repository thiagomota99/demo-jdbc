package application;

import java.util.Date;

import model.dao.FabricaDAO;
import model.dao.VendedorDAO;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {
		Departamento departamento = new Departamento(1, "Books");
		
		Vendedor vendedor = new Vendedor(21, "Bob", "bob@gmail.com", new Date(), 3000.0, departamento);
		
		VendedorDAO vendedorDAO = FabricaDAO.createVendedorDao();
		
		System.out.println(vendedor);
	}
}
