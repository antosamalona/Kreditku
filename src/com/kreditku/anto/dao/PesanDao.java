package com.kreditku.anto.dao;

import com.kreditku.anto.model.Pesan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PesanDao {
    private static final String SQL_INSERT_PESAN
            = "insert into pesan (id, id_customer, id_barang, laba) values (?,?,?,?)";
    
    private Connection koneksiDb;
    
    public void simpan(Pesan p){
        try {
            // barang dan customer ambil IDnya aja
            String id = UUID.randomUUID().toString();
            p.setId(id);
            
            PreparedStatement ps = koneksiDb.prepareStatement(SQL_INSERT_PESAN);
            
            ps.setString(1, id);
            ps.setString(2, p.getCustomer().getId());
            ps.setString(3, p.getBarang().getId());
            ps.setBigDecimal(4, p.getLaba());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(PesanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
