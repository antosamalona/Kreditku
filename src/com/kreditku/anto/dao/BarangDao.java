/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kreditku.anto.dao;

import com.kreditku.anto.db.KoneksiDb;
import com.kreditku.anto.model.Barang;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class BarangDao {
    private static final String QUERY_INSERT = "INSERT INTO barang(kd_brg,nm_barang,harga)VALUES(?,?,?)";
    private static final String QUERY_UPDATE = "UPDATE barang SET nm_barang=?,harga=? WHERE kd_brg=?";
    private static final String QUERY_DELETE = "DELETE FROM barang WHERE kd_brg=?";
    private static final String QUERY_GETONE = "SELECT * FROM barang WHERE kd_brg=?";
    public static final String QUERY_GETALL = "SELECT * FROM barang";
    
    private com.mysql.jdbc.Connection connection;
	
	PreparedStatement psInsert;
	PreparedStatement psUpdate;
        PreparedStatement psDelete;
	PreparedStatement psGetAll;
	PreparedStatement psGetOne;

	
	
	
	private BarangDao(){
        
        try {
            connection = (com.mysql.jdbc.Connection) KoneksiDb.connection;
            psInsert = (PreparedStatement) connection.prepareStatement(QUERY_INSERT);
            psUpdate = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
            psDelete = (PreparedStatement) connection.prepareStatement(QUERY_DELETE);
            psGetOne = (PreparedStatement) connection.prepareStatement(QUERY_GETONE);
            psGetAll = (PreparedStatement) connection.prepareStatement(QUERY_GETALL);
            
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	

        private static BarangDao barangDao = new BarangDao();
    
    public static BarangDao getBarangDao(){
        return barangDao;
    }

	public void save(Barang barang) throws SQLException {
		
	
			psInsert.setString(1, barang.getKd_brg());
			psInsert.setString(2, barang.getNm_barang());
			psInsert.setDouble(3, barang.getHarga().doubleValue());
			psInsert.executeUpdate();
		

	}
	
	public void update(Barang barang) throws SQLException {
		psUpdate.setString(1, barang.getNm_barang());
		psUpdate.setDouble(2, barang.getHarga().doubleValue());
		psUpdate.setString(3, barang.getKd_brg());
		psUpdate.executeUpdate();
		
	}
        
         public void delete(Barang barang) throws SQLException{
            psDelete.setString(1, barang.getKd_brg());
            psDelete.executeUpdate();
        }
	
	public List<Barang> getAll() {
		try {
			ResultSet rs = psGetAll.executeQuery();
			List<Barang> listBarang = new ArrayList<>();
			while(rs.next()){
				String kd_brg = rs.getString("kd_brg");
				String nm_barang = rs.getString("nm_barang");
				Double harga = rs.getDouble("harga");
				
				Barang barang = new Barang(kd_brg, nm_barang, new BigDecimal(harga));
				listBarang.add(barang);
			}
			
			return listBarang;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;

	}

	public Barang getById(String kd_brg) {
		
		try {
			psGetOne.setString(1, kd_brg);
			ResultSet rs = psGetOne.executeQuery();
			if(rs.next()){
				
				String nm_barang = rs.getString("nm_barang");
				Double harga = rs.getDouble("harga");
				
				Barang barang = new Barang(kd_brg, nm_barang, new BigDecimal(harga));
				return barang;
			}
			
		} catch (SQLException e) {
		}
		
		return null;
	}
}
