/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kreditku.anto.dao;

import com.kreditku.anto.db.KoneksiDb;
import com.kreditku.anto.model.Customer;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antosamalona
 */
public class CustomerDao {
    private static final String QUERY_INSERT = "INSERT INTO pelanggan(kd_pelanggan,nama,alamat)VALUES(?,?,?)";
    private static final String QUERY_UPDATE = "UPDATE pelanggan SET nama=?,alamat=? WHERE kd_pelanggan=?";
    private static final String QUERY_DELETE = "DELETE FROM pelanggan WHERE kd_pelanggan=?";
    private static final String QUERY_GETONE = "SELECT * FROM pelanggan WHERE kd_pelanggan=?";
    public static final String QUERY_GETALL = "SELECT * FROM pelanggan";
    
        
    private Connection connection;    
    
    

//    private static final String url = "jdbc:mysql://localhost/dbku";
//    private static final String user = "root";
//    private static final String password = "n4kk3 j13";
	
	PreparedStatement psInsert;
	PreparedStatement psUpdate;
        PreparedStatement psDelete;
	PreparedStatement psGetAll;
	PreparedStatement psGetOne;

	
	
	
	private CustomerDao(){
        
        try {
            //Connection connection = (Connection) DriverManager.getConnection(url, user, password);
             connection = (Connection) KoneksiDb.connection;
            psInsert = (PreparedStatement) connection.prepareStatement(QUERY_INSERT);
            psUpdate = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
            psDelete = (PreparedStatement) connection.prepareStatement(QUERY_DELETE);
            psGetOne = (PreparedStatement) connection.prepareStatement(QUERY_GETONE);
            psGetAll = (PreparedStatement) connection.prepareStatement(QUERY_GETALL);
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	

        private static CustomerDao customerdao = new CustomerDao();
    
    public static CustomerDao getCustomerDao(){
        return customerdao;
    }

	public void save(Customer customer) throws SQLException {
		
	
			psInsert.setString(1, customer.getKd_pelanggan());
			psInsert.setString(2, customer.getNama());
			psInsert.setString(3, customer.getAlamat());
			psInsert.executeUpdate();
		

	}
	
	public void update(Customer customer) throws SQLException {
		psUpdate.setString(1, customer.getNama());
		psUpdate.setString(2, customer.getAlamat());
		psUpdate.setString(3, customer.getKd_pelanggan());
		psUpdate.executeUpdate();
		
	}
        
        public void delete(Customer customer) throws SQLException{
            psDelete.setString(1, customer.getKd_pelanggan());
            psDelete.executeUpdate();
        }
	
	public List<Customer> getAll() {
		try {
			ResultSet rs = psGetAll.executeQuery();
			List<Customer> listCustomer = new ArrayList<>();
			while(rs.next()){
				String kd_pelanggan = rs.getString("kd_pelanggan");
				String nama = rs.getString("nama");
				String alamat = rs.getString("alamat");
				
				Customer c = new Customer(kd_pelanggan, nama, alamat);
				listCustomer.add(c);
			}
			
			return listCustomer;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;

	}

	public Customer getById(String kd_pelanggan) {
		
		try {
			psGetOne.setString(1, kd_pelanggan);
			ResultSet rs = psGetOne.executeQuery();
			if(rs.next()){
				
				String nama = rs.getString("nama");
				String alamat = rs.getString("alamat");
				
				Customer c = new Customer(kd_pelanggan, nama, alamat);
				return c;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
    
}
