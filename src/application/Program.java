package application;

import java.util.ArrayList;
import java.util.List;

import db.DB;
import model.dao.FabricaDAO;
import model.dao.VendedorDAO;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {
		
		VendedorDAO vendedorDAO = FabricaDAO.createVendedorDao();
		System.out.println("=== TESTE 1: Vendedor findById ===");
		Vendedor vendedor = vendedorDAO.findById(5);
		System.out.println(vendedor);
		
		
		System.out.println("\n=== TESTE 2: Vendedor findByDepartamento ===");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> listVendedor = vendedorDAO.findByDepartamento(departamento); 
		for(Vendedor item : listVendedor)
			System.out.println(item);
		
		System.out.println("\n=== TESTE 3: Vendedor findAll ===");
		listVendedor = vendedorDAO.findAll(); 
		for(Vendedor item : listVendedor)
			System.out.println(item);
		
		DB.closeConnection();		
	}
}
