package com.blackcode.project05.service;

import com.blackcode.project05.entity.Penjualan;
import com.blackcode.project05.repository.PenjualanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PenjualanServiceImpl implements PenjualanService{

    @Autowired
    private PenjualanRepository penjualanRepository;

    @Override
    public Penjualan getById(Long id) {
        Optional<Penjualan> optional = penjualanRepository.findById(id);
        Penjualan penjualan = null;
        if(optional.isPresent()){
            penjualan = optional.get();
        }else {
            throw new RuntimeException("Data Penjualan Id Not Found : "+id);
        }

        return penjualan;
    }

    @Override
    public Penjualan savePenjualan(Penjualan penjualan) {
        return penjualanRepository.save(penjualan);
    }

    @Override
    public List<Penjualan> getPenjualanAll() {
        return (List<Penjualan>) penjualanRepository.findAll();
    }

    @Override
    public Penjualan updatePenjualan(Penjualan penjualan, Long penjualanId) {
        Penjualan penjualanDB = penjualanRepository.findById(penjualanId).get();
        if(Objects.nonNull(penjualan.getPenjualanKuantitas()) && !"".equalsIgnoreCase(String.valueOf(penjualan.getPenjualanKuantitas()))){
            penjualanDB.setPenjualanKuantitas(penjualan.getPenjualanKuantitas());
        }
        if(Objects.nonNull(penjualan.getPenjualanTotal()) && !"".equalsIgnoreCase(String.valueOf(penjualan.getPenjualanTotal()))){
            penjualanDB.setPenjualanTotal(penjualan.getPenjualanTotal());
        }
        return penjualanRepository.save(penjualanDB);
    }

    @Override
    public void deletePenjualanById(Long penjualanId) {
        penjualanRepository.deleteById(penjualanId);
    }
}
