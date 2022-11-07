package com.blackcode.project05.service;

import com.blackcode.project05.entity.Barang;
import com.blackcode.project05.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BarangServiceImpl implements BarangService{
    @Autowired
    private BarangRepository barangRepository;

    @Override
    public Barang getBarangById(long barangId) {
        Optional<Barang> optional = barangRepository.findById(barangId);
        Barang barang = null;
        if(optional.isPresent()){
            barang = optional.get();
        }else {
            throw new RuntimeException("Barang Not Found ID :"+barangId);
        }
        return barang;
    }

    @Override
    public Barang saveBarang(Barang barang) {
        return barangRepository.save(barang);
    }

    @Override
    public List<Barang> getBarangAll() {
        return barangRepository.findAll();
    }

    @Override
    public Barang updateBarang(Barang barang, Long barangId) {
        Barang barangDB = barangRepository.findById(barangId).get();
        if(Objects.nonNull(barang.getBarangName()) && !"".equalsIgnoreCase(barang.getBarangName())){
            barangDB.setBarangName(barang.getBarangName());
        }
        if(Objects.nonNull(barang.getBarangHarga()) && !"".equalsIgnoreCase(String.valueOf(barang.getBarangHarga()))){
            barangDB.setBarangHarga(barang.getBarangHarga());
        }
        if(Objects.nonNull(barang.getBarangDeskripsi()) && !"".equalsIgnoreCase(barang.getBarangDeskripsi())){
            barangDB.setBarangDeskripsi(barang.getBarangDeskripsi());
        }
        if(Objects.nonNull(barang.getBarangStock()) && !"".equalsIgnoreCase(String.valueOf(barang.getBarangStock()))){
            barangDB.setBarangHarga(barang.getBarangStock());
        }

        return barangRepository.save(barangDB);
    }

    @Override
    public void deleteBarang(Long barangId) {
        barangRepository.deleteById(barangId);
    }
}
