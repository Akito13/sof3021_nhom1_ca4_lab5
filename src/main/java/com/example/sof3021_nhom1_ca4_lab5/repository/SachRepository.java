package com.example.sof3021_nhom1_ca4_lab5.repository;

import com.example.sof3021_nhom1_ca4_lab5.model.Sach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface SachRepository extends JpaRepository<Sach, Integer> {
    @Query("select s from Sach s " +
            "where s.gia <= (select sach.gia+10 from Sach sach where sach.masach = ?1) " +
            "and s.gia >= (select sa.gia-10 from Sach sa where sa.masach = ?1)")
    List<Sach> findByIdAndGia(Integer maSach);
    default Map<Integer, Sach> findByIdAndGiaMap(Integer maSach) {
        return findByIdAndGia(maSach).stream().collect(Collectors.toMap(Sach::getMasach, sach -> sach));
    };
}
