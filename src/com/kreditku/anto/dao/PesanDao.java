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
            = "insert into tb_pesan (id_pesan, kd_pelanggan, kd_brg, laba, lm_kredit, krd_perbulan) values (?,?,?,?,?,?)";
    
    private Connection koneksiDb;
    
    public void simpan(Pesan p){
        try {
            // barang dan customer ambil IDnya aja
            String id = UUID.randomUUID().toString();
            p.setId(id);
            
            PreparedStatement ps = koneksiDb.prepareStatement(SQL_INSERT_PESAN);
            
            ps.setString(1, id);
            ps.setString(2, p.getCustomer().getKd_pelanggan());
            ps.setString(3, p.getBarang().getKd_brg());
            ps.setBigDecimal(4, p.getLaba());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(PesanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
