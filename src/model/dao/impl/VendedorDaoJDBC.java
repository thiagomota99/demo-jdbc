package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.VendedorDAO;
import model.entities.Departamento;
import model.entities.Vendedor;

public class VendedorDaoJDBC implements VendedorDAO{
	
	private Connection connection;
	
	public VendedorDaoJDBC(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void insert(VendedorDAO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(VendedorDAO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor findById(Integer id) {
		PreparedStatement preparedStament = null;
		ResultSet resultSet = null;
		try {
			preparedStament = connection.prepareStatement(
					"SELECT seller.*, department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");
			
			preparedStament.setInt(1, id);
			resultSet = preparedStament.executeQuery();
			
			if(resultSet.next()) {
				Departamento departamento = instanciarDepartamento(resultSet);
				Vendedor vendedor = instanciarVendedor(resultSet, departamento);
				return vendedor;
			}
				
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(preparedStament);
			DB.closeResultSet(resultSet);
		}
		
		return null;
	}

	private Vendedor instanciarVendedor(ResultSet resultSet, Departamento departamento) throws SQLException {
		Vendedor vendedor = new Vendedor();
		vendedor.setId(resultSet.getInt("Id"));
		vendedor.setNome(resultSet.getString("Name"));
		vendedor.setEmail(resultSet.getString("Email"));
		vendedor.setSalarioBase(resultSet.getDouble("BaseSalary"));
		vendedor.setDataAniversario(resultSet.getDate("BirthDate"));
		vendedor.setDepartamento(departamento);
		return vendedor;
	}

	private Departamento instanciarDepartamento(ResultSet resultSet) throws SQLException {
		Departamento departamento = new Departamento();
		departamento.setId(resultSet.getInt("DepartmentId"));
		departamento.setNome(resultSet.getString("DepName"));
		return departamento;
	}

	@Override
	public List<Vendedor> findAll() {
		PreparedStatement preparedStament = null;
		ResultSet resultSet = null;
		try {
			preparedStament = connection.prepareStatement(
					"SELECT seller.*, department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "");
			
			resultSet = preparedStament.executeQuery();
			
			List<Vendedor> listaVendedor = new ArrayList<Vendedor>();
			Map<Integer, Departamento> map = new HashMap<>();
			
			while(resultSet.next()) {
				
				Departamento dep = map.get(resultSet.getInt("DepartmentId"));
				if(dep == null) {
					dep = instanciarDepartamento(resultSet);
					map.put(dep.getId(), dep);
				}
				
				Vendedor vendedor = instanciarVendedor(resultSet, dep);
				listaVendedor.add(vendedor);				
			}
			return listaVendedor;	
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(preparedStament);
			DB.closeResultSet(resultSet);
		}
	}

	@Override
	public List<Vendedor> findByDepartamento(Departamento departamento) {
		PreparedStatement preparedStament = null;
		ResultSet resultSet = null;
		try {
			preparedStament = connection.prepareStatement(
					"SELECT seller.*, department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE department.Id = ?");
			
			preparedStament.setInt(1, departamento.getId());
			resultSet = preparedStament.executeQuery();
			
			List<Vendedor> listaVendedor = new ArrayList<Vendedor>();
			Map<Integer, Departamento> map = new HashMap<>();
			
			while(resultSet.next()) {
				
				Departamento dep = map.get(resultSet.getInt("DepartmentId"));
				if(dep == null) {
					dep = instanciarDepartamento(resultSet);
					map.put(dep.getId(), dep);
				}
				
				Vendedor vendedor = instanciarVendedor(resultSet, dep);
				listaVendedor.add(vendedor);				
			}
			return listaVendedor;	
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(preparedStament);
			DB.closeResultSet(resultSet);
		}
	}	
}
