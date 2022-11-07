package com.blackcode.project05.controller.admin;

import com.blackcode.project05.entity.Barang;
import com.blackcode.project05.service.BarangServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping(value = "/barang")
public class BarangController {

    @Autowired
    private BarangServiceImpl barangServiceImpl;

    @GetMapping
    public String viewDataBarang(Model model){
        model.addAttribute("allBarangList", barangServiceImpl.getBarangAll());
        return "admin/barangData";
    }

    @GetMapping("/viewAddBarang")
    public String viewAddBarang(Model model){
        Barang barang = new Barang();
        model.addAttribute("barang", barang);
        return "admin/barangAdd";
    }

    @PostMapping("/save")
    public String saveBarang(@ModelAttribute("barang") Barang barang){
        barangServiceImpl.saveBarang(barang);
        return "redirect:/barang";
    }

    @GetMapping("/viewEditBarang/{id}")
    public String viewEditBarang(@PathVariable(value = "id") long id, Model model){
        Barang barang = barangServiceImpl.getBarangById(id);
        model.addAttribute("barang", barang);
        return "admin/barangEdit";
    }

    @GetMapping("/deleteBarang/{id}")
    public String deleteBarang(@PathVariable(value = "id") long id){
        barangServiceImpl.deleteBarang(id);
        return "redirect:/barang";
    }
}
