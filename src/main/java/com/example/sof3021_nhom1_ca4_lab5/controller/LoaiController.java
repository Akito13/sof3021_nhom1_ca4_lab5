package com.example.sof3021_nhom1_ca4_lab5.controller;

import com.example.sof3021_nhom1_ca4_lab5.model.Loai;
import com.example.sof3021_nhom1_ca4_lab5.repository.LoaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LoaiController {
    @Autowired
    LoaiRepository loaiDao;

    @RequestMapping("/loai/index")
    public String index(Model model,
                        @ModelAttribute("loai") Loai loai,
                        RedirectAttributes params){
        List<Loai> loaiList = loaiDao.findAll();
        model.addAttribute("list", loaiList);
        Loai paramLoai = (Loai) params.getAttribute("loai");
        if(paramLoai != null) {
            loai = paramLoai;
        }
        model.addAttribute("loai", loai);
        return "loai";
    }

    @RequestMapping("/loai/create")
    public String create(@ModelAttribute("loai") Loai loai) {
        try {
            loaiDao.save(loai);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/loai/index";
    }

    @RequestMapping("/loai/update")
    public String update(@ModelAttribute("loai") Loai loai){
        try {
            loaiDao.save(loai);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/loai/index";
    }

    @RequestMapping("/loai/edit/{id}")
    public String edit (@PathVariable("id") Integer idE
                        ,RedirectAttributes params) {
        Loai loai =loaiDao.findById(idE).get();
        params.addAttribute("loai", loai);
        return "redirect:/loai/index";
    }

    @RequestMapping("/loai/delete/{id}")
    public String delete(@PathVariable("id") Integer idD, RedirectAttributes params){
        loaiDao.deleteById(idD);
        return "redirect:/loai/index";
    }

}
