/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kreditku.anto.model;

import com.mirzaakhena.swing.basetablemodel.TableColumn;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author antosamalona
 */
@Getter @Setter @AllArgsConstructor
public class Barang {
    
    @TableColumn(header ="Kode Barang")
    private String kd_brg;
    
    @TableColumn(header ="Nama Barang")
    private String nm_barang;
    
    @TableColumn(header ="Harga Barang")
    private BigDecimal harga;

   

   
}
