package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
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
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM Department WHERE Id = ?");
			preparedStatement.setInt(1, id);
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				Departamento dep = new Departamento(resultSet.getInt("Id"), resultSet.getString("Name"));
				return dep;
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(preparedStatement);
			DB.closeResultSet(resultSet);
		}
		return null;
	}

	@Override
	public List<Departamento> findAll() {
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM Department");
			
			resultSet = preparedStatement.executeQuery();
			
			List<Departamento> lista = new ArrayList<Departamento>();
			while(resultSet.next()) {
				lista.add(new Departamento(resultSet.getInt("Id"), resultSet.getString("Name")));				
			}
			return lista;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(preparedStatement);
			DB.closeResultSet(resultSet);
		}
	}

}
