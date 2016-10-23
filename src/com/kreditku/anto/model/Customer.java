/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kreditku.anto.model;

import com.mirzaakhena.swing.basetablemodel.TableColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author antosamalona
 */
@Getter @Setter @AllArgsConstructor
public class Customer {
    
    	@TableColumn(header ="Kode Pelanggan")
	private String kd_pelanggan;
	
	@TableColumn(header ="Nama")
	private String nama;
	
	@TableColumn(header ="Alamat")
	private String alamat;
        
        public Customer(){}
}
