package com.blackcode.project05.service;

import com.blackcode.project05.entity.Penjualan;

import java.util.List;

public interface PenjualanService {
    Penjualan getById(Long id);
    Penjualan savePenjualan(Penjualan penjualan);
    List<Penjualan> getPenjualanAll();


    Penjualan updatePenjualan(Penjualan penjualan, Long penjualanId);

    void deletePenjualanById(Long penjualanId);
}
