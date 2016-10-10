/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kreditku.anto.main;

import com.kreditku.anto.db.KoneksiDb;
import com.kreditku.anto.ui.MainMenu;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antosamalona
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            KoneksiDb.connection = (Connection) new KoneksiDb().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
	MainMenu main = new MainMenu();
        main.setLocationRelativeTo(null);
	main.setVisible(true);
    }
    
}
