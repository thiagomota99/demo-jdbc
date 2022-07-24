package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.dao.DepartamentoDAO;
import model.entities.Departamento;

public class DepartamentoDaoJDBC implements DepartamentoDAO{
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public DepartamentoDaoJDBC(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void insert(Departamento obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Departamento obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Departamento findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Departamento> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
