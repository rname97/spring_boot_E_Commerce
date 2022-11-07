package com.blackcode.project05.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Penjualan {

    private Long penjualanId;
    private int penjualanKuantitas;
    private int penjualanTotal;

    @ManyToOne
    @JoinColumn(name = "barangId")
    private Barang BarangId;


}
