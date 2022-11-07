package com.blackcode.project05.controller.user;

import com.blackcode.project05.entity.Barang;
import com.blackcode.project05.service.BarangServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/client")
public class DashboardClientController {

    @Autowired
    private BarangServiceImpl barangServiceImpl;

    @GetMapping
    public String viewDashboardClient(Model model){
        List<Barang> barangs = barangServiceImpl.getBarangAll();
        ArrayList<Barang> barangs1 = (ArrayList<Barang>) barangs.stream().filter(x -> x.getBarangStock() > 0).collect(Collectors.toList());
        log.info("data Barang :{}",barangs1);
        model.addAttribute("allBarangList", barangs1);
        return "user/index";
    }

    @GetMapping("/viewBuyBarang/{barangId}")
    public String viewBuyBarang(@PathVariable("barangId") Long id, Model model){
        Barang barang = new Barang();
        Barang barangx = barangServiceImpl.getBarangById(id);
        model.addAttribute("barang", barangx);
        return "user/barangBuy";
    }

    @PostMapping("/save")
    public String saveBarang(@ModelAttribute("barang") Barang barang){
        Barang xx = new Barang();
        Barang barang1 = barangServiceImpl.getBarangById(barang.getBarangId());
        Long barangID = barang1.getBarangId();
        Long barangx = barang1.getBarangStock() - barang.getBarangStock();
        log.info("data Dikurangi :{}",barangx);
        xx.setBarangId(barang1.getBarangId());
        xx.setBarangId(barang1.getBarangId());
        xx.setBarangName(barang1.getBarangName());
        xx.setBarangHarga(barang1.getBarangHarga());
        xx.setBarangDeskripsi(barang1.getBarangDeskripsi());
        xx.setBarangStock(barangx);

        log.info("data Barangxx :{}",xx);
        barangServiceImpl.saveBarang(xx);
        return "redirect:/client";
    }

}
