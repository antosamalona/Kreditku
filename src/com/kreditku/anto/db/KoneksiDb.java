/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kreditku.anto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author antosamalona
 */
public class KoneksiDb {
    public static Connection connection;
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbku";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public Connection getConnection() throws SQLException {
        if (connection == null) {
            try {
                //load driver
                Class.forName(DB_DRIVER).newInstance();
                //koneksi ke database
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return connection;
    }
    
}
