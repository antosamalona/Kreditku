package com.kreditku.anto.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Pesan {
    private String id;
    private Customer customer;
    private Barang barang;
    private BigDecimal laba;
    private Integer lama;
    private BigDecimal cicilan;
    
    
}
