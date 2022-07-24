package application;

import java.util.Date;
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
		
		System.out.println("\n=== TESTE 4: Vendedor insert ===");
		Vendedor novoVendedor = new Vendedor(null, "Greg", "greg@gmail.com", new Date(), 4000.0, departamento);
		vendedorDAO.insert(novoVendedor);
		System.out.println("Inserido! Novo id: " + novoVendedor.getId());
		
		System.out.println("\n=== TESTE 5: Vendedor update ===");
		vendedor = vendedorDAO.findById(1);
		vendedor.setNome("Martha Waine");
		vendedorDAO.update(vendedor);
		System.out.println("Atualizado! Novos Dados: " + vendedor);
		
		DB.closeConnection();		
	}
}
