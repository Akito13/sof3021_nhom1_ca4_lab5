package com.example.sof3021_nhom1_ca4_lab5.controller;

import com.example.sof3021_nhom1_ca4_lab5.model.Sach;
import com.example.sof3021_nhom1_ca4_lab5.repository.SachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class SachController {
    @Autowired
    SachRepository sachDao;

    @RequestMapping("/sach/sort")
    public String sort(Model model,
                       @RequestParam("by") Optional<String> by)
    {
        Sort sort = Sort.by(Sort.Direction.DESC, by.orElse("gia"));
        List<Sach> sachList = sachDao.findAll(sort);
        model.addAttribute("list", sachList);
        return "sach";
    }
    @RequestMapping("/sach/page")
    public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
//        p.filter(integer -> integer >= 0 && integer < ).orElse(0);
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Sach> page = sachDao.findAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("list", page.getContent());
        return "page";
    }

    @RequestMapping("/sach/detail/{id}")
    public String getSachDetail(@PathVariable("id") Optional<Integer> maSach,
                                Model model) {

        maSach.ifPresentOrElse(i -> {
            Map<Integer, Sach> sachMap = sachDao.findByIdAndGiaMap(i);
            if(sachMap.isEmpty()) {
                model.addAttribute("error", "Không tìm thấy sách!");
            } else {
                Sach sach = sachMap.get(i);
                sachMap.remove(i);
                if(sach != null) {
                    model.addAttribute("sach", sach);
                    model.addAttribute("list", sachMap);
                } else {
                    model.addAttribute("error", "Không tìm thấy sách !!");
                }
            }
        }, () -> model.addAttribute("error", "Không có id để kiếm sách"));
        return "them";
    }
}
