package com.blackcode.project05.repository;

import com.blackcode.project05.entity.Penjualan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenjualanRepository extends CrudRepository<Penjualan, Long> {
}
