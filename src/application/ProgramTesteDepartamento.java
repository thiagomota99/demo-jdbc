package application;


import db.DB;
import model.dao.DepartamentoDAO;
import model.dao.FabricaDAO;
import model.entities.Departamento;

public class ProgramTesteDepartamento {

	public static void main(String[] args) {
		
		DepartamentoDAO departamentoDAO = FabricaDAO.createDepartamentoDao();
		System.out.println("=== TESTE 1: Departamento findById ===");
		Departamento departamento = departamentoDAO.findById(1);
		System.out.println(departamento);
		
		DB.closeConnection();
	}

}
