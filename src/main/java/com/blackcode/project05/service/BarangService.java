package com.blackcode.project05.service;

import com.blackcode.project05.entity.Barang;

import java.util.List;

public interface BarangService {
    Barang getBarangById(long barangId);
    Barang saveBarang(Barang barang);
    List<Barang> getBarangAll();

    Barang updateBarang(Barang barang, Long barangId);
    void deleteBarang(Long barangId);
}
