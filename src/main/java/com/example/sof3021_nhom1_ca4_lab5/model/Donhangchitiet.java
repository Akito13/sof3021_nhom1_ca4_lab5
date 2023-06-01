package com.example.sof3021_nhom1_ca4_lab5.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Donhangchitiet {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MADHCT")
    private int madhct;
    @Basic
    @Column(name = "SOLUONG")
    private Integer soluong;
    @Basic
    @Column(name = "TONGTIEN")
    private BigDecimal tongtien;
    @ManyToOne
    @JoinColumn(name = "MADH", referencedColumnName = "MADH")
    private Donhang madh;
    @ManyToOne
    @JoinColumn(name = "MASACH", referencedColumnName = "MASACH")
    private Sach masach;

    public int getMadhct() {
        return madhct;
    }

    public void setMadhct(int madhct) {
        this.madhct = madhct;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public BigDecimal getTongtien() {
        return tongtien;
    }

    public void setTongtien(BigDecimal tongtien) {
        this.tongtien = tongtien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donhangchitiet that = (Donhangchitiet) o;
        return madhct == that.madhct && Objects.equals(soluong, that.soluong) && Objects.equals(tongtien, that.tongtien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(madhct, soluong, tongtien);
    }

    public Donhang getMadh() {
        return madh;
    }

    public void setMadh(Donhang madh) {
        this.madh = madh;
    }

    public Sach getMasach() {
        return masach;
    }

    public void setMasach(Sach masach) {
        this.masach = masach;
    }
}
