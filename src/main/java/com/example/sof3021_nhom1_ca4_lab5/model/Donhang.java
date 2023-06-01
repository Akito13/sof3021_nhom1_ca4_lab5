package com.example.sof3021_nhom1_ca4_lab5.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Donhang {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MADH")
    private int madh;
    @Basic
    @Column(name = "NGAYXUAT")
    @Temporal(TemporalType.DATE)
    private Date ngayxuat;
    @ManyToOne
    @JoinColumn(name = "MAKH", referencedColumnName = "MAKH")
    private User makh;
    @OneToMany(mappedBy = "madh")
    private List<Donhangchitiet> billDetails;

    public int getMadh() {
        return madh;
    }

    public void setMadh(int madh) {
        this.madh = madh;
    }

    public Date getNgayxuat() {
        return ngayxuat;
    }

    public void setNgayxuat(Date ngayxuat) {
        this.ngayxuat = ngayxuat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donhang donhang = (Donhang) o;
        return madh == donhang.madh && Objects.equals(ngayxuat, donhang.ngayxuat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(madh, ngayxuat);
    }

    public User getMakh() {
        return makh;
    }

    public void setMakh(User makh) {
        this.makh = makh;
    }

    public List<Donhangchitiet> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<Donhangchitiet> billDetails) {
        this.billDetails = billDetails;
    }
}
